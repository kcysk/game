package net.keshen.fishgame.info;

import java.util.Map;

import net.keshen.fishgame.enumration.FishType;

/**
 * 关卡信息
 * @author shenke
 * @date 2016年4月25日下午10:05:31
 * @version 1.0
 */
public class PartInfo {

	private int part;
	private FishType[] allTypes;
	private Map<FishType,Integer> showProbability;
	private int shoalSumInScreen;
	private int time;
	private int nextpart;
	private String bgMusic;
	private String background;
	
	
	public FishType[] getAllTypes() {
		return allTypes;
	}
	/**
	 * 设置当前关卡所有种类的鱼
	 * @param allTypes
	 */
	public void setAllTypes(FishType[] allTypes) {
		this.allTypes = allTypes;
	}
	/**
	 * 获取所有种类的鱼出现的概率</br>
	 * 这个的顺序和{@code allTypes}是对应的
	 * @return
	 */
	public Map<FishType,Integer> getShowProbability() {
		return showProbability;
	}
	/**
	 * 设置鱼类的出现的概率
	 * @param showProbability
	 */
	public void setShowProbability(Map<FishType,Integer> showProbability) {
		this.showProbability = showProbability;
	}
	/**
	 * 屏幕中的鱼群数量
	 * @return
	 */
	public int getShoalSumInScreen() {
		return shoalSumInScreen;
	}
	/**
	 * 屏幕中的鱼群数量
	 */
	public void setShoalSumInScreen(int shoalSumInScreen) {
		this.shoalSumInScreen = shoalSumInScreen;
	}
	/**
	 * 该关卡的存在时间
	 * @return
	 */
	public int getTime() {
		return time;
	}
	/**
	 * 
	 * @param time
	 */
	public void setTime(int time) {
		this.time = time;
	}
	/**
	 * 下一关
	 * @return
	 */
	public int getNextpart() {
		return nextpart;
	}
	/**
	 * 下一关
	 */
	public void setNextpart(int nextpart) {
		this.nextpart = nextpart;
	}
	/**
	 * 背景音乐
	 * @return
	 */
	public String getBgMusic() {
		return bgMusic;
	}
	/**
	 * 背景音乐
	 */
	public void setBgMusic(String bgMusic) {
		this.bgMusic = bgMusic;
	}
	/**
	 * 背景图片
	 * @return
	 */
	public String getBackground() {
		return background;
	}
	/**
	 * 设置背景图片
	 * @param background
	 */
	public void setBackground(String background) {
		this.background = background;
	}
	
	public int getPart() {
		return part;
	}
	public void setPart(int part) {
		this.part = part;
	}
	
}
