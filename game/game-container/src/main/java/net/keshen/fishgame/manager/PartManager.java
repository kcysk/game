package net.keshen.fishgame.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import net.keshen.fishgame.enumration.FishType;
import net.keshen.fishgame.info.PartInfo;
import net.keshen.fishgame.utils.XmlUtils;
import net.keshen.logger.Logger;
import net.keshen.logger.LoggerManager;

import org.xmlpull.v1.XmlPullParser;

/**
 * 关卡管理器
 * @author shenke
 * @date 2016年4月25日下午10:15:18
 * @version 1.0
 */
public class PartManager {

	private static final Logger logger = LoggerManager.getLogger(PartManager.class);
	
	private static PartManager partManager;
	
	private static Map<Integer,PartInfo> parts; 
	
	public static PartManager newInstance(){
		if(partManager == null){
			partManager = new PartManager();
		}
		return partManager;
	}
	
	private PartManager(){
		
	}
	
	public PartManager init(){
		parts = resolveXml();
		return this;
	}
	
	public PartInfo getPartInfo(int partNum){
		return parts.get(partNum);
	}
	
	private Map<Integer, PartInfo> resolveXml(){
		logger.info("关卡解析开始。。。。。");
		XmlPullParser xml = XmlUtils.getXmlPullParser("fish/config/GamePart", System.getProperty("encode"));
		Map<Integer, PartInfo> parts = new TreeMap<Integer,PartInfo>();
		while (true) {
			PartInfo partInfo = new PartInfo();
			
			if(!XmlUtils.goTagByName(xml, "key")){
				break;
			}
			XmlUtils.goTagByName(xml, "string");
			String part = XmlUtils.getCurrentTagValue(xml);
			partInfo.setPart(Integer.parseInt(part));
			
			XmlUtils.goTagByName(xml, "string");
			String fish = XmlUtils.getCurrentTagValue(xml);
			String[] fishNames = fish.split(";");
			List<FishType> types = new ArrayList<FishType>();
			for (String name : fishNames) {
				types.add(FishType.getType(name));
			}
			partInfo.setAllTypes(types.toArray(new FishType[0]));
			
			XmlUtils.goTagByName(xml, "string");
			String showProbability = XmlUtils.getCurrentTagValue(xml);
			String[] probabilitys = showProbability.split(";");
			Map<FishType,Integer> showProbabilityMap = new HashMap<FishType,Integer>();
			for (int i=0;i<probabilitys.length;i++) {
				showProbabilityMap.put(partInfo.getAllTypes()[i], Integer.parseInt(probabilitys[i]));
			}
			partInfo.setShowProbability(showProbabilityMap);
			
			XmlUtils.goTagByName(xml, "integer");
			int shoalSumInScreen = Integer.parseInt(XmlUtils.getCurrentTagValue(xml));
			partInfo.setShoalSumInScreen(shoalSumInScreen);
			
			XmlUtils.goTagByName(xml, "integer");
			int time = Integer.parseInt(XmlUtils.getCurrentTagValue(xml));
			partInfo.setTime(time);
			
			XmlUtils.goTagByName(xml, "string");
			int nextpart = Integer.parseInt(XmlUtils.getCurrentTagValue(xml));
			partInfo.setNextpart(nextpart);
			
			XmlUtils.goTagByName(xml, "string");
			String bgMusic = XmlUtils.getCurrentTagValue(xml);
			partInfo.setBgMusic(bgMusic);
			
			XmlUtils.goTagByName(xml, "string");
			String background = XmlUtils.getCurrentTagValue(xml);
			partInfo.setBackground(background);
			parts.put(Integer.parseInt(part), partInfo);
		}
		logger.info("关卡解析结束。。。。。");
		return parts;
	}
	
	public static void main(String[] args) {
		PartManager manager = PartManager.newInstance();
		Map<Integer, PartInfo> parts = manager.resolveXml();
		for (Integer string : parts.keySet()) {
			System.out.println(string);
		}
	}
}
