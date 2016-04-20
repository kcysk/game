package net.keshen.base.drawable;

import java.io.Serializable;

import net.keshen.base.graphics.Canvas;
import net.keshen.base.graphics.Matrix;
import net.keshen.base.graphics.Paint;
import net.keshen.base.graphics.support.JMatrix;

/**
 * 所有运动的物体都要继承该类
 * @author shenke
 * @date 2016年2月21日下午7:33:38
 * @version 1.0
 */
public abstract class DrawableAdapter implements Drawable,Serializable{

	protected String name;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8863826318003498435L;
	private Matrix matrix = new JMatrix();
	
	public Matrix getMatrix(){
		return matrix;
	}

	public void onDraw(Canvas canvas, Paint paint) {
		canvas.draw(this.getCurrentPic(), this.getMatrix(), paint);
		System.out.println("绘制："+getDrawableName());
	}

	public void setDrawableName(String name) {
		this.name = name;
	}

	public String getDrawableName() {
		return this.name;
	}
	
}
