package net.keshen.fishgame.utils;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import net.keshen.util.StringUtils;

/**
 * 配置文件工具类
 * @author shenke
 * @date 2016-3-9 下午1:55:10
 */
public class PropertiesUtils {

	private static final Map<String, String> iamgePahtMap = new HashMap<String, String>();
	private static final Map<String, String> xmlPathMap = new HashMap<String, String>();

	/**
	 * 初始化配置文件
	 */
	static {
		
	}

	public static Map<String, String> getImageMap() {
		Properties p = null;
		// InputStream in =
		// PropertiesUtils.class.getClassLoader().getResourceAsStream("config.properties");
		// p.load(in);
		p = System.getProperties();
		String key = StringUtils.EMPTY;
		for (Object obj : p.keySet()) {
			key = (String) obj;
			if (key.contains("image")) {
				String name = key.substring(key.lastIndexOf(".") + 1);
				iamgePahtMap.put(name, p.getProperty(key));
				// System.out.println(name);
			} else if (key.contains("config")) {

			}
		}
		return iamgePahtMap;
	}

	public static final String getImagePathByName(String key) {
		return iamgePahtMap.get(key);
	}

	public static final String getXmlPathByName(String key) {
		return xmlPathMap.get(key);
	}

	public static Map<String, String> getXMLConfigPathMap() {
		Properties properties = new Properties();
		//InputStream in = PropertiesUtils.class.getClassLoader().getResourceAsStream("");
		return null;
	}

	public static void main(String[] args) {
		PropertiesUtils p = new PropertiesUtils();
		Properties pt = System.getProperties();
		for (Object string : pt.keySet()) {
			System.out.println(pt.getProperty(string.toString()));
		}
		System.out.println(System.getProperty("fishConfig"));
	}

	public static void init() {
		try {
			InputStream in = PropertiesUtils.class.getClassLoader().getResourceAsStream("config.properties");
			Properties properties = new Properties();
			properties.load(in);
			System.setProperties(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
		getImageMap();
		getXMLConfigPathMap();
	}
}
