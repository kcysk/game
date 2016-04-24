package net.keshen.fishgame.manager;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import net.keshen.base.graphics.Bitmap;
import net.keshen.fishgame.enumration.BulletType;
import net.keshen.fishgame.enumration.FireType;
import net.keshen.fishgame.enumration.FishType;
import net.keshen.fishgame.enumration.HighPoint;
import net.keshen.fishgame.enumration.Hundred;
import net.keshen.fishgame.enumration.NetType;
import net.keshen.fishgame.enumration.Number;
import net.keshen.fishgame.enumration.Type;
import net.keshen.fishgame.info.ImageConfig;
import net.keshen.fishgame.info.ImageConfig.ActImageConfig;
import net.keshen.fishgame.utils.ImageResolveUtils;
import net.keshen.fishgame.utils.StringUtils;
import net.keshen.fishgame.utils.XmlUtils;
import net.keshen.logger.Logger;
import net.keshen.logger.LoggerManager;
import net.keshen.util.ImageUtils;

import org.xmlpull.v1.XmlPullParser;

/**
 * 图片管理器
 * 
 * @author shenke
 * @date 2016-3-2 上午9:31:13
 */
public class ImageManager {
	
	private static final Logger logger = LoggerManager.getLogger(ImageManager.class);
	
	private static final Map<FishType,Bitmap[]> FISH_ACT_BITMAP = new HashMap<FishType,Bitmap[]>() ;
	private static final Map<FishType,Bitmap[]> FISH_CATCH_BITMAP = new HashMap<FishType,Bitmap[]>();
	private static final Map<FireType,Bitmap[]> FIRE_BITMAP = new HashMap<FireType,Bitmap[]>();
	private static final Map<NetType,Bitmap> NET_BITMAP = new HashMap<NetType,Bitmap>();
	private static final Map<BulletType,Bitmap[]> BULLET_BITMAP = new HashMap<BulletType,Bitmap[]>();
	/**用于显示捕捉鱼之后的金币数量显示相关*/
	private static final Map<Number,Bitmap> NUMBER_BITMAP = new HashMap<Number,Bitmap>();
	
	private static final Map<String,Bitmap> GOLD_ITEM = new HashMap<String,Bitmap>();
	private static final Map<HighPoint,Bitmap[]> HIGH_POINT = new HashMap<HighPoint,Bitmap[]>();
	private static final Map<Hundred,Bitmap[]> HUNDRED = new HashMap<Hundred,Bitmap[]>();
	/** 用于金币栏显示已拥有的金币数量，但是不包含X*/
	private static final Map<Number,Bitmap> NUMBER_OF_GOLD = new HashMap<Number,Bitmap>();
	
	private static Bitmap[] RIPPLE = new Bitmap[0];
	
	private static ImageManager imageManager;
	
	
	/**
	 * 获取ImageManager实例
	 * @return
	 */
	public static ImageManager getImageManager(){
		if(imageManager==null){
			imageManager = new ImageManager();
		}
		return imageManager;
	}
	
	private ImageManager(){
		
	}
	
	/**
	 * 初始化所有图片
	 */
	public ImageManager init(){
		//initFishActBitmap();
		//initBulletAndNetBitmap();
		initFireBitmap();
		initNumberOfGoldBitmap();
		initRippleBitmap();
		initSoreBitmap();
		return imageManager;
	}

	/**
	 * 获取鱼类动作图片Map
	 * @return
	 */
	public  Map<FishType, Bitmap[]> getFishActBitmap() {
		return FISH_ACT_BITMAP;
	}

	/**
	 * 获取鱼被捕捉时的动图图片
	 * @return
	 */
	public  Map<FishType, Bitmap[]> getFishCatchBitmap() {
		return FISH_CATCH_BITMAP;
	}
	
	/**
	 * 获取大炮图片
	 * @return
	 */
	public  Map<FireType, Bitmap[]> getFireBitmap() {
		return FIRE_BITMAP;
	}

	/**
	 * 获取渔网图片
	 * @return
	 */
	public  Map<NetType, Bitmap> getNetBitmap() {
		return NET_BITMAP;
	}

	/**
	 * 获取子弹图片
	 * @return
	 */
	public  Map<BulletType, Bitmap[]> getBulletBitmap() {
		return BULLET_BITMAP;
	}

	/**
	 * 获取数字图片
	 * @return
	 */
	public  Map<Number, Bitmap> getNumberBitmap() {
		return NUMBER_BITMAP;
	}

	/**
	 * 获取金币相关
	 * @return
	 */
	public  Map<String, Bitmap> getGoldItem() {
		return GOLD_ITEM;
	}

	public  Map<HighPoint, Bitmap[]> getHighPoint() {
		return HIGH_POINT;
	}

	public  Map<Hundred, Bitmap[]> getHundred() {
		return HUNDRED;
	}

	public  Map<Number, Bitmap> getNumberOfGold() {
		return NUMBER_OF_GOLD;
	}

	/**
	 * 波纹
	 * @return
	 */
	public  Bitmap[] getRIPPLE() {
		return RIPPLE;
	}

