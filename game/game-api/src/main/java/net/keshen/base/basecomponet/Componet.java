package net.keshen.base.basecomponet;

import net.keshen.base.drawable.DrawableAdapter;
import net.keshen.base.graphics.Bitmap;

/**
 * 基本组件,所有的组件都要继承这个抽象类
 * @author shenke
 * @date 2016年2月21日下午7:31:25
 * @version 1.0
 */
public abstract class Componet extends DrawableAdapter{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8993487076155540061L;
	
	protected Bitmap bg;
	
	private int layout_x;
	private int layout_y;
	
	/**
	 * 获取组件在屏幕上的x坐标
	 * @return
	 */
	public int getLayout_x() {
		return layout_x;
	}
	
	/**
	 * 设置组件在屏幕上的y坐标
	 * @param layout_x
	 */
	public void setLayout_x(int layout_x) {
		this.layout_x = layout_x;
	}
	
	/**
	 * 获取组件在屏幕上的y坐标
	 * @return
	 */
	public int getLayout_y() {
		return layout_y;
	}
	
	/**
	 * 设置左键在屏幕上的y坐标
	 * @param layout_y
	 */
	public void setLayout_y(int layout_y) {
		this.layout_y = layout_y;
	}
	
	/**
	 * 设置背景图片
	 * @param bg
	 */
	public void setBg(Bitmap bg) {
		this.bg = bg;
	}
	
}
