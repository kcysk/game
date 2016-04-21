package net.keshen.base.listener;

import java.awt.event.MouseListener;

import net.keshen.base.frame.BaseFrame;

/**
 * @author shenke
 * @date 2016-4-21 上午10:02:44
 */
public interface WindowMouseListener extends MouseListener{

	public void setJFrame(BaseFrame frame);
}
