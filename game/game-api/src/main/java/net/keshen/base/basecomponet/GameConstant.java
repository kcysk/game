package net.keshen.base.basecomponet;
/**
 * 游戏窗口大小等相关信息设置
 * @author shenke
 * @date 2016年2月23日下午9:59:42
 * @version 1.0
 */
public class GameConstant {

	private static int width;		//游戏窗口宽度
	private static int height;		//游戏窗口高度
	private static boolean isFps;	//是否显示Fps
	private static boolean isTime; //是否显示当前时间
	private static boolean isQuality; //是否画质优先
	private static boolean isRunning;
	private static boolean isPause;
	
	private static String bgName="bg_0";
	
	/**
	 * 获取游戏窗口的宽度
	 * @return
	 */
	public static int getWidth() {
		return GameConstant.width;
	}
	/**
	 * 设置游戏窗口的宽度
	 * @param width
	 */
	public static void setWidth(int width) {
		GameConstant.width = width;
	}
	/**
	 * 获取游戏窗口的高度
	 * @return
	 */
	public static int getHeight() {
		return GameConstant.height;
	}
	/**
	 * 设置游戏窗口的高度
	 * @param height
	 */
	public static void setHeight(int height) {
		GameConstant.height = height;
	}
	/**
	 * 获取是否在屏幕上显示FPS
	 * @return
	 */
	public static boolean isFps() {
		return GameConstant.isFps;
	}
	/**
	 * 设置是否显示FPS
	 * @param isFps
	 */
	public static void setFps(boolean isFps) {
		GameConstant.isFps = isFps;
	}
	/**
	 * 获取是否显示当前时间
	 * @return
	 */
	public static boolean isTime() {
		return GameConstant.isTime;
	}
	/**
	 * 设置是否显示当前时间
	 * @param isTime
	 */
	public static void setTime(boolean isTime) {
		GameConstant.isTime = isTime;
	}
	public static boolean isQuality() {
		return isQuality;
	}
	public static void setQuality(boolean isQuality) {
		GameConstant.isQuality = isQuality;
	}
	public static String getBgName() {
		return bgName ;
	}
	public static void setBgName(String bgName) {
		GameConstant.bgName = bgName;
	}
	public static boolean isRunning() {
		return isRunning;
	}
	public static void setRunning(boolean isRunning) {
		GameConstant.isRunning = isRunning;
	}
	public static boolean isPause() {
		return isPause;
	}
	public static void setPause(boolean isPause) {
		GameConstant.isPause = isPause;
	}
	
}
