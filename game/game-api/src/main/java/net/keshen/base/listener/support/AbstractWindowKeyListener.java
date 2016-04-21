package net.keshen.base.listener.support;

import net.keshen.base.frame.BaseWindow;
import net.keshen.base.listener.WindowKeyListener;

/**
 * @author shenke
 * @date 2016-4-21 上午10:15:47
 */
public abstract class AbstractWindowKeyListener implements WindowKeyListener{

	@SuppressWarnings("unused")
	protected BaseWindow frame;

	public void setJFrame(BaseWindow frame) {
		this.frame = frame;
	}
	
	
}
