package net.keshen.fishgame.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.xmlpull.v1.XmlPullParser;

import net.keshen.fishgame.enumration.FishType;
import net.keshen.fishgame.info.PartInfo;
import net.keshen.fishgame.utils.XmlUtils;
import net.keshen.logger.Logger;
import net.keshen.logger.LoggerManager;

/**
 * 关卡管理器
 * @author shenke
 * @date 2016年4月25日下午10:15:18
 * @version 1.0
 */
public class PartManager {

	private static final Logger logger = LoggerManager.getLogger(PartManager.class);
	
	public static PartManager partManager;
	
	public static PartManager newInstance(){
		if(partManager == null){
			partManager = new PartManager();
		}
		return partManager;
	}
	
	private PartManager(){
		
	}
	
	public PartManager init(){
		
		return this;
	}
	
	public Map<String,PartInfo> getPartInfo(){
		
		return null;
	}
	
	private void resolveXml(){
		XmlPullParser xml = XmlUtils.getXmlPullParser("", System.getProperty("encode"));
		while (true) {
			PartInfo partInfo = new PartInfo();
			
			XmlUtils.goTagByName(xml, "part");
			String part = XmlUtils.getCurrentTagValue(xml);
			partInfo.setPart(Integer.parseInt(part));
			
			XmlUtils.goTagByName(xml, "fish");
			String fish = XmlUtils.getCurrentTagValue(xml);
			String[] fishNames = fish.split(";");
			List<FishType> types = new ArrayList<FishType>();
			for (String name : fishNames) {
				types.add(FishType.getType(name));
			}
			partInfo.setAllTypes(types.toArray(new FishType[0]));
			
			XmlUtils.goTagByName(xml, "showProbability");
			String showProbability = XmlUtils.getCurrentTagValue(xml);
			String[] probabilitys = showProbability.split(";");
			Map<FishType,Integer> showProbabilityMap = new HashMap<FishType,Integer>();
			for (int i=0;i<probabilitys.length;i++) {
				showProbabilityMap.put(partInfo.getAllTypes()[i], Integer.parseInt(probabilitys[i]));
			}
			partInfo.setShowProbability(showProbabilityMap);
			
			XmlUtils.goTagByName(xml, "shoalSumInScreen");
			int shoalSumInScreen = Integer.parseInt(XmlUtils.getCurrentTagValue(xml));
		}
	}
}
