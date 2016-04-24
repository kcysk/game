package net.keshen.fishgame.manager;

import java.util.Map;

import net.keshen.base.basecomponet.GameConstant;
import net.keshen.base.graphics.Bitmap;
import net.keshen.base.surface.GameSurface;
import net.keshen.container.ApplicationContext;
import net.keshen.fishgame.componets.Cannon;
import net.keshen.fishgame.enumration.FireType;
import net.keshen.fishgame.manager.game.GameManager;
import net.keshen.logger.Logger;
import net.keshen.logger.LoggerManager;

/**
 * 大炮管理器
 * @author shenke
 * @date 2016-3-7 下午4:13:32
 */
public class CannoManager {

	private Logger logger = LoggerManager.getLogger(getClass());
	
	private Map<FireType,Bitmap[]> fireBitmaps;
	
	private ImageManager imageManager = ApplicationContext.getBean(ImageManager.class);
	private static CannoManager cannoManager;
	
	private Cannon currentCannon;
	
	public static CannoManager newInstance(){
		if(cannoManager==null){
			cannoManager = new CannoManager();
		}
		return cannoManager;
	}
	
	private CannoManager(){
		
	}
	
	//初始化
	public CannoManager init(){
		initCannon();
		initBullet();
		initNet();
		return cannoManager;
	}
	//初始化渔网
	private void initNet(){
		
	}
	//初始化子弹
	private void initBullet(){
		
	}
	//初始化大炮
	private void initCannon(){
		fireBitmaps = imageManager.getFireBitmap();
		
		currentCannon = new Cannon(); 
		currentCannon.setCannonImage(fireBitmaps.get(FireType.FIRE1));
		currentCannon.setType(FireType.FIRE1);
	}

	/**
	 * 更换小的型号的大炮
	 */
	public void downCannonVersion(){
		//当前型号是最小型号
		if(currentCannon.getType().getVersion().equals(Cannon.MIN_VERSION)){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						float scale;
						float pos;
						for (int i = 0; i < 5; i++) {
							scale = i*0.2f;
							pos = (5-i)*0.2f;
							currentCannon.getPicMatrix().setTranslate(GameConstant.getWidth()/2-currentCannon.getPicWidth()/2*pos,  GameConstant.getHeight()-currentCannon.getPicHeight()*pos/2-20);
							currentCannon.getPicMatrix().setScale(pos, pos);
							Thread.sleep(50);
						}
						currentCannon = new Cannon();
						currentCannon.setCannonImage(fireBitmaps.get(FireType.FIRE10));
						currentCannon.setType(FireType.FIRE10);
						currentCannon.setDrawableName("fire");
						GameSurface surface = ApplicationContext.getBean(GameSurface.class);
						surface.updatePicLayer(GameSurface.CHANGE_MODEL_REMOVE, 1, currentCannon);
						surface.updatePicLayer(GameSurface.CHANGE_MODEL_ADD, 1, currentCannon);
						for (int i = 4; i >= 0; i--) {
							scale = i*0.2f;
							pos = (4-i)*0.2f;
							currentCannon.getPicMatrix().setTranslate(GameConstant.getWidth()/2-currentCannon.getPicWidth()/2*pos,  GameConstant.getHeight()-currentCannon.getPicHeight()*pos/2-20);
							currentCannon.getPicMatrix().setScale(pos, pos);
							Thread.sleep(50);
						}
						
					} catch (Exception e) {
						logger.error(e);
					}
					
				}
			}).start();
		}
	}
	/**
	 * 增加大炮型号
	 */
	public void addCannonVersion(){
		if(currentCannon.getType().getVersion().equals(Cannon.MAX_VERSION)){
			
		}
	}
	/**
	 * 
	 */
	public Cannon getCurrentCannon(){
		return this.currentCannon;
	}
	
	public static void main(String[] args) {
		GameManager.newInstance().initGame();
		ImageManager imageManager = ApplicationContext.getBean(ImageManager.class);
		Bitmap[] fires = imageManager.getFireBitmap().get(FireType.FIRE1);
		
	}
}
