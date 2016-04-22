package net.keshen.base.frame;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JWindow;

import net.keshen.base.listener.WindowKeyListener;

import com.sun.awt.AWTUtilities;

/**
 * @author shenke
 * @date 2016-4-21 上午10:13:42
 */
public class BaseWindow extends JWindow{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9217687391592039753L;
	
	public BaseWindow(){
		//setUndecorated(true);
		setLocationRelativeTo(null);
	}
	
	/**
	 * 设置整个窗口透明
	 * @param tf true 透明 false 默认
	 */
	@SuppressWarnings("restriction")
	public void setTransparent(boolean tf){
		AWTUtilities.setWindowOpaque(this,!tf);
	}
	
	/**
	 * 
	 * @return
	 */
	public WindowKeyListener getKeyListener(){
		for (KeyListener keyListener : this.getKeyListeners()) {
			if(keyListener instanceof WindowKeyListener){
				return (WindowKeyListener) keyListener;
			}
		}
		return null;
	}

	/**
	 * 广播按键事件
	 * @param e
	 */
	public void broadCastKeyEvent(KeyEvent e,int eventType){
		for (Component component : this.getComponents()) {
			if(component instanceof BasePanel){
				KeyListener keyListener = ((BasePanel) component).getKeyListener();
				switch (eventType) {
					case KeyEvent.KEY_PRESSED:
						keyListener.keyPressed(e);
						break;
					case KeyEvent.KEY_RELEASED:
						keyListener.keyReleased(e);
						break;
					case KeyEvent.KEY_TYPED:
						keyListener.keyTyped(e);
					default:
						break;
				}
				return ; 
			}
		}
	}
	
}
