package net.keshen.fishgame.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.keshen.base.basecomponet.GameConstant;
import net.keshen.container.ApplicationContext;
import net.keshen.fishgame.constant.FishGameConstant;
import net.keshen.fishgame.enumration.FishType;
import net.keshen.fishgame.info.FishInfo;
import net.keshen.fishgame.info.PartInfo;
import net.keshen.fishgame.manager.game.GameManager;
import net.keshen.fishgame.model.Fish;
import net.keshen.fishgame.model.HeadFish;
import net.keshen.fishgame.thread.ActPicThread;
import net.keshen.logger.Logger;
import net.keshen.logger.LoggerManager;

/**
 * 鱼群管理器
 * @author shenke
 * @date 2016-4-25 下午4:58:25
 */
public class FishShoalManager {
	
	private static final Logger logger = LoggerManager.getLogger(FishShoalManager.class);
	
	private static FishShoalManager shoalManager;
	
	private FishManager fishManager = ApplicationContext.getBean(FishManager.class);
	private GameManager gameManager = ApplicationContext.getBean(GameManager.class);
	private PartManager partManager = ApplicationContext.getBean(PartManager.class);
	
	private FishShoalManager(){
		
	}
	
	public static FishShoalManager newInstance(){
		if(shoalManager == null){
			shoalManager = new FishShoalManager();
		}
		return shoalManager;
	}
	
	/**
	 * 初始化
	 */
	public void init(){
		new Thread(new Runnable() {
			@Override
			public void run() {
				PartInfo nowPart = partManager.getPartInfo(gameManager.getNowPart());
				nowPart.getShowProbability();
				for (int i=0; i < nowPart.getShoalSumInScreen() ; i++) {
					FishType type = randomCreateFishType();
					createShoalOfFish(type);
				}
			}
		}).start();
	}
	
	/**
	 * 鱼群的创建思路是根据领头鱼决定的
	 * @param type
	 * @return
	 */
	public void createShoalOfFish(final FishType type){
		new Thread(){
			@Override
			public void run() {
				List<Fish> shoals = new ArrayList<Fish>();
				HeadFish headFish = createHeadFish(type);
				//TODO headFish not Run
				FishInfo info = FishInfo.getAllFishInfos().get(type);
				final int maxFishNum = info.getFishShoalMax();
				for (int i = 0 ; i < maxFishNum ; i++) {
					shoals.add(fishManager.getFishByType(type));
				}
				headFish.setShoal(shoals);
				((GameManager)ApplicationContext.getBean(GameManager.class)).getShoals().add(headFish);
			}
			
		}.start();
	}
	
	private HeadFish createHeadFish(FishType type){
		HeadFish headFish = new HeadFish();
		Fish fish = fishManager.getFishByType(type);
		headFish.setFish(fish);
		fish.setHeadFish(headFish);
		fish.setCanRun(true);
		setRandomHeadFishLayout(headFish);
		return headFish;
	}
	
	/**
	 * 设置领头鱼的初始位置（随机）
	 * @param headFish
	 */
	private void setRandomHeadFishLayout(final HeadFish headFish){
		//偶数 Left
		if(((int)Math.random()*100)%2==0){
			headFish.setFishX(-headFish.getFish().getPicWidth());
			//headFish.setFishY();
		}
		//奇数 Right
		else{
			headFish.setFishY(GameConstant.getWidth());
		}
	}
	
	
	private void setFishRun(final HeadFish fish){
		
	}
	/**
	 * 设置鱼群鱼之间的位置 
	 */
	private void setRandomLayoutOfShoalFish(final HeadFish headFish){
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					
					float fromY = headFish.getFishX();
					int shoalSize = headFish.getShoal().size();
					Fish flagFish;
					float randomMaxY;
					float randomMinY;
					while(GameConstant.isRunning()){
						while (!GameConstant.isPause() && shoalSize>1) {
							
							shoalSize--;
						}
					}
				} catch (Exception e) {
					logger.error(e);
				}
			}
		}).start();
	}
	
	/**
	 * 不同种类的鱼生成的概率是不同的
	 * @return
	 */
	private FishType randomCreateFishType(){
		Random ra = new Random();
		int random_num = ra.nextInt(100);
		if(random_num<=59){
			switch(ra.nextInt(14)){
				case 1:
				case 8:
					return FishType.getType("fish01");
				case 2:	
				case 10:
					return FishType.getType("fish02");
				case 3:	
				case 9:
					return FishType.getType("fish03");
				case 4:	
				case 12:
					return FishType.getType("fish04");
				case 5:	
				case 11:
					return FishType.getType("fish05");
				case 6:	
				case 13:
					return FishType.getType("fish06");
				case 7:
				case 0:
					return FishType.getType("fish07");
			}
		}
		if(60<=random_num&&random_num<=89){
			switch(ra.nextInt(12)){
				case 1:
				case 6: return FishType.getType("fish17");
				case 2:
				case 8: return FishType.getType("fish08");
				case 3:
				case 9: return FishType.getType("fish14");
				case 4:
				case 10:return FishType.getType("fish09");
				case 0:
				case 5: return FishType.getType("fish15");
				case 7:
				case 11:return FishType.getType("fish10");
			}
		}
		if(90<=random_num&&random_num<=94){
			switch(ra.nextInt(4)){
				case 0:
				case 2: return FishType.getType("fish16");
				case 1:
				case 3: return FishType.getType("fish13");
			}
		}
		if(95<=random_num&&random_num<=99){
			switch(ra.nextInt(4)){
				case 0:
				case 2: return FishType.getType("fish11");
				case 1:
				case 3: return FishType.getType("fish12");
			}
		}
		return null;
	}
}
