package net.keshen.base.listener;

import java.awt.event.KeyListener;

import net.keshen.base.frame.BaseWindow;

/**
 * @author shenke
 * @date 2016-4-21 上午10:02:25
 */
public interface WindowKeyListener extends KeyListener{
	
	public void setJFrame(BaseWindow frame);
}
