package net.keshen.fishgame.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import net.keshen.fishgame.constant.FishGameConstant;
import net.keshen.logger.Logger;
import net.keshen.logger.LoggerManager;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/**
 * 解析Xml工具类，利用dom4j解析xml
 * 
 * @author shenke
 * @date 2016-3-2 上午9:31:51
 */
public final class XmlUtils {

	private static final Logger logger = LoggerManager.getLogger(XmlUtils.class);
	
	public static final String getCurrentTagValue(XmlPullParser xml){
		try {
			int eventType = xml.next();
			while (true) {
				if (eventType == XmlPullParser.TEXT) {
					return xml.getText();
				} else if (eventType == XmlPullParser.END_DOCUMENT) {
					break;
				}
				eventType = xml.next();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @param xml
	 * @param tagName
	 * @return
	 */
	public static final boolean goTagByName(XmlPullParser xml, String tagName) {
		try {
			String key = StringUtils.EMPTY;
			int evnentType = xml.next();
			while (true) {
				if (evnentType == XmlPullParser.START_TAG) {
					key = xml.getName();
					if (key.trim().equals(tagName)) {
						return true;
					}
				} else if (evnentType == XmlPullParser.END_DOCUMENT) {
					break;
				}
				evnentType = xml.next();
			}
		} catch (Exception e) {
			logger.error(e);
		}
		return false;
	}

	/**
	 * 
	 * @param fileName
	 * @param encode
	 * @return
	 */
	public static final XmlPullParser getXmlPullParser(String fileName,
			String encode) {

		try {
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			factory.setNamespaceAware(true);
			XmlPullParser parser = factory.newPullParser();
			parser.setInput(new FileInputStream(fileName + FishGameConstant.IMAGE_CONFIG_SUFFIX), encode);
			return parser;
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static boolean isOver(XmlPullParser xml){
		try {
			if(xml.next()==XmlPullParser.END_DOCUMENT){
				return true;
			}else{
				return false;
			}
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
}
