package net.keshen.fishgame.componets;

import net.keshen.base.basecomponet.Componet;
import net.keshen.base.basecomponet.GameConstant;
import net.keshen.base.graphics.Bitmap;
import net.keshen.base.graphics.Matrix;
import net.keshen.util.ImageUtils;

/**
 * @author shenke
 * @date 2016年4月20日下午10:03:23
 * @version 1.0
 */
public class Background extends Componet{

	@Override
	public Matrix getPicMatrix() {
		return getMatrix();
	}

	@Override
	public Bitmap getCurrentPic() {
		return super.bg;
	}

	@Override
	public int getPicWidth() {
		return getCurrentPic().getWidth();
	}

	@Override
	public int getPicHeight() {
		return getCurrentPic().getHeight();
	}

	@Override
	public void setBg(Bitmap bg) {
		
		super.setBg(ImageUtils.zoomBitmap(bg, GameConstant.getWidth(), GameConstant.getHeight()));
		//super.setBg(ImageUtils.scaleBitmapByScreenSize(bg.getImage(), GameConstant.getWidth(), GameConstant.getHeight()));
		System.out.println(getPicWidth()+":"+getPicHeight());
	}
}
