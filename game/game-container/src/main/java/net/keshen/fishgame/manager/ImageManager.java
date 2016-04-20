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
import net.keshen.fishgame.enumration.NetType;
import net.keshen.fishgame.enumration.Type;
import net.keshen.fishgame.info.ImageConfig;
import net.keshen.fishgame.info.ImageConfig.ActImageConfig;
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
	
	public static final Map<FishType,Bitmap[]> FISH_ACT_BITMAP = new HashMap<FishType,Bitmap[]>() ;
	public static final Map<FishType,Bitmap[]> FISH_CATCH_BITMAP = new HashMap<FishType,Bitmap[]>();
	public static final Map<FireType,Bitmap[]> FIRE_BITMAP = new HashMap<FireType,Bitmap[]>();
	public static final Map<NetType,Bitmap> NET_BITMAP = new HashMap<NetType,Bitmap>();
	public static final Map<BulletType,Bitmap[]> BULLET_BITMAP = new HashMap<BulletType,Bitmap[]>();
	
	private static ImageManager imageManager;
	
	/**
	 * 初始化所有图片
	 */
	public void init(){
		initFishActBitmap();
		
		//initFireBitmap();
		
	}
	
	//初始化鱼动作图片
	private void initFishActBitmap(){
		logger.info("解析鱼类相关动作图片开始。。。");
		List<String> actConfigPath = XmlManager.getFishActConfigPath();
		Map<String,Bitmap> actBitmapMap = new HashMap<String,Bitmap>();
		for (String path : actConfigPath) {
			actBitmapMap.putAll(getBitmapsByImageConfig(path));
		}
		/*
		Map<String, Bitmap> mackerelMap = new HashMap<String, Bitmap>();
		Map<String, Bitmap> bluefishMap = new HashMap<String, Bitmap>();
		Map<String, Bitmap> frogMap = new HashMap<String, Bitmap>();
		Map<String, Bitmap> clownfishMap = new HashMap<String, Bitmap>();
		Map<String, Bitmap> heimMap = new HashMap<String, Bitmap>();
		Map<String, Bitmap> lanternfishMap = new HashMap<String, Bitmap>();
		Map<String, Bitmap> mermaid1Map = new HashMap<String, Bitmap>();
		Map<String, Bitmap> mermaid2Map = new HashMap<String, Bitmap>();
		Map<String, Bitmap> greenfishMap = new HashMap<String, Bitmap>();
		Map<String, Bitmap> sharkMap = new HashMap<String, Bitmap>();
		Map<String, Bitmap> skateMap = new HashMap<String, Bitmap>();
		Map<String, Bitmap> snapperMap = new HashMap<String, Bitmap>();
		Map<String, Bitmap> squidMap = new HashMap<String, Bitmap>();
		Map<String, Bitmap> swordfishMap = new HashMap<String, Bitmap>();
		Map<String, Bitmap> tortoiseMap = new HashMap<String, Bitmap>();
		Map<String, Bitmap> trafficlightsfishMap = new HashMap<String, Bitmap>();
		Map<String, Bitmap> whaleMap = new HashMap<String, Bitmap>();
		
		
		for (String fishActName : actBitmapMap.keySet()) {
			switch (FishType.getType(fishActName.substring(0, 6))) {
				case MACKEREL:
					mackerelMap.put(fishActName, actBitmapMap.get(fishActName));
					break;
				case BLUEFISH:
					bluefishMap.put(fishActName, actBitmapMap.get(fishActName));
					break;
				case FROG:
					frogMap.put(fishActName, actBitmapMap.get(fishActName));
					break;
				case CLOWNFISH:
					clownfishMap.put(fishActName, actBitmapMap.get(fishActName));
					break;
				case HEIM:
					heimMap.put(fishActName, actBitmapMap.get(fishActName));
					break;
				case LANTERNFISH:
					lanternfishMap.put(fishActName, actBitmapMap.get(fishActName));
					break;
				case MERMAID1:
					mermaid1Map.put(fishActName, actBitmapMap.get(fishActName));
					break;
				case MERMAID2:
					mermaid2Map.put(fishActName, actBitmapMap.get(fishActName));
					break;
				case GREENFISH:
					greenfishMap.put(fishActName, actBitmapMap.get(fishActName));
					break;
				case SHARK:
					sharkMap.put(fishActName, actBitmapMap.get(fishActName));
					break;
				case SKATE:
					skateMap.put(fishActName, actBitmapMap.get(fishActName));
					break;
				case SNAPPER:
					snapperMap.put(fishActName, actBitmapMap.get(fishActName));
					break;
				case SQUID:
					squidMap.put(fishActName, actBitmapMap.get(fishActName));
					break;
				case SWORDFISH:
					swordfishMap.put(fishActName, actBitmapMap.get(fishActName));
					break;
				case TORTOISE:
					tortoiseMap.put(fishActName, actBitmapMap.get(fishActName));
					break;
				case TRAFFICLIGHTSFISH:
					trafficlightsfishMap.put(fishActName, actBitmapMap.get(fishActName));
					break;
				case WHALE:
					whaleMap.put(fishActName, actBitmapMap.get(fishActName));
					break;
				default:
					break;
			}
		}
		FISH_ACT_BITMAP.put(FishType.BLUEFISH, bluefishMap);
		FISH_ACT_BITMAP.put(FishType.CLOWNFISH, clownfishMap);
		FISH_ACT_BITMAP.put(FishType.FROG, frogMap);
		FISH_ACT_BITMAP.put(FishType.GREENFISH, greenfishMap);
		FISH_ACT_BITMAP.put(FishType.HEIM, heimMap);
		FISH_ACT_BITMAP.put(FishType.LANTERNFISH, lanternfishMap);
		FISH_ACT_BITMAP.put(FishType.MACKEREL, mackerelMap);
		FISH_ACT_BITMAP.put(FishType.MERMAID1, mermaid1Map);
		FISH_ACT_BITMAP.put(FishType.MERMAID2, mermaid2Map);
		FISH_ACT_BITMAP.put(FishType.SHARK, sharkMap);
		FISH_ACT_BITMAP.put(FishType.SKATE, skateMap);
		FISH_ACT_BITMAP.put(FishType.SNAPPER, snapperMap);
		FISH_ACT_BITMAP.put(FishType.SQUID, squidMap);
		FISH_ACT_BITMAP.put(FishType.SWORDFISH, swordfishMap);
		FISH_ACT_BITMAP.put(FishType.TORTOISE, tortoiseMap);
		FISH_ACT_BITMAP.put(FishType.TRAFFICLIGHTSFISH, trafficlightsfishMap);
		FISH_ACT_BITMAP.put(FishType.WHALE,whaleMap);
		*/
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
	
	private void initBulletAndNetBitmap(){
		Map<String,Bitmap> bulletAndNetBitmaps = getBitmapsByImageConfig("cannon/bulletandnet");
		List<Type> bulletAndNetEnuType = new ArrayList<Type>();
		bulletAndNetEnuType.addAll(Arrays.asList(BulletType.values()));
		bulletAndNetEnuType.addAll(Arrays.asList(NetType.values()));
		for (Type type : bulletAndNetEnuType) {
			Map<String,Bitmap> bulletBitmaps = new TreeMap<String,Bitmap>();
			for (String name : bulletAndNetBitmaps.keySet()) {
				if(name.startsWith("bullet_"+type.getVersion())){
					bulletBitmaps.put(name, bulletAndNetBitmaps.get(name));
				}
				else if(name.startsWith(prefix)){
					
				}
			}
		}
	}
	
	//初始化大炮图片
	private void initFireBitmap(){
		Map<String,Bitmap> firesBitmaps = getBitmapsByImageConfig("cannon/fire");
		for (FireType fireType : FireType.values()) {
			Bitmap[] fireBitmap = new Bitmap[2];
			for (int i=1;i<=2;i++) {
				fireBitmap[i-1] = firesBitmaps.get("net_"+fireType.getVersion()+i+".png");
			}
			FIRE_BITMAP.put(fireType, fireBitmap);
		}
	}
	
	private void initGoldBitmap(){
		
	}
	
	private void initSoreBitmap(){
		
	}
	
	private void initRippleBitmap(){

	}
	
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
	 * 相对工程而言带
	 * @param fileName
	 * @return
	 */
	public Map<String,Bitmap> getBitmapsByImageConfig(String fileName){
		ImageConfig config = createImageConfig(fileName, System.getProperty("encode"));
		return getBitmapsByActConfigs( config.getAllActs().values());
	}
	/**
	 * 
	 * @param fileName
	 * @param encode
	 * @return
	 */
	private ImageConfig createImageConfig(String fileName,String encode){
		try {
			if(StringUtils.isEmpty(fileName)){
				throw new Exception("文件名为空！");
			}
			ImageConfig imageConfig = new ImageConfig();
			imageConfig.setSrcFileName(fileName);
			XmlPullParser xml = XmlUtils.getXmlPullParser(fileName, encode);
			while(true){
				XmlUtils.goTagByName(xml, "key");
				String currentTagValue = XmlUtils.getCurrentTagValue(xml);
				if("texture".equals(currentTagValue)){
					getSrcImageInfo(xml, imageConfig);
				}
				else if("frames".equals(currentTagValue)){
					XmlUtils.goTagByName(xml, "dict");
					getCutImageConfig(xml,imageConfig);
					break;
				}
			}
			return imageConfig;
		} catch (Exception e) {
			logger.error("创建IamgeConfig失败"+e.getMessage(),e);
		}
		return null;
	}
	

	/**
	 * 获取源图片的基本信息
	 * @param xml
	 * @param config
	 */
	private void getSrcImageInfo(XmlPullParser xml,ImageConfig config){
		XmlUtils.goTagByName(xml, "key");
		String attribute = XmlUtils.getCurrentTagValue(xml);
		if("width".equals(attribute)){
			XmlUtils.goTagByName(xml, "integer");
			int srcWidth = Integer.parseInt(XmlUtils.getCurrentTagValue(xml));
			config.setSrcWidth(srcWidth);
		}
		else if("height".equals(attribute)){
			XmlUtils.goTagByName(xml, "integer");
			int srcHeight = Integer.parseInt(XmlUtils.getCurrentTagValue(xml));
			config.setSrcHeight(srcHeight);
		}
		XmlUtils.goTagByName(xml, "key");
		attribute = XmlUtils.getCurrentTagValue(xml);
		if("width".equals(attribute)){
			XmlUtils.goTagByName(xml, "integer");
			int srcWidth = Integer.parseInt(XmlUtils.getCurrentTagValue(xml));
			config.setSrcWidth(srcWidth);
		}
		else if("height".equals(attribute)){
			XmlUtils.goTagByName(xml, "integer");
			int srcHeight = Integer.parseInt(XmlUtils.getCurrentTagValue(xml));
			config.setSrcHeight(srcHeight);
		}
	}
	
	/**
	 * 获取源图片内每个动作图片的详细配置数据
	 * @param xml
	 * @param imageConfig
	 */
	private void getCutImageConfig(XmlPullParser xml, ImageConfig imageConfig) {
		try {
			while(XmlUtils.goTagByName(xml, "key")){
				ActImageConfig actConfig = imageConfig.new ActImageConfig();
				String imageName = XmlUtils.getCurrentTagValue(xml);
				imageConfig.getAllActs().put(imageName, actConfig);
				actConfig.setImageName(imageName);
				actConfig.setConfig(imageConfig);
				XmlUtils.goTagByName(xml, "dict");
				getActImageConfig(xml, actConfig);
			}
		} catch (Exception e) {
			logger.error("获取动作图片配置信息有误"+e.getMessage(),e);
		}
	}
	/**
	 * 获取源图片每个动作图片的详细配置信息
	 * @param xml
	 */
	private void getActImageConfig(XmlPullParser xml,ActImageConfig actConfig){
		try {
			//X坐标
			XmlUtils.goTagByName(xml, "integer");
			int x = Integer.parseInt(XmlUtils.getCurrentTagValue(xml));
			actConfig.setX(x);
			//y坐标
			XmlUtils.goTagByName(xml, "integer");
			int y = Integer.parseInt(XmlUtils.getCurrentTagValue(xml));
			actConfig.setY(y);
			//图片在源图片中的跨度
			XmlUtils.goTagByName(xml, "integer");
			int width = Integer.parseInt(XmlUtils.getCurrentTagValue(xml));
			actConfig.setWidth(width);
			//在原图片中高度
			XmlUtils.goTagByName(xml, "integer");
			int height = Integer.parseInt(XmlUtils.getCurrentTagValue(xml));
			actConfig.setHeight(height);
			//offsetX
			XmlUtils.goTagByName(xml, "real");
			double offsetX = Double.parseDouble(XmlUtils.getCurrentTagValue(xml));
			actConfig.setOffsetX(offsetX);
			//offsetY
			XmlUtils.goTagByName(xml, "real");
			double offsetY = Double.parseDouble(XmlUtils.getCurrentTagValue(xml));
			actConfig.setOffsetY(offsetY);
			//图片实际的宽度
			XmlUtils.goTagByName(xml, "integer");
			int originalWidth = Integer.parseInt(XmlUtils.getCurrentTagValue(xml));
			actConfig.setOriginalWidth(originalWidth);
			//
			XmlUtils.goTagByName(xml, "integer");
			int originalHeight = Integer.parseInt(XmlUtils.getCurrentTagValue(xml));
			actConfig.setOriginalHeight(originalHeight);
			
		} catch (Exception e) {
			logger.error("解析XML出错"+e.getMessage(),e);
		}
	}
	
	/**
	 * 根据配置信息裁剪图片
	 * @param actConfig		需要裁剪图片的配置信息
	 * @param srcImage 		源图片
	 * @return
	 */
	public Bitmap getBitmapByActImageConfig(ActImageConfig actConfig,BufferedImage srcImage){
		BufferedImage cutImage = new BufferedImage(actConfig.getWidth(), actConfig.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
		Graphics g = cutImage.getGraphics();
		g.drawImage(srcImage,
			(int)(actConfig.getOriginalWidth() / 2 + actConfig.getOffsetX() - actConfig.getWidth()/ 2), 
			(int)(actConfig.getOriginalHeight() / 2 - actConfig.getOffsetY() - actConfig.getHeight() / 2), 
			(int)(actConfig.getOriginalWidth() / 2 + actConfig.getOffsetX() - actConfig.getWidth()/ 2)+actConfig.getWidth(), 
			(int)(actConfig.getOriginalHeight() / 2 - actConfig.getOffsetY() - actConfig.getHeight() / 2)+actConfig.getHeight(), 
			actConfig.getX(),
			actConfig.getY(), 
			actConfig.getX()+actConfig.getWidth(), 
			actConfig.getY()+actConfig.getHeight(), 
			null
		);
		//TODO 根据屏幕尺寸缩放图片
		
		return new Bitmap(cutImage);
	}
	
	/**
	 * 根据一组配置信息解析对应的图片
	 * @param collection
	 * @return
	 */
	public Map<String,Bitmap> getBitmapsByActConfigs(Collection<ActImageConfig> collection){
		Map<String,Bitmap> actImages = new HashMap<String, Bitmap>();
		for (ActImageConfig actConfig : collection) {
			String fileName = actConfig.getConfig().getSrcFileName();
			Bitmap bitmap = getBitmapByActImageConfig(actConfig, 
					ImageUtils.getImageByAssert(fileName));
			actImages.put(actConfig.getImageName(), bitmap);
		}
		return actImages;
	}
	
	public static void main(String[] args) {
		ImageManager.getImageManager().init();
//		for (FishType type : ImageManager.FISH_ACT_BITMAP.keySet()) {
//			System.out.println(type);
//		}
//		for (String string : ImageManager.FIRE_BITMAP.keySet()) {
//			System.out.println(string);
//		}
	}
}
