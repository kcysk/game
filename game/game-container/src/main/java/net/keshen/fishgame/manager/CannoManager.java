package net.keshen.fishgame.manager;

import java.util.Map;
import java.util.Map.Entry;

import net.keshen.base.graphics.Bitmap;
import net.keshen.fishgame.componets.Cannon;
import net.keshen.logger.Logger;
import net.keshen.logger.LoggerManager;

/**
 * 大炮管理器
 * @author shenke
 * @date 2016-3-7 下午4:13:32
 */
public class CannoManager {

	private Logger logger = LoggerManager.getLogger(getClass());
	
	private Cannon currentCannon;
	private ImageManager manager = ImageManager.getImageManager();
	
	public CannoManager(){
		//init();
	}
	
	//初始化
	public void init(){
		initCannon();
		initBullet();
		initNet();
	}
	//初始化渔网
	private void initNet(){
		
	}
	//初始化子弹
	private void initBullet(){
		
	}
	//初始化大炮
	private void initCannon(){
		Map<String,Bitmap> imageMap = manager.getBitmapsByImageConfig("fire");
		//cannon = new Cannon(cannoImage);
		Bitmap[] cannonImages = new Bitmap[imageMap.size()];
		int t = 0;
		for (Entry<String, Bitmap> images : imageMap.entrySet()) {
			cannonImages[t] = images.getValue();
			t++;
		}
		this.currentCannon.setCannoImage(cannonImages);
		
//		this.currentCannon.setCannoRotate_x(this.currentCannon.getPicWidth());
	}

	/**
	 * 更换小的型号的大炮
	 */
	public void downCannonVersion(){
		//this.currentCannon.setCurrentImageId(currentImageId);
	}
	/**
	 * 增加大炮型号
	 */
	public void addCannonVersion(){
		//this.currentCannon.setCurrentImageId(currentImageId);
	}
	/**
	 * 
	 */
	public Cannon getCurrentCannon(){
		return this.currentCannon;
	}
	
	public static void main(String[] args) {
		CannoManager cannoManager = new CannoManager();
		
	}
}
