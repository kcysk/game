package net.keshen.base.graphics;


/**
 * 画布
 * @author shenke
 * @date 2016年2月21日上午11:40:42
 * @version 1.0
 */
public interface Canvas {
	
	public void draw(Bitmap bitmap,Matrix matrix,Paint paint);
	
	public void draw(Bitmap bitmap,double x,double y,Paint paint);
	
	public void clear();
}
