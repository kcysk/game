package net.keshen.frame.test;

import net.keshen.fishgame.config.Configuration;
import net.keshen.util.ImageUtils;

/**
 * @author shenke
 * @date 2016-4-25 上午11:12:34
 */
public class ImageUtilsTest {

	public static void main(String[] args) {
		Configuration.newInstance().init();
		ImageUtils.getBitmapByAssertNoPath("bottom");
	}
}
