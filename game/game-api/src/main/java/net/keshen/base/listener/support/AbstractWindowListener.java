package net.keshen.base.listener.support;

import net.keshen.base.frame.BaseWindow;
import net.keshen.base.listener.WindowListener;

/**
 * @author shenke
 * @date 2016-4-21 上午10:05:46
 */
public abstract class AbstractWindowListener implements WindowListener{

	@SuppressWarnings("unused")
	protected BaseWindow jFrame;

	public void setjFrame(BaseWindow frame) {
		this.jFrame = frame;
	}
	
}
