package net.keshen.base.threads;

import net.keshen.base.basecomponet.GameConstant;
import net.keshen.base.frame.BasePanel;
import net.keshen.base.graphics.Canvas;
import net.keshen.logger.Logger;
import net.keshen.logger.LoggerManager;

/**
 * @author shenke
 * @date 2016-4-22 上午9:55:15
 */
public class BasePanelThread extends Thread{
	
	private static final Logger logger = LoggerManager.getLogger(BasePanelThread.class);
	
	private BasePanel panel;
	private Canvas canvas ;
	
	private boolean running;
	private boolean wait;
	
	public BasePanelThread(BasePanel panel , Canvas canvas){
		this.panel = panel;
		this.canvas = canvas;
	}
	
	@Override
	public void run() {
		while(true){
		while(GameConstant.isRunning()){
			if(GameConstant.isPause()){
				suspendBaseThread();
			}else{
				resumeBaseThread();
			}
			try {
				synchronized (canvas) {
					if(!running){
						return ;
					}
					if(wait){
						canvas.wait();
					}
				}
				canvas = panel.lockCanvas();
				if(panel!=null){
					panel.onDraw(canvas);
				}
			} catch (Exception e) {
				logger.error(e);
			}finally{
				panel.unLockCanvas(canvas);
			}
			try {
				//FIXME repaint time
				Thread.sleep(200);
			} catch (Exception e) {
				logger.error(e);
			}
		}
		if(!GameConstant.isRunning()){
			break;
		}
		}
	}


	@Override
	public synchronized void start() {
		super.start();
		running = true;
		wait = false;
	}

	public void resumeBaseThread(){
		if(!wait){
			return ;
		}
		synchronized (canvas) {
			wait = false;
			canvas.notifyAll();
		}
	}
	
	public void suspendBaseThread(){
		if(wait){
			return ;
		}
		synchronized (canvas) {
			wait = true;
		}
	}

}
