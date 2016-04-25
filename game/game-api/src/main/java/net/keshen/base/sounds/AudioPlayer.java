package net.keshen.base.sounds;

import java.io.File;

import javax.media.Controller;
import javax.media.ControllerEvent;
import javax.media.ControllerListener;
import javax.media.EndOfMediaEvent;
import javax.media.Manager;
import javax.media.Player;
import javax.media.Time;

import net.keshen.logger.Logger;
import net.keshen.logger.LoggerManager;

/**
 * 音乐播放器,目前仅支持wav格式的文件
 * 
 * @author shenke
 * @date 2016-4-25 上午10:11:41
 */
public class AudioPlayer {

	private static final Logger logger = LoggerManager.getLogger(AudioPlayer.class);
	
	private Thread audioPlayer;
	private Player player;

	private String musicFile = "";

	private boolean isLoop = false;
	private boolean isTurnOff = false;

	public AudioPlayer(String file) {
		try {
			this.musicFile = file;
			player = Manager.createRealizedPlayer(new File(musicFile).toURI().toURL());
			player.addControllerListener(new AudioPlayerControllListener());
			audioPlayer = new AudioPlayerThread(this);
		} catch (Exception e) {
			logger.error(e);
		}
	}

	public boolean isRunning() {
		return player.getState() == player.Started;
	}

	public void play() {
		if (!isTurnOff)
			player.start();
	}

	public void loop() {
		if (isTurnOff)
			return;
		isLoop = true;
		player.prefetch();
		replay();
	}

	public void stop() {
		player.stop();
	}

	public void replay() {
		if (isTurnOff)
			return;
		if (player.getState() == Controller.Prefetched)
			player.setMediaTime(new Time(0));
		player.start();
	}

	public void close(){
		player.stop();
		player.close();
	}
	
	private class AudioPlayerControllListener implements ControllerListener {

		public void controllerUpdate(ControllerEvent e) {
			if (e instanceof EndOfMediaEvent) {
				if (isLoop) {
					player.setMediaTime(new Time(0));
					player.start();
				}
			}
		}

	}
	
	private class AudioPlayerThread extends Thread{

		private AudioPlayer player;
		
		public AudioPlayerThread(AudioPlayer player){
			this.player = player;
		}
		
		@Override
		public void run() {
			player.loop();
		}
		
	}
}
