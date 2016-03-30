package net.keshen.fishgame.manager;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import net.keshen.fishgame.constant.FishGameConstant;
import net.keshen.fishgame.info.FishInfo;
import net.keshen.fishgame.utils.StringUtils;
import net.keshen.fishgame.utils.XmlUtils;

import org.xmlpull.v1.XmlPullParser;


/**
 * 配置文件管理器
 * @author shenke
 * @date 2016-3-2 下午6:26:02
 */
public class XmlManager {
	
	/**
	 * 获取Fish的相关配置文件的路径</br>
	 * 鱼的动作图片fishActConfig 和 基本配置信息fishInfoConfig
	 * @return
	 */
	public static Map<String,String> getFishConfigPath(){
		
		Map<String,String> configMap = new HashMap<String, String>();
		XmlPullParser xml = XmlUtils.getXmlPullParser(FishGameConstant.FISH_CONFIG_PATH, FishGameConstant.CONFIG_ENCODE);
		String key = StringUtils.EMPTY;
		String configInfo = StringUtils.EMPTY;
		
		while(XmlUtils.goTagByName(xml, "key")){
			key = XmlUtils.getCurrentTagValue(xml);
			XmlUtils.goTagByName(xml, "string");
			configInfo = XmlUtils.getCurrentTagValue(xml);
			configMap.put(key, configInfo);
		}
		return configMap;
	}
	
	/**
	 * 获取鱼的配置信息:速度、旋转角度等</br>
	 * 以Map形式返回
	 * @return
	 */
	public static Map<String,FishInfo> getFishInfo(){
		Map<String,FishInfo> fishInfoMap = new HashMap<String, FishInfo>();
		String fishInfoPath = getFishConfigPath().get(FishGameConstant.KEY_FISH_INFO_CONFIG);
		XmlPullParser xml = XmlUtils.getXmlPullParser(fishInfoPath, FishGameConstant.CONFIG_ENCODE);
		try {
			while(XmlUtils.goTagByName(xml, "key")){
				FishInfo fishInfo = new FishInfo();
				XmlUtils.goTagByName(xml, "string");
				String fishName = XmlUtils.getCurrentTagValue(xml);
				XmlUtils.goTagByName(xml, "dict");
				//解析相关参数
				XmlUtils.goTagByName(xml, "integer");
				int maxRotate = Integer.parseInt(XmlUtils.getCurrentTagValue(xml));
				fishInfo.setMaxRotate(maxRotate);
				XmlUtils.goTagByName(xml, "integer");
				int runSpeed = Integer.parseInt(XmlUtils.getCurrentTagValue(xml));
				fishInfo.setRunSpeed(runSpeed);
				XmlUtils.goTagByName(xml, "integer");
				int actSpeed = Integer.parseInt(XmlUtils.getCurrentTagValue(xml));
				fishInfo.setActSpeed(actSpeed);
				XmlUtils.goTagByName(xml, "integer");
				int fishShoalMax = Integer.parseInt(XmlUtils.getCurrentTagValue(xml));
				fishInfo.setFishShoalMax(fishShoalMax);
				XmlUtils.goTagByName(xml, "integer");
				int fishInLayer = Integer.parseInt(XmlUtils.getCurrentTagValue(xml));
				fishInfo.setFishInLayer(fishInLayer);
				XmlUtils.goTagByName(xml, "integer");
				int worth = Integer.parseInt(XmlUtils.getCurrentTagValue(xml));
				fishInfo.setWorth(worth);
				XmlUtils.goTagByName(xml, "integer");
				int catchProbability = Integer.parseInt(XmlUtils.getCurrentTagValue(xml));
				fishInfo.setCatchProbability(catchProbability);
				//
				//switch(fishName){
				//	case FishType.MACKEREL.getName():
				//		fishInfo.setType(FishType.MACKEREL);
				//		break;
				//	case FishType.SNAPPER.getName():
				//		fishInfo.setType(FishType.SNAPPER);
				//		break;
				//	case FishType.
				//}
				fishInfoMap.put(fishName, fishInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fishInfoMap;
	}
	public static void main(String[] args) {
		Map<String, FishInfo> info = getFishInfo();
		for (Entry<String, FishInfo> string : info.entrySet()) {
			System.out.println(string.getKey());
		}
	}
}
