package net.keshen.base.surface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

import net.keshen.base.basecomponet.GameConstant;
import net.keshen.base.drawable.Drawable;
import net.keshen.base.graphics.Bitmap;
import net.keshen.base.graphics.Canvas;
import net.keshen.base.graphics.Matrix;
import net.keshen.base.graphics.Paint;
import net.keshen.base.graphics.support.JMatrix;
import net.keshen.base.surface.GameSurface.JCanvas.JPaint;
import net.keshen.logger.Logger;
import net.keshen.logger.LoggerManager;
import net.keshen.util.ImageUtils;

/**
 * 进行画图操作的主要图层,这里重新定义图层
 * @author shenke
 * @date 2016年2月21日上午11:42:54
 * @version 1.0
 */
public class GameSurface extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1351564764030582248L;
	
	private static final Logger log = LoggerManager.getLogger(GameSurface.class);
	/** 添加元素到图层*/
	public static final int CHANGE_MODEL_ADD = 0;
	/** 从图层中移除元素*/
	public static final int CHANGE_MODEL_REMOVE = 1;
	/** 更新图层元素*/
	public static final int CHANGE_MODEL_UPDATE = 2;
	
	public static final int CHANGE_SURFACE_ADD = 0;
	
	public static final int CHANGE_SURFACE_REMOVE = 1;
	
	public static final int CHANGE_SURFACE_UPDATE = 2;
	
	private Map<Integer,List<Drawable>> picLayer = new HashMap<Integer, List<Drawable>>(); 
	private Map<Integer,List<Drawable>> addLayer = new HashMap<Integer, List<Drawable>>();
	private Map<Integer,List<Drawable>> removeLayer = new HashMap<Integer, List<Drawable>>();
	
	private int[] picLayerIds = new int[0];
	
	private JCanvas canvas = new JCanvas();
	private	JPaint paint;
	private MainSurfaceThread gameThread ;
	
	private boolean changeLayer = false;
	
	public GameSurface(){
		paint = (JPaint) canvas.getPaint();
		gameThread = new MainSurfaceThread(this);
	}
	
	public void action() throws Exception{
		gameThread.start();
	}
	
	/**
	 * 绘制指定Id的图层
	 * @param layerIds
	 */
	public void onDraw(int[] layerIds){
		updatePicLayer(CHANGE_MODEL_UPDATE,-99,null);
		
		for (int id : layerIds) {
			for (Drawable draw : picLayer.get(id)) {
				draw.onDraw(canvas, paint);
			}
		}
		System.gc();
	}
	
	/**
	 * 绘制所有图层
	 */
	public void onDraw(){
		updatePicLayer(CHANGE_MODEL_UPDATE,0,null);
		for (int id : picLayerIds) {
			for (Drawable draw : picLayer.get(id)) {
				draw.onDraw(canvas, paint);
			}
		}
		System.gc();
	}
	
	public synchronized Canvas lockCanvas(){
		return canvas;
	}
	
	public void unLockCanvas(Canvas canvas){
		repaint();
	}
	/**
	 * 更新图层
	 */
	public synchronized void updatePicLayer(int model,int layerId,Drawable componet){
		
		switch(model){
			case CHANGE_MODEL_UPDATE:
				if(changeLayer){
					for (Integer id : addLayer.keySet()) {
						for(Drawable cp:addLayer.get(id)){
							if(this.picLayer.get(id)==null){
								log.debug("图层:"+id+"不存在,创建该图层!");
								picLayer.put(id, new ArrayList<Drawable>());
								//更新图层Ids
								updateLayerIds(id,CHANGE_MODEL_ADD);
							}
							picLayer.get(id).add(cp);
							log.info("图层:"+id+"已放入"+cp.getDrawableName());
						}
					}
					//清空
					addLayer.clear();
					//删除元素
					for (Integer id : removeLayer.keySet()) {
						try {
							this.picLayer.get(id).removeAll(this.removeLayer.get(id));
						} catch (Exception e) {
							log.info("图层:"+id+"不存在,无法移除该图层内的元素!");
						}
					}
					this.removeLayer.clear();
					changeLayer = false;
				}
				break;
			case CHANGE_MODEL_REMOVE:
				//将待移除元素放入移除队列
				if(this.removeLayer.get(layerId)==null){
					this.removeLayer.put(layerId, new ArrayList<Drawable>());
				}
				this.removeLayer.get(layerId).add(componet);
				changeLayer = true;
				break;
			case CHANGE_MODEL_ADD:
				//将待移除元素放入添加元素队列
				if(this.addLayer.get(layerId)==null){
					this.addLayer.put(layerId, new ArrayList<Drawable>());
				}
				this.addLayer.get(layerId).add(componet);
				changeLayer = true;
				break;
		}
	}
	
	/**
	 * 更新图层Id
	 * @param id
	 * @param model
	 */
	public void updateLayerIds(int id,int model){
		switch(model){
			case CHANGE_MODEL_ADD:
				//初始化时
				if(picLayerIds.length==0){
					picLayerIds = new int[1];
					picLayerIds[0] = id;
				}
				else{
					int[] newPicLayerIds = new int[picLayerIds.length+1];
					//对图层Id进行排序
					for(int i=0;i<picLayerIds.length;i++){
						if(picLayerIds[i]<id){
							newPicLayerIds[i] = picLayerIds[i];
						}
						else{
							for(int t=newPicLayerIds.length;t>i;t--){
								newPicLayerIds[t] = picLayerIds[t-1];
							}
							newPicLayerIds[i] = id;
							break;
						}
						//到了最后都没有比其大的元素,则将新的Id放在最后
						if(i==newPicLayerIds.length-1){
							newPicLayerIds[newPicLayerIds.length-1] = id;
						}
					}
					//将picLayerIds指向新的数组
					picLayerIds = newPicLayerIds;
				}
				break;
			//删除图层操作
			case CHANGE_MODEL_REMOVE:
				if(picLayerIds.length==0){
					log.error("图层:"+id+"不存在,无法删除该图层");
				}
				else{
					int[] newPicLayerIds = new int[picLayerIds.length];
					for (int i=0;i<picLayerIds.length;i++) {
						if(picLayerIds[i]==id){
							for (int t=i+1;t<newPicLayerIds.length+1;t++) {
								newPicLayerIds[t-1] = picLayerIds[t];
							}
							break;
						}
						else{
							newPicLayerIds[i] = picLayerIds[i];
						}
					}
					picLayerIds = newPicLayerIds;
				}
				break;
		}
	}
	
	
	public synchronized void paint(Graphics g) {
		g.drawImage(canvas.getCanvas(), 0, 0, null);
		canvas.clear();
	}
	
	/**
	 * 绘制游戏的所有元素的线程
	 * @author shenke
	 *
	 */
	class MainSurfaceThread extends Thread{
		
		private GameSurface surface;
		
		public MainSurfaceThread(GameSurface surface) {
			this.surface = surface;
		}
		
		
		public void run() {
			super.run();
			Canvas canvas = null;
			while(true){
				try {
					//TODO
					canvas = lockCanvas();
					if(canvas!=null){
						surface.onDraw();
					}
					unLockCanvas(canvas);
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					try {
						unLockCanvas(canvas);
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	/**
	 * 画布,其实就是绘制"一大幅"图片
	 * @author shenke
	 *verilog
	 */
	static class JCanvas implements Canvas{
		private static Bitmap canvasBit = null;
		private static AffineTransform gameWindowTransform = null;
		static{
			canvasBit = ImageUtils.getBitmapByAssert("bg_0");
			gameWindowTransform = new AffineTransform();
			gameWindowTransform.setToTranslation(0, 0);
		}
		
		private Dimension gameWindow = Toolkit.getDefaultToolkit().getScreenSize();
		
		private BufferedImage canvas ;
		private JPaint paint;
		
		public Paint getPaint(){
			return paint;
		}
		
		/**
		 * 获取画布
		 * @return
		 */
		public BufferedImage getCanvas(){
			return canvas;
		}
		
		/**
		 * 默认构造器,
		 * 创建默认大小的窗口覆盖整个屏幕
		 */
		public JCanvas(){
//			Bitmap canvasBit = ImageUtils.getImage("bg_0");
//			if(canvasBit!=null){
//				canvas = canvasBit.getImage();
//			}else{
//			}
			canvas = new BufferedImage((int)gameWindow.getWidth(), (int)gameWindow.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
			paint = new JPaint(canvas);
		}
		
		public JCanvas(int width,int height){
			canvas = new BufferedImage(width,height,BufferedImage.TYPE_4BYTE_ABGR);
			paint = new JPaint(canvas);
		}
		
		
		
		public void draw(Bitmap bitmap, Matrix matrix, Paint paint) {
			//this.paint.getGraphics().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
			//this.paint.getGraphics().drawImage(canvasBit.getImage(),gameWindowTransform , null);
			this.paint.getGraphics().drawImage(bitmap.getImage(), ((JMatrix)matrix).getTransForm(), null);
		}

		
		public void draw(Bitmap bitmap, double x, double y, Paint paint) {
			this.paint.getGraphics().drawImage(bitmap.getImage(), (int)x, (int)y, null);
		}
		/**
		 * 画笔,用于绘制图形
		 * @author shenke
		 *
		 */
		class JPaint implements Paint{
			Graphics2D graphics;
			
			public JPaint(BufferedImage canvas) {
				this.graphics = (Graphics2D) canvas.getGraphics();
			}
			
			public Graphics2D getGraphics(){
				return this.graphics;
			}
			
			
			public void setTypeface(Object obj) {
				
			}

			
			public void setAntiAlias(boolean tf) {
				if(tf){
					RenderingHints renderQuality = graphics.getRenderingHints();
					if(renderQuality==null){
						renderQuality = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
						graphics.setRenderingHints(renderQuality);
					}
					else{
						renderQuality.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
						graphics.setRenderingHints(renderQuality);
					}
					//侧重画质
					if(GameConstant.isQuality()){
						//TODO
					}
					renderQuality.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
					renderQuality.put(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
					renderQuality.put(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
					renderQuality.put(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
				}
			}

			
			public void setFilterBitmap(boolean tf) {
				
			}

			
			public void setDither(boolean tf) {
				if(tf){
					RenderingHints renderQuality = graphics.getRenderingHints();
					if(renderQuality==null){
						renderQuality = new RenderingHints(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
						graphics.setRenderingHints(renderQuality);
					}
					else{
						renderQuality.put(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
						graphics.setRenderingHints(renderQuality);
					}
					
				}
				
			}

			
			public void setTextSize(int size) {
				
			}

			
			public void setColor(int rgb) {
				graphics.setColor(new Color(rgb));
			}

			
			public void setColor(Color color) {
				graphics.setColor(color);
			}
			
		}
		
		public void clear() {
			canvas = new BufferedImage((int)gameWindow.getWidth(), (int)gameWindow.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);//canvasBit.getImage();
		}
		
	}
	
	
}
