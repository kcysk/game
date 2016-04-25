package net.keshen.fishgame.manager;

import net.keshen.container.ApplicationContext;
import net.keshen.fishgame.enumration.FishType;
import net.keshen.fishgame.model.Fish;
import net.keshen.logger.Logger;
import net.keshen.logger.LoggerManager;

/**
 * 鱼管理器
 * @author shenke
 * @date 2016-3-2 上午9:32:15
 */
public class FishManager {
	
	private static final Logger logger = LoggerManager.getLogger(FishManager.class);
	
	private static FishManager fishManager;
	
	private ImageManager imageManager = ApplicationContext.getBean(ImageManager.class);
	
	private FishManager(){
		
	}
	
	public static FishManager newInstance(){
		if(fishManager == null){
			fishManager = new FishManager();
		}
		return fishManager;
	}
	
	
	/**
	 * 根据指定的类型获取Fish实例</br>
	 * 该实例对象仅仅初始化必要的图片数据和DrawableName</br>
	 * @param type
	 * @return
	 */
	public Fish getFishByType(FishType type){
		Fish fish = new Fish();
		fish.setActBitmap(imageManager.getFishActBitmap().get(type));
		fish.setCatchActBitmap(imageManager.getFishCatchBitmap().get(type));
		fish.setInfo(XmlManager.getFishInfo().get(type.getName()));
		fish.setDrawableName(type.getName());
		return fish;
	}
	
	
}
