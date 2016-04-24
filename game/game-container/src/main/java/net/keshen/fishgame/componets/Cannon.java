package net.keshen.fishgame.componets;

import java.util.Map;

import net.keshen.base.drawable.DrawableAdapter;
import net.keshen.base.graphics.Bitmap;
import net.keshen.base.graphics.Canvas;
import net.keshen.base.graphics.Matrix;
import net.keshen.base.graphics.Paint;
import net.keshen.fishgame.enumration.FireType;

/**
 * 大炮
 * @author shenke
 * @date 2016年2月21日下午8:04:39
 * @version 1.0
 */
public class Cannon extends DrawableAdapter{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6730846566702756181L;
	/** 大炮最小型号*/
	public static final String MIN_VERSION = "1";
	/** 大炮最大型号*/
	public static final String MAX_VERSION = "11";
	
	private Bitmap[] cannonImage;
	 
	private int currentImageId;
	private int cannoRotate_x;//旋转点的x坐标
	private int cannoRotate_y;//旋转点的y坐标
	
	private float x;
	private float y;
	
	private FireType type;
	
	public Cannon(){
		type = FireType.FIRE1;
		currentImageId = 0;
	}
	
	
	public Bitmap getCurrentPic() {
		return cannonImage[currentImageId];
	}

	public int getPicWidth() {
		return getCurrentPic().getWidth();
	}

	
	public int getPicHeight() {
		return getCurrentPic().getHeight();
	}

	
	public void onDraw(Canvas canvas, Paint paint) {
		canvas.draw(getCurrentPic(), getMatrix(), paint);
	}

	
	public Matrix getPicMatrix() {
		return getMatrix();
	}

	
	public String getDrawableName() {
		return null;
	}

	public int getCurrentImageId() {
		return currentImageId;
	}

	public void setCurrentImageId(int currentImageId) {
		this.currentImageId = currentImageId;
	}

	public int getCannoRotate_x() {
		return cannoRotate_x;
	}

	public void setCannoRotate_x(int cannoRotate_x) {
		this.cannoRotate_x = cannoRotate_x;
	}

	public int getCannoRotate_y() {
		return cannoRotate_y;
	}

	public void setCannoRotate_y(int cannoRotate_y) {
		this.cannoRotate_y = cannoRotate_y;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public FireType getType() {
		return type;
	}

	public void setType(FireType type) {
		this.type = type;
	}

	public Bitmap[] getCannonImage() {
		return cannonImage;
	}

	public void setCannonImage(Bitmap[] cannonImage) {
		this.cannonImage = cannonImage;
	}

}
