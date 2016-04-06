package net.keshen.util;

/**
 * 字符串工具类
 * @author shenke
 *
 */
public final class StringUtils {

	public static final String EMPTY = "";
	
	/**
	 * 判断字符串是否为null或者Empty
	 * @param str
	 * @return
	 */
	public static final boolean isNotEmpty(String str){
		
		if(str==null||EMPTY.equals(str.trim())){
			return false;
		}
		else{
			return true;
		}
	}
	/**
	 * 判断字符串为null或者Empty
	 * @param str
	 * @return
	 */
	public static final boolean isEmpty(String str){
		
		if(str==null||EMPTY.equals(str.trim())){
			return true;
		}else{
			return false;
		}
	}
	
	public static final boolean isNotBlank(String str){
		
		if(str==null){
			return false;
		}
		else if(EMPTY.equals(str.trim())){
			return true;
		}
		return false;
	}
	
	public static final boolean isBlank(String str){
		
		if(str==null){
			return true;
		}
		else if(EMPTY.equals(str.trim())){
			return false;
		}
		return true;
	}
}
