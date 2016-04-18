package net.keshen.fishgame.thread;

import java.util.List;

import net.keshen.fishgame.constant.FishGameConstant;
import net.keshen.fishgame.info.FishInfo;
import net.keshen.fishgame.manager.game.GameManager;
import net.keshen.fishgame.model.Fish;
import net.keshen.fishgame.model.HeadFish;

/**
 * 鱼游动线程
 * 
 * @author shenke
 * @date 2016-3-8 下午3:33:15
 */
public class FishRunThread extends Thread {

	private List<Fish> shoal;

	private HeadFish headFish;
	private FishInfo fishInfo;

	public FishRunThread(HeadFish headFish) {
		this.headFish = headFish;
		this.shoal = headFish.getShoal();
		this.fishInfo = headFish.getFish().getInfo();
	}

	@Override
	public void run() {
		try {
			while (GameManager.isRunning()) {
				while(GameManager.isRunning()&&!GameManager.isPause()){
					//不需要划分鱼群的运动方向
					headFish.setFishX(headFish.getFishX()+fishInfo.getActSpeed()*Math.sin(headFish.getCurrentRotate()));
					headFish.setFishY(headFish.getFishX()+fishInfo.getActSpeed()*Math.cos(headFish.getCurrentRotate()));
					refreshOutlinePoint();
					break;
				}
				Thread.sleep((long) (FishGameConstant.FISH_RUN_SLEEP/headFish.getCurrentRotate()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//刷新外接矩形的四个重要的坐标
	private void refreshOutlinePoint(){
		for (Fish fish : shoal) {
			fish.getFishOutRectPoint()[0] = (int) (headFish.getFishX()+fish.getDistHeadFishX());
			fish.getFishOutRectPoint()[1] = (int) (headFish.getFishX()+fish.getDistHeadFishX()+fish.getPicWidth());
			fish.getFishOutRectPoint()[2] = (int) (headFish.getFishY() + fish.getDistheadFishY());
			fish.getFishOutRectPoint()[3] = (int) (headFish.getFishY() + fish.getDistheadFishY() +fish.getPicHeight());
		}
	}
	
	//判断鱼是否被捕捉
	private boolean isCatch(Fish fish){
		
		return false;
	}
	
	//检查是否游出屏幕
	private boolean checkOutScreen(){
		
		return false;
	}
}
