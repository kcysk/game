package net.keshen.container;

import java.util.HashMap;
import java.util.Map;

import net.keshen.util.StringUtils;

/**
 * @author shenke
 * @date 2016-4-15 下午4:50:37
 */
public class ApplicationContext {
	
	private static final Map<Class<? extends Object>,Object> CLASS_CONTAINER = new HashMap<Class<? extends Object>, Object>();
	
	private static final Map<String,Class<? extends Object>> NAME_CONTAINER = new HashMap<String,Class<? extends Object>>();
	
	public void init(){
		
	}
	
	
	@SuppressWarnings("unchecked")
	public <V> V getBean(Class<? extends Object> clazz){
		return (V) CLASS_CONTAINER.get(clazz);
	}
	
	@SuppressWarnings("unchecked")
	public <V> V getBean(String key){
		return (V) NAME_CONTAINER.get(key);
	}
	
//	@SuppressWarnings("unchecked")
//	public <V> V getBean(Object obj){
//		return (V) OBJECT_CONTAINER.get(obj);
//	}
	
	public <V> V putBean(Class<? extends Object> clazz,V value){
		if(value==null||clazz==null){
			try {
				throw new Exception("key or value is null");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else{
			CLASS_CONTAINER.put(clazz, value);
			NAME_CONTAINER.put(StringUtils.getFirstCharLowerCase(clazz.getSimpleName()), value.getClass());
//			OBJECT_CONTAINER.put(value, value.getClass());
		}
		return value;
		
	}
	
	public <V> V putBean(String name,V value){
		if(value!=null&&StringUtils.isNotEmpty(name)){
			CLASS_CONTAINER.put(value.getClass(), value);
			NAME_CONTAINER.put(name, value.getClass());
//			OBJECT_CONTAINER.put(value, value.getClass());
		}
		else{
			try {
				throw new Exception("value cannot is null!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return value;
	}
	
	public <V> V putBean(Object obj,V value){
		if(value!=null&&obj!=null){
			CLASS_CONTAINER.put(obj.getClass(), value);
			NAME_CONTAINER.put(StringUtils.getFirstCharLowerCase(obj.getClass().getSimpleName()), value.getClass());
//			OBJECT_CONTAINER.put(obj, value.getClass());
		}
		else{
			try {
				throw new Exception("key or value is null!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return value;
	}
}
