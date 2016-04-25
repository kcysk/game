package net.keshen.thread;

import net.keshen.base.sounds.AudioPlayer;

/**
 * @author shenke
 * @date 2016-4-25 下午2:57:38
 */
public class TestPlayer {

	public static void main(String[] args) {
		AudioPlayer player = new AudioPlayer("bgm/wav/bg.wav");
		player.play();
	}
}
