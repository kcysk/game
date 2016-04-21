package net.keshen.fishgame.frame;

import java.awt.event.KeyEvent;

import javax.swing.JWindow;

import net.keshen.base.basecomponet.GameConstant;
import net.keshen.base.frame.BasePanel;
import net.keshen.base.frame.BaseWindow;
import net.keshen.base.listener.WindowKeyListener;
import net.keshen.base.listener.support.AbstractWindowKeyListener;

/**
 * 按Esc弹出的选择界面
 * @author shenke
 * @date 2016-4-21 上午10:00:00
 */
public class ESCWindow extends BaseWindow{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2995246116528075335L;

	private BasePanel escPanel;
	
	private WindowKeyListener keyListener;
	
	
	public ESCWindow(){
		setSize((int) (GameConstant.getWidth()*0.2),GameConstant.getHeight()*1/3);
		
		escPanel = new ESCPanel();
		setTransparent(true);
		//setVisible(true);
		keyListener = new ESCFrameKeyListener();
		this.addKeyListener(keyListener);
	}
	
	/**
	 * 
	 * @author shenke
	 *
	 */
	private class ESCFrameKeyListener extends AbstractWindowKeyListener{

		public void keyTyped(KeyEvent e) {
			
		}

		public void keyPressed(KeyEvent e) {
			
		}

		public void keyReleased(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
				
				
				//广播
				this.frame.broadCastKeyEvent(e, KeyEvent.KEY_RELEASED);
			}
		}
	}
	
	
}
