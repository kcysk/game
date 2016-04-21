package net.keshen.base.graphics;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * 画笔
 * @author shenke
 * @date 2016年2月21日上午11:31:44
 * @version 1.0
 */
public interface Paint {

	
	public Graphics2D getGraphics();
	
	/**
	 * 设置字体
	 * @param obj
	 */
	public void setTypeface(Object obj); 
	/**
	 * 
	 * @param tf
	 */
	public void setAntiAlias(boolean tf);
	/**
	 * 
	 * @param tf
	 */
	public void setFilterBitmap(boolean tf);
	/**
	 *  设置抗锯齿
	 * @param tf
	 */
	public void setDither(boolean tf);	
	/**
	 * 根据不同分辨率设置字体大小
	 * @param size
	 */
	public void setTextSize(int size);  // 
	/**
	 * 设置颜色
	 * @param color
	 */
	public void setColor(int rgb);
	/**
	 * 设置颜色
	 * @param color
	 */
	public void setColor(Color color);
}
