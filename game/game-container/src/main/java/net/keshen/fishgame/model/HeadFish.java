package net.keshen.fishgame.model;

import java.util.List;

import net.keshen.fishgame.entity.Movement;
import net.keshen.fishgame.thread.FishRunThread;
/**              .
 * 				 .
 *               .
 *               .
 *               .
 *               .   
 *               .    
 * . . . . . . . . . . . . . . . . . 
 *               .
 *               .
 *               .
 *               .
 *               .
 *               .
 * 领头鱼
 * @author shenke
 * @date 2016-3-8 下午2:31:19
 */
public class HeadFish implements Movement{
	
	private boolean isNew;		//是否是新生成的鱼
	private float fishX;			//鱼的x坐标
	private float fishY;			//y坐标
	private float lastX;				
	private float lastY;			
	
	private int[] fishOutlinePoint;	//鱼的外接矩阵的主要点的x、y坐标
	private List<Fish> shoal;		//鱼群
	
	private float currentRotate;	//当前旋转的角度
	private int rotateDirection;	//旋转的方向
	
	private String directionX;
	private String directionY;
	
	private FishRunThread runThread;//鱼游动线程
	private Fish fish;				//当前鱼也应该属于鱼群
	
	
	public boolean isNew() {
		return isNew;
	}
	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}
	public float getFishX() {
		return fishX;
	}
	public void setFishX(float fishX) {
		this.lastX = this.fishX;
		this.fishX = fishX;
	}
	public float getFishY() {
		return fishY;
	}
	public void setFishY(float fishY) {
		this.lastY = this.fishY;
		this.fishY = fishY;
	}
	public float getLastX() {
		return lastX;
	}
	public void setLastX(float lastX) {
		this.lastX = lastX;
	}
	public float getLastY() {
		return lastY;
	}
	public void setLastY(int lastY) {
		this.lastY = lastY;
	}
	public int[] getFishOutlinePoint() {
		return fishOutlinePoint;
	}
	public void setFishOutlinePoint(int[] fishOutlinePoint) {
		this.fishOutlinePoint = fishOutlinePoint;
	}
	public List<Fish> getShoal() {
		return shoal;
	}
	public void setShoal(List<Fish> shoal) {
		this.shoal = shoal;
	}
	public float getCurrentRotate() {
		return currentRotate;
	}
	public void setCurrentRotate(float newRoate) {
		this.currentRotate = newRoate;
	}
	public int getRotateDirection() {
		return rotateDirection;
	}
	public void setRotateDirection(int rotateDirection) {
		this.rotateDirection = rotateDirection;
	}
	public FishRunThread getRunThread() {
		return runThread;
	}
	public void setRunThread(FishRunThread runThread) {
		this.runThread = runThread;
	}
	public Fish getFish() {
		return fish;
	}
	public void setFish(Fish fish) {
		this.fish = fish;
	}
	public String getDirectionX() {
		return directionX;
	}
	public void setDirectionX(String directionX) {
		this.directionX = directionX;
	}
	public String getDirectionY() {
		return directionY;
	}
	public void setDirectionY(String directionY) {
		this.directionY = directionY;
	}

	
}
