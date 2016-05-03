package net.keshen.fishgame.thread;

import net.keshen.base.basecomponet.GameConstant;
import net.keshen.fishgame.model.Fish;
import net.keshen.logger.Logger;
import net.keshen.logger.LoggerManager;

/**
 * @author shenke
 * @date 2016-3-8 下午3:33:44
 */
public class ActPicThread extends Thread{

	private static final Logger logger = LoggerManager.getLogger(ActPicThread.class);
	
	private Fish fish;
	
	public ActPicThread(Fish fish){
		this.fish = fish;
	}
	
	@Override
	public void run() {
		try {
			while(GameConstant.isRunning()){
				while(!GameConstant.isPause()&&fish.isAct()){
					if(fish.getFishActs() == fish.getCurrentActId()){
						fish.setCurrentActBitmapId(0);
					}else{
						fish.setCurrentActBitmapId(fish.getCurrentActId()+1);
					}
					Thread.sleep(fish.getInfo().getActSpeed());
				}
			}
		} catch (Exception e) {
			logger.error("类型为："+fish.getDrawableName()+"更换动作图片时出现异常：", e);
		}
	}
	
}
