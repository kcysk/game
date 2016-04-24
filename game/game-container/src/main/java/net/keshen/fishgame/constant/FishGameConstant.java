package net.keshen.fishgame.constant;

/**
 * 捕鱼达人的相关常量
 * @author shenke
 * @date 2016-3-2 下午5:29:36
 */
public class FishGameConstant {
	
	/**
	 * 图片配置文件对应的后缀
	 */
	public static final String IMAGE_CONFIG_SUFFIX = ".plist";
	
	/**
	 * 所有鱼类配置文件的配置文件的路径
	 */
	public static final String FISH_CONFIG_PATH = "fish/FishConfig";
	
	/**
	 * 配置文件的编码格式
	 */
	public static final String CONFIG_ENCODE = "UTF-8";
	
	/**
	 * 鱼动作图片的配置信息 KEY
	 */
	public static final String KEY_FISH_ACT_CONFIG = "fishActConfig";
	
	/**
	 * 鱼基本信息的配置信息 KEY
	 */
	public static final String KEY_FISH_INFO_CONFIG = "fishInfoConfig";
	
	/**
	 * 背景图片的路径
	 */
	public static final String BG_PATH = "bg/";
	
	/**
	 * 背景音乐的路径
	 */
	public static final String BGM_PATH = "bgm/";
	
	/**
	 * 大炮相关文件的路径
	 */
	public static final String CANNON_PATH = "cannon/";
	
	/**
	 * 底座，数字等相关文件的路径
	 */
	public static final String COMPONET_PATH = "componet/";
	
	/**
	 * 进度条相关文件的路径
	 */
	public static final String PROGRESS_PATH = "progress/";
	
	/**
	 * 金币相关文件的路径
	 */
	public static final String SCORE_PATH = "score/";
	
	
	/*=========================鱼群游动方向相关常量============================*/
	
	public static final double PI = Math.PI;
	
	/**
	 * 对应的方向为向右直线游动 
	 */
	public static final double ROTATE_R = 1*PI/4;
	
	public static final double ROTATE_L = 3*PI/4;
	                    
	public static final double ROTATE_U = 2*PI/4;
	                    
	public static final double ROTATE_D = 0*PI/4;
	
	public static final int FISH_RUN_SLEEP = 1000;
	
	
	
	
}
