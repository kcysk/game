package net.keshen.frame.test;

import java.util.Map;

import org.junit.Test;

import net.keshen.base.graphics.Bitmap;
import net.keshen.fishgame.manager.ImageManager;
import net.keshen.fishgame.utils.PropertiesUtils;

/**
 * @author shenke
 * @date 2016年4月16日下午7:46:41
 * @version 1.0
 */
public class ImageManagerTest {

	@Test
	public void testInit(){
		ImageManager imageManager = ImageManager.getImageManager();
		PropertiesUtils.init();
		Map<String,Bitmap> maps = imageManager.getBitmapsByImageConfig(System.getProperty("fish.config.fish"));
		for (String str : maps.keySet()) {
			System.out.println(str);
		}
		//imageManager.init();
	}
}
