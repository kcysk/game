package net.keshen.base.frame;

import java.awt.event.KeyListener;
import java.util.Map;

import javax.swing.JPanel;

import net.keshen.base.drawable.Drawable;
import net.keshen.base.listener.WindowKeyListener;

/**
 * @author shenke
 * @date 2016-4-21 下午1:56:42
 */
public abstract class AbstractBasePanel extends JPanel implements BasePanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6162817305037486659L;

	protected BaseWindow parentFrame;
	
	public AbstractBasePanel(){
		//应该是null的
		if(parentFrame!=null){
			setSize(parentFrame.getSize());
		}
	}

	public void putComponet2Layer(Drawable drawable, int layerId) {
		updateComponetLayer(CHANGE_MODEL_ADD, drawable, layerId);
	}

	public void putComponet2Layer(Map<Integer, Drawable> drawableMap) {
		for (Integer layerId : drawableMap.keySet()) {
			updateComponetLayer(CHANGE_MODEL_ADD, drawableMap.get(layerId), layerId);
		}
	}

	public void removeComponetFromLayer(Drawable drawable, int layerId) {
		if(drawable!=null){
			updateComponetLayer(CHANGE_MODEL_REMOVE, drawable, layerId);
		}
	}

	public void removeComponetFromLayer(Drawable drawable) {
		if(drawable!=null){
			updateComponetLayer(CHANGE_MODEL_REMOVE, drawable);
		}
	}

	public WindowKeyListener getKeyListener() {
		for (KeyListener keyListener : this.getKeyListeners()) {
			if (keyListener instanceof WindowKeyListener) {
				return (WindowKeyListener) keyListener;
			}
		}
		return null;
	}

}