	//初始化鱼动作图片
	private void initFishActBitmap(){
		logger.info("解析鱼类相关动作图片开始。。。");
		List<String> actConfigPath = XmlManager.getFishActConfigPath();
		Map<String,Bitmap> actBitmapMap = new HashMap<String,Bitmap>();
		for (String path : actConfigPath) {
			actBitmapMap.putAll(ImageResolveUtils.getBitmapsByImageConfigName(path));
		}
		for (FishType fishType : FishType.values()) {
			//List<Bitmap> acts = new ArrayList<Bitmap>();
			Map<String,Bitmap> actMap = new TreeMap<String, Bitmap>();
			//List<Bitmap> catchs = new ArrayList<Bitmap>();
			Map<String,Bitmap> catchMap = new TreeMap<String,Bitmap>();
			for (String actBitName : actBitmapMap.keySet()) {
				if(actBitName.startsWith(fishType.getName())
						&&!actBitName.contains("catch")){
					//acts.add(actBitmapMap.get(actBitName));
					actMap.put(actBitName, actBitmapMap.get(actBitName));
				}else if(actBitName.startsWith(fishType.getName())
						&&actBitName.contains("catch")){
					//catchs.add(actBitmapMap.get(actBitName));
					catchMap.put(actBitName, actBitmapMap.get(actBitName));
				}
			}
			FISH_ACT_BITMAP.put(fishType, actMap.values().toArray(new Bitmap[0]));
			FISH_CATCH_BITMAP.put(fishType, catchMap.values().toArray(new Bitmap[0]));
		}
		logger.info("解析鱼类动作图片结束。。。。");
	}
	
	//初始化子弹、渔网、数字
	private void initBulletAndNetBitmap(){
		logger.info("解析子弹、渔网、数字等图片。。。。。");
		Map<String,Bitmap> bulletAndNetBitmaps = ImageResolveUtils.getBitmapsByImageConfigName("cannon/bulletandnet");
		List<Type> bulletAndNetEnuType = new ArrayList<Type>();
		bulletAndNetEnuType.addAll(Arrays.asList(BulletType.values()));
		bulletAndNetEnuType.addAll(Arrays.asList(NetType.values()));
		bulletAndNetEnuType.addAll(Arrays.asList(Number.values()));
		for (Type type : bulletAndNetEnuType) {
			Map<String,Bitmap> bulletBitmaps = new TreeMap<String,Bitmap>();
			for (String name : bulletAndNetBitmaps.keySet()) {
				if(name.startsWith("bullet_"+type.getVersion())){
					bulletBitmaps.put(name, bulletAndNetBitmaps.get(name));
				}
				else if(name.startsWith("net_"+type.getVersion())){
					NET_BITMAP.put((NetType) type, bulletAndNetBitmaps.get(name));
				}
				else if(name.startsWith("num_"+type.getVersion())){
					NUMBER_BITMAP.put((Number) type, bulletAndNetBitmaps.get(name));
				}
			}
			if(type instanceof BulletType){
				BULLET_BITMAP.put((BulletType) type, bulletBitmaps.values().toArray(new Bitmap[0]));
			}
		}
		logger.info("解析子弹、渔网、数字等图片结束。。。。。");
	}
	
	//初始化大炮图片
	private void initFireBitmap(){
		logger.info("解析大炮图片。。。。。。");
		Map<String,Bitmap> firesBitmaps = ImageResolveUtils.getBitmapsByImageConfigName("cannon/fire");
		for (FireType fireType : FireType.values()) {
			Bitmap[] fireBitmap = new Bitmap[2];
			for (int i=1;i<=2;i++) {
				fireBitmap[i-1] = firesBitmaps.get("net_"+fireType.getVersion()+i+".png");
			}
			FIRE_BITMAP.put(fireType, fireBitmap);
		}
		logger.info("解析大炮图片结束。。。。。");
	}

	
	//解析分数相关图片
	private void initSoreBitmap(){
		logger.info("解析分数等相关图片。。。。。。");
		//init gold_item
		Map<String,Bitmap> goldItem = ImageResolveUtils.getBitmapsByImageConfigName("score/goldItem");
		GOLD_ITEM.putAll(goldItem);
		
		//init highPoint
		Map<String,Bitmap> highPoint = ImageResolveUtils.getBitmapsByImageConfigName("score/highPoint");
		for (HighPoint point : HighPoint.values()) {
			Map<String,Bitmap> evPoints = new TreeMap<String,Bitmap>();
			for (String highKey : highPoint.keySet()) {
				if(highKey.startsWith(point.getVersion())){
					evPoints.put(highKey, highPoint.get(highKey));
				}
			}
			HIGH_POINT.put(point, evPoints.values().toArray(new Bitmap[0]));
		}
		
		//init hunDred
		Map<String,Bitmap> hundred = ImageResolveUtils.getBitmapsByImageConfigName("score/hundred");
		for (Hundred hundredEnu : Hundred.values()) {
			Map<String,Bitmap> evHundred = new TreeMap<String,Bitmap>();
			for (String hundredKey : hundred.keySet()) {
				if(hundredKey.startsWith(hundredEnu.getVersion())){
					evHundred.put(hundredKey, hundred.get(hundredKey));
				}
			}
			HUNDRED.put(hundredEnu, evHundred.values().toArray(new Bitmap[0]));
		}
		
		logger.info("解析分数等相关图片结束。。。。。。");
	}
	
	//解析波纹图片
	private void initRippleBitmap(){
		Map<String,Bitmap> ripples = ImageResolveUtils.getBitmapsByImageConfigName("cannon/ripple");
		TreeMap<String, Bitmap> rippleOrdered = new TreeMap<String,Bitmap>();
		rippleOrdered.putAll(ripples);
		RIPPLE = rippleOrdered.values().toArray(RIPPLE);
	}

	//解析用于金币栏的数字图片
	private void initNumberOfGoldBitmap(){
		Map<String,Bitmap> numOfGold = ImageResolveUtils.getBitmapsByImageConfigName("componet/num_gold");
		for (Number num : Number.values()) {
			for (String numKey : numOfGold.keySet()) {
				if(numKey.startsWith("num_"+num.getVersion())){
					NUMBER_OF_GOLD.put(num, numOfGold.get(numKey));
					break;
				}
			}
		}
		
	}
	
	
}
