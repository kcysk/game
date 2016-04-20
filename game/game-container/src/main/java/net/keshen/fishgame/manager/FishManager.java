package net.keshen.fishgame.manager;

import net.keshen.fishgame.enumration.FishType;
import net.keshen.fishgame.model.Fish;

/**
 * 鱼管理器
 * @author shenke
 * @date 2016-3-2 上午9:32:15
 */
public class FishManager {
	
	private ImageManager imageManager;
	
	public Fish getFishByFishType(FishType type){
		switch(type){
			case MACKEREL:
				break;
			case BLUEFISH:
				break;
			case FROG:
				break;
			case CLOWNFISH:
				break;
			case HEIM:
				break;
			case LANTERNFISH:
				break;
			case MERMAID1:
				break;
			case MERMAID2:
				break;
			case GREENFISH:
				break;
			case SHARK:
				break;
			case SKATE:
				break;
			case SNAPPER:
				break;
			case SQUID:
				break;
			case SWORDFISH:
				break;
			case TORTOISE:
				break;
			case TRAFFICLIGHTSFISH:
				break;
			case WHALE:
				break;
			default:
				break;
		}
		return null;
	}
	private Fish getFishImage(){
		Fish fish = new Fish();
		imageManager.getBitmapsByImageConfig(System.getProperty("fish"));
		//fish.setActBitmap(actBitmap);
		//fish.setCatchActBitmap(catchActBitmap);
		//fish.setInfo(info);
		return fish;
	}
}
