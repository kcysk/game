package net.keshen.fishgame.manager;

import net.keshen.base.basecomponet.GameConstant;
import net.keshen.fishgame.entity.Movement;
import net.keshen.fishgame.model.HeadFish;
import net.keshen.util.StringUtils;

/**
 * 鱼群游动路径管理器
 * @author shenke
 * @date 2016-3-9 上午9:06:41
 */
public class PathManager {
	
	/** 直行*/
	public static final int PATH_MODEL_STRAIGHT = 0;
	/** 旋转*/
	public static final int PATH_MODEL_ROTATE = 1;
	
	/**
	 * 获取每种鱼的默认路径 {{方式 行进距离},...}
	 * @param fish
	 * @return
	 */
	public static int[][] getDefaultPath(HeadFish fish){
		int maxRotate = fish.getFish().getInfo().getMaxRotate();
		float currentRotate = fish.getCurrentRotate();
		int[][] path = null;
		//鱼是新生成的，其未进入屏幕--》直线
		if(fish.getFishX()+fish.getFish().getPicWidth()<0||fish.getFishX()>GameConstant.getWidth()){
			path = new int[1][];
			path[0][0] = PATH_MODEL_STRAIGHT;
			path[0][1] = (int)(Math.random()*GameConstant.getWidth() +1);
			return path;
		}
		//直线
		if(maxRotate==0){
			path = new int[][]{{PATH_MODEL_STRAIGHT,GameConstant.getWidth()*2}} ;
			return path;
		}
		else if(maxRotate==60){
			path = new int[][];
			//角度为负
			if(Movement.MOVE_DIRECTION_UP.equals(fish.getDirectionY())){
				if(Movement.MOVE_DIRECTION_LEFT.equals(fish.getDirectionX())){
					if(maxRotate == 180-Math.abs(currentRotate)){
						currentRotate = 180+currentRotate;
					}
					float newRotate = (float) (maxRotate*Math.random())+1;
				}
				else if(Movement.MOVE_DIRECTION_RIGHT.equals(fish.getDirectionX())){
					
				}
				else if(net.keshen.util.StringUtils.isEmpty(fish.getDirectionX())){
					
				}
			}
			else if(Movement.MOVE_DIRECTION_DOWN.equals(fish.getDirectionY())){
				if(Movement.MOVE_DIRECTION_RIGHT.equals(fish.getDirectionX())){
					
				}
			}
			//X轴直线前进
			else if(StringUtils.isEmpty(fish.getDirectionY())){
				//向上方旋转
				if(Math.random()>0.5){
					float newRoate = (float) (maxRotate*Math.random() + 1);
					fish.setCurrentRotate(newRoate);
				}
				else{
					
				}
			}
			
		}
		else if(maxRotate==70){
			
		}
		else if(maxRotate==90){
			
		}
		else if(maxRotate==360){
			
		}
		return null;
	}
}
