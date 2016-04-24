package net.keshen.fishgame.utils;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.xmlpull.v1.XmlPullParser;

import net.keshen.base.graphics.Bitmap;
import net.keshen.fishgame.info.ImageConfig;
import net.keshen.fishgame.info.ImageConfig.ActImageConfig;
import net.keshen.logger.Logger;
import net.keshen.logger.LoggerManager;
import net.keshen.util.ImageUtils;

/**
 * 图片解析工具类
 * @author shenke
 * @date 2016年4月24日下午1:53:43
 * @version 1.0
 */
public class ImageResolveUtils {

	private static final Logger logger = LoggerManager.getLogger(ImageResolveUtils.class);
	
	/**
	 * 根据需要解析的名称解析对应的图片</br>
	 * 这里配置文件和源图片是对应的关系</br>
	 * 相对工程而言带
	 * @param fileName
	 * @return
	 */
	public static Map<String,Bitmap> getBitmapsByImageConfigName(String fileName){
		ImageConfig config = createImageConfig(fileName, System.getProperty("encode"));
		return getBitmapsByActConfigs( config.getAllActs().values());
	}
	/**
	 * 
	 * @param fileName
	 * @param encode
	 * @return
	 */
	private static ImageConfig createImageConfig(String fileName,String encode){
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
	private static void getSrcImageInfo(XmlPullParser xml,ImageConfig config){
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
	private static void getCutImageConfig(XmlPullParser xml, ImageConfig imageConfig) {
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
	private static void getActImageConfig(XmlPullParser xml,ActImageConfig actConfig){
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
	public static Bitmap getBitmapByActImageConfig(ActImageConfig actConfig,BufferedImage srcImage){
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
	public static Map<String,Bitmap> getBitmapsByActConfigs(Collection<ActImageConfig> collection){
		Map<String,Bitmap> actImages = new HashMap<String, Bitmap>();
		for (ActImageConfig actConfig : collection) {
			String fileName = actConfig.getConfig().getSrcFileName();
			Bitmap bitmap = getBitmapByActImageConfig(actConfig, 
					ImageUtils.getImageByAssert(fileName));
			actImages.put(actConfig.getImageName(), bitmap);
		}
		return actImages;
	}
}
