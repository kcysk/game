package net.keshen.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

/**
 * 配置文件工具类
 * @author shenke
 * @date 2016-3-9 下午1:55:10
 */
public class PropertiesUtils {

	private static final Map<String,String> iamgePahtMap = new HashMap<String, String>(); 
	private static final Map<String,String> xmlPathMap = new HashMap<String, String>();

	/**
	 * 初始化配置文件
	 */
	static{
		getImageMap();
		getXMLConfigPathMap();
	}
	
	public static Map<String,String> getImageMap(){
		Properties p = new Properties();
		try {
			InputStream in = PropertiesUtils.class.getClassLoader().getResourceAsStream("config.properties");
			p.load(in);
			String key = StringUtils.EMPTY;
			for (Object obj : p.keySet()) {
				key = (String)obj;
				if(key.contains("image")){
					String name = key.substring(key.lastIndexOf(".")+1);
					iamgePahtMap.put(name, p.getProperty(key));
					//System.out.println(name);
				}
				else if(key.contains("config")){
					
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return iamgePahtMap;
	}
	
	public static final String getImagePathByName(String key){
		return iamgePahtMap.get(key);
	}
	
	public static final String getXmlPathByName(String key){
		return xmlPathMap.get(key);
	}
	
	public static Map<String,String> getXMLConfigPathMap(){
		return null;
	}
	public static void main(String[] args) {
		Map<String,String> map = getImageMap();
		System.out.println(map.size());
		for (Entry<String, String> string : map.entrySet()) {
			System.out.println(string.getKey() +":::" +string.getValue());
		}
	}
}
