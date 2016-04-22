package net.keshen.base.frame;

import java.util.Map;

import net.keshen.base.drawable.Drawable;
import net.keshen.base.graphics.Canvas;
import net.keshen.base.listener.WindowKeyListener;

/**
 * @author shenke
 * @date 2016-4-21 上午11:08:26
 */
public interface BasePanel{
	
	public static final int CHANGE_MODEL_ADD = 0;   
    
	public static final int CHANGE_MODEL_REMOVE = 1;
	                        
	public static final int CHANGE_MODEL_UPDATE = 2;
	
	
	public void onDraw(Canvas canvas);
	
	public Canvas lockCanvas();
	
	public void unLockCanvas(Canvas canvas);
	
	public void putComponet2Layer(Drawable drawable,int layerId);
	
	public void putComponet2Layer(Map<Integer,Drawable> drableMap);
	
	public void removeComponetFromLayer(Drawable drawable,int layerId);
	
	public void removeComponetFromLayer(Drawable drawable);
	
	public void updateComponetLayer(int model,Drawable drawable,int layerId);
	
	public void updateComponetLayer(int model,Drawable drawable);
	
	public WindowKeyListener getKeyListener();
}
