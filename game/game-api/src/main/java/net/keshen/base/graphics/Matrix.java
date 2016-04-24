package net.keshen.base.graphics;
/**
 * 矩阵接口
 * @author shenke
 * @date 2016年2月21日上午11:36:51
 * @version 1.0
 */
public interface Matrix {
	
	/**
	 * 设置平移
	 * @param x
	 * @param y
	 */
	public void setTranslate(float x,float y);
	
	/**
	 * 重置矩阵
	 */
	public void reset();
	
	/**
	 * 矩阵旋转
	 * @param x
	 * @param y
	 * @param angle
	 */
	public void setRotate(double x,double y,double angle);
	
	/**
	 * 缩放
	 * @param x
	 * @param y
	 */
	public void setScale(double x,double y);

}