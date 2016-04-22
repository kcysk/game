package net.keshen.base.surface;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.keshen.base.drawable.Drawable;
import net.keshen.base.frame.AbstractBasePanel;
import net.keshen.base.graphics.Canvas;
import net.keshen.base.graphics.support.JCanvas;
import net.keshen.base.graphics.support.JPaint;
import net.keshen.base.threads.BasePanelThread;
import net.keshen.logger.Logger;
import net.keshen.logger.LoggerManager;

/**
 * @author shenke
 * @date 2016-4-22 下午1:47:51
 */
public class GamePanel extends AbstractBasePanel{

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
	
	
	private Map<Integer,List<Drawable>> picLayer = new HashMap<Integer, List<Drawable>>(); 
	private Map<Integer,List<Drawable>> addLayer = new HashMap<Integer, List<Drawable>>();
	private Map<Integer,List<Drawable>> removeLayer = new HashMap<Integer, List<Drawable>>();
	
	private int[] picLayerIds = new int[0];
	
	private JCanvas canvas = new JCanvas();
	private	JPaint paint;
	private BasePanelThread gameThread ;
	
	private boolean changeLayer = false;
	
	public GamePanel(){
		paint = (JPaint) canvas.getPaint();
		paint.setAntiAlias(true);
		paint.setDither(true);
		gameThread = new BasePanelThread(this,canvas);
	}
	
	public void action() throws Exception{
		gameThread.start();
	}
	
	/**
	 * 绘制指定Id的图层
	 * @param layerIds
	 */
	public void onDraw(int[] layerIds){
		updateComponetLayer(CHANGE_MODEL_UPDATE,null,-99);
		
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
	public void onDraw(Canvas canvas){
		updateComponetLayer(CHANGE_MODEL_UPDATE,null,0);
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
	
	public synchronized void paint(Graphics g) {
		//g.drawImage(ImageUtils.getBitmapByAssertNoPath("bg_0").getImage(), 0, 0, 800, 750, null);
		g.drawImage(canvas.getCanvas(), 0, 0, null);
	}
	
	/**
	 * 更新图层
	 */
	public synchronized void updateComponetLayer(int model,Drawable componet,int layerId){
		
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
	private void updateLayerIds(int id,int model){
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

	public void updateComponetLayer(int model, Drawable drawable) {
		
	}
	

}
