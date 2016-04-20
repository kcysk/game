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
		
		return !isEmpty(str);
	}
	/**
	 * 判断字符串为null或者Empty
	 * @param str
	 * @return
	 */
	public static final boolean isEmpty(String str){
		
		return str==null || str.length()==0;
	}
	
	public static final boolean isNotBlank(String str){
		if(str==null ||str.length()==0){
			return false;
		}
		for (char ch : str.toCharArray()) {
			if(Character.isWhitespace(ch) == false){
				return true;
			}
		}
		return false;
	}
	
	public static final boolean isBlank(String str){
		
		return !isNotBlank(str);
	}
	
	/**
	 * 比较两个字符串是否Equals</br>
	 * str1 is null and str2 is null return true </br>
	 * str1 is "" and str2 is "" return true </br>
	 * str1 is "" and str2 is null return false </br>
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static final boolean isEquals(String str1,String str2){
		if(str1==null && str2==null)
			return true;
		if(str1!=null){
			return str1.equals(str2);
		}
		if(str2!=null){
			return str2.equals(str1);
		}
		return false;
	}
	
	/**
	 * 将首字母小写
	 * @param str
	 * @return
	 */
	public static final String getFirstCharLowerCase(String str){
		if(isEmpty(str)){
			return str;
		}
		else{
			if(str.length()==1){
				return str.toLowerCase();
			}
			return str.substring(0, 1).toLowerCase()+str.substring(1);
		}
	}
	
	/**
	 * 将首字母大写
	 * @param str
	 * @return
	 */
	public static final String getFirstCharUpperCase(String str){
		if(isEmpty(str)){
			return str;
		}
		else{
			if(str.length()==1){
				return str.toUpperCase();
			}
			return str.substring(0, 1).toUpperCase()+str.substring(1);
		}
	}
	
}
