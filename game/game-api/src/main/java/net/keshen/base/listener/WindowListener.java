package net.keshen.base.listener;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;


import net.keshen.base.frame.BaseFrame;

/**
 * @author shenke
 * @date 2016-4-21 上午10:03:20
 */
public interface WindowListener extends KeyListener , MouseListener{

	public void setjFrame(BaseFrame frame);
}
