package net.keshen.util;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.keshen.base.graphics.Bitmap;

/**
 * 图片工具类
 * @author shenke
 *
 */
public final class ImageUtils {

	/**
	 * 旋转图片，源图片本身并不会旋转
	 * @param image 源图片
	 * @param angle 旋转的角度
	 * @return 旋转之后的图片(新的)
	 */
	public static final BufferedImage rotateImage(BufferedImage image,double angle){
		int w = image.getWidth();
		int h = image.getHeight();
		BufferedImage bImage = new BufferedImage(w, h,BufferedImage.TYPE_4BYTE_ABGR);
		Graphics2D g2d = bImage.createGraphics();
		g2d.rotate(angle,w/2,h/2);
		g2d.drawImage(image,0, 0, null);
		g2d.dispose();

		return bImage;
	}
	/**
	 * 缩放图片
	 * @param srcImage
	 * @param persent	缩放比例
	 * @return
	 */
	public static final Bitmap scaleImageByProportion(BufferedImage srcImage,float proportion){
		AffineTransform transform = new AffineTransform();
		transform.setToScale(proportion, proportion);
		BufferedImage scaleImage = new BufferedImage((int)(srcImage.getWidth()*proportion), (int)(srcImage.getHeight()*proportion), BufferedImage.TYPE_4BYTE_ABGR);
		Graphics2D g = (Graphics2D) scaleImage.getGraphics();
		//设置抗锯齿
		RenderingHints quality = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		quality.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.setRenderingHints(quality);
		g.drawImage(scaleImage, transform, null);
		return new Bitmap(scaleImage);
	}
	/**
	 * 根据屏幕尺寸缩放图片
	 * @param srcImage
	 * @return
	 */
	public static final Bitmap scaleImageByScreenSize(BufferedImage srcImage,int screenHeight,int screenWidth){
		float scalNum = 1;
		//根据屏幕尺寸动态缩放图片
		if(screenHeight<500){
			scalNum = 0.75f;
		}
		
		return scaleImageByProportion(srcImage, scalNum);
	}
	
	/**
	 * 从资产文件夹下获取
	 * @param fileName is path
	 * @return {@link Bitmap}
	 */
	public static final Bitmap getBitmapByAssert(String fileName){
		try {
			return new Bitmap(ImageIO.read(new File(fileName)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @param fileName
	 * @return
	 */
	public static final BufferedImage getImageByAssert(String fileName){
		
		try {
			return ImageIO.read(new File(fileName+".png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
