package net.keshen.fishgame.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * 配置文件读取并初始化
 * 
 * @author shenke
 * @date 2016-4-20 上午10:29:57
 * 
 * @description
 *       java.runtime.name<-->Java(TM) SE Runtime Environment </br>
 *       sun.boot.library.path<-->D:\Program Files\Java\jdk1.6.0_20\jre\bin
 *       </br> java.vm.version<-->16.3-b01 </br> java.vm.vendor<-->Sun
 *       Microsystems Inc. </br> java.vendor.url<-->http://java.sun.com/ </br>
 *       path.separator<-->; </br> java.vm.name<-->Java HotSpot(TM) Client VM
 *       </br> file.encoding.pkg<-->sun.io </br>
 *       sun.java.launcher<-->SUN_STANDARD </br> user.country<-->CN </br>
 *       sun.os.patch.level<-->Service Pack 1 </br>
 *       java.vm.specification.name<-->Java Virtual Machine Specification </br>
 *       user.dir<-->H:\game\game\game-api </br>
 *       java.runtime.version<-->1.6.0_20-b02 </br>
 *       java.awt.graphicsenv<-->sun.awt.Win32GraphicsEnvironment </br>
 *       java.endorsed.dirs<-->D:\Program
 *       Files\Java\jdk1.6.0_20\jre\lib\endorsed </br> os.arch<-->x86 </br>
 *       java.io.tmpdir<-->C:\Users\ADMINI~1\AppData\Local\Temp\ </br>
 *       line.separator<--> </br> </br> java.vm.specification.vendor<-->Sun
 *       Microsystems Inc. </br> user.variant<--> </br> os.name<-->Windows 7
 *       </br> sun.jnu.encoding<-->GBK </br> java.library.path<--> </br>
 *       java.specification.name<-->Java Platform API Specification </br>
 *       java.class.version<-->50.0 </br> sun.management.compiler<-->HotSpot
 *       Client Compiler </br> os.version<-->6.1 </br>
 *       user.home<-->C:\Users\Administrator </br> user.timezone<--> </br>
 *       java.awt.printerjob<-->sun.awt.windows.WPrinterJob </br>
 *       file.encoding<-->UTF-8 </br> java.specification.version<-->1.6 </br>
 *       java.class.path<--> </br> user.name<-->Administrator </br>
 *       java.vm.specification.version<-->1.0 </br> java.home<-->D:\Program
 *       Files\Java\jdk1.6.0_20\jre </br> sun.arch.data.model<-->32 </br>
 *       user.language<-->zh </br> java.specification.vendor<-->Sun Microsystems
 *       Inc. </br> awt.toolkit<-->sun.awt.windows.WToolkit </br>
 *       java.vm.info<-->mixed mode, sharing </br> java.version<-->1.6.0_20
 *       </br> java.ext.dirs<-->D:\Program
 *       Files\Java\jdk1.6.0_20\jre\lib\ext;C:\Windows\Sun\Java\lib\ext </br>
 *       sun.boot.class.path<-- </br> java.vendor<-->Sun Microsystems Inc. </br>
 *       file.separator<-->\ </br>
 *       java.vendor.url.bug<-->http://java.sun.com/cgi-bin/bugreport.cgi </br>
 *       sun.io.unicode.encoding<-->UnicodeLittle </br> sun.cpu.endian<-->little
 *       </br> sun.desktop<-->windows </br> sun.cpu.isalist<--> </br>
 */
public class Configuration {

	private static Configuration configuration;

	// 此时Logger相关还未初始化无法使用Logger
	
	public void init(){
		InputStream in = null;
		try {
			//Windows
			if(System.getProperty("os.name").toLowerCase().contains("Windows".toLowerCase())){
				in = Configuration.class.getClassLoader().getResourceAsStream("config.properties");
				//File f = new File("src/main/resources/config.properties");
				//in = new FileInputStream(f);
				Properties p = new Properties();
				p.load(in);
				for (Object key : p.keySet()) {
					System.setProperty(key.toString(), p.getProperty(key.toString()));
				}
				//System.setProperties(p);
			}
			//Linux
			else{
				
			}
		} catch (Exception e) {
			System.out.print("加载配置文件失败！！！！！！");
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private Configuration() {

	}

	public static Configuration newInstance() {
		if (configuration == null) {
			configuration = new Configuration();
		}
		return configuration;
	}
	
	/**
	 * 获取配置参数
	 * @param key
	 * @return
	 */
	public String getProperty(String key) {
		return System.getProperty(key);
	}

	/**
	 * 设置配置参数
	 * @param key
	 * @param value
	 * @return
	 */
	public String setProperty(String key, String value) {
		return System.setProperty(key, value);
	}

	public static void main(String[] args) {
		for (Object string : System.getProperties().keySet()) {
			System.out.println(System.getProperty(string.toString()));
		}
	}
}
