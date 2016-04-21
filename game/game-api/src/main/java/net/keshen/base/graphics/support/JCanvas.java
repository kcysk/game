package net.keshen.base.graphics.support;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import net.keshen.base.basecomponet.GameConstant;
import net.keshen.base.graphics.Bitmap;
import net.keshen.base.graphics.Canvas;
import net.keshen.base.graphics.Matrix;
import net.keshen.base.graphics.Paint;
import net.keshen.util.ImageUtils;

/**
 * 画布
 * @author shenke
 * @date 2016-3-29 下午1:35:52
 */
public class JCanvas implements Canvas{

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
		//canvas = ImageUtils.getBitmapByAssertNoPath("bg_0").getImage();
		canvas = new BufferedImage((int)gameWindow.getWidth(), (int)gameWindow.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
		//canvas = ImageUtils.getImage("start.jpg",ImageUtils.BG_PATH);
		paint = new JPaint(canvas);
	}
	public JCanvas(int width,int height){
		canvas = new BufferedImage(width,height,BufferedImage.TYPE_4BYTE_ABGR);
		paint = new JPaint(canvas);
	}
	
	
	public void draw(Bitmap bitmap, Matrix matrix, Paint paint) {
		
		((JPaint)paint).getGraphics().drawImage(bitmap.getImage(), ((JMatrix)matrix).getTransForm(), null);
	}

	public void draw(Bitmap bitmap, double x, double y, Paint paint) {
		this.paint.getGraphics().drawImage(bitmap.getImage(), (int)x, (int)y, null);
	}
	
	public void clear() {
		System.out.println("clear");
		//setCanvas();
		//this.paint.getGraphics().clearRect(0, 0, GameConstant.getWidth(), GameConstant.getHeight());
	}
	
	private void setCanvas(){
		this.canvas = new BufferedImage((int)gameWindow.getWidth(), (int)gameWindow.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
		this.paint = new JPaint(canvas);
	}
}
