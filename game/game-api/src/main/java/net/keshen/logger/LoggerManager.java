package net.keshen.logger;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import net.keshen.logger.jdk.JdkLoggerAdapter;
import net.keshen.logger.log4j.Log4jLoggerAdapter;
import net.keshen.logger.sl4j.Sl4jLoggerAdapter;
import net.keshen.logger.support.FailsafeLogger;
import net.keshen.util.StringUtils;

/**
 * 日志输出器管理器
 * @author shenke
 * @date 2016-3-28 下午3:38:10
 */
public class LoggerManager {
	
	private static LoggerAdapter LOGGER_ADAPTER;
	
	private static final ConcurrentMap<String,FailsafeLogger> LOGGERS = new ConcurrentHashMap<String, FailsafeLogger>();
	
	static{
		String key = System.getProperty("net.keshen.logger");
		if(StringUtils.isEmpty(key)){
			setLoggerAdapter(new Log4jLoggerAdapter());
			System.out.println("未检测到日志使用类型的相关配置，使用默认配置：Log4j。。。。。");
		}
		if("log4j".equals(key)){
			setLoggerAdapter(new Log4jLoggerAdapter());
		}
		else if("sl4j".equals(key)){
			setLoggerAdapter(new Sl4jLoggerAdapter());
		}
		else if("jdk".equals(key)){
			setLoggerAdapter(new JdkLoggerAdapter());
		}
	}
	
	
	private LoggerManager(){
		
	}
	
	/**
	 * 设置日志输出器提供器
	 * @param adapter
	 */
	public static void setLoggerAdapter(LoggerAdapter adapter){
		adapter.getLogger(LoggerManager.class).info("using logger:"+adapter.getClass().getName());
		LOGGER_ADAPTER = adapter;
		//for()
	}
	
	/**
	 * 获取日志输出器
	 * @param clazz
	 * @return 
	 * 
	 */
	public static Logger getLogger(Class<?> clazz){
		FailsafeLogger logger = LOGGERS.get(clazz.getName());
		if(logger==null){
			LOGGERS.putIfAbsent(clazz.getName(), new FailsafeLogger(LOGGER_ADAPTER.getLogger(clazz)));
			logger = LOGGERS.get(clazz.getName());
		}
		return logger;
	}
	
	/**
	 * 获取日志输出去器
	 * @param name
	 * @return
	 */
	public static Logger getLogger(String name){
		FailsafeLogger logger = LOGGERS.get(name);
		if(logger==null){
			LOGGERS.putIfAbsent(name, new FailsafeLogger(LOGGER_ADAPTER.getLogger(name)));
			logger = LOGGERS.get(name);
		}
		return logger;
	}
	
}
