package net.keshen.thread;

import net.keshen.base.threads.BasePanelThread;

/**
 * @author shenke
 * @date 2016-4-22 上午10:43:35
 */
public class BasePanelThreadTest {

	public static void main(String[] args) {
		BasePanelThread t = new BasePanelThread();
		t.start();
		try {
			System.out.println("休眠1");
			Thread.sleep(1000);
			System.out.println("休眠1Over");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("暂停");
		t.suspendBaseThread();
		try {
			System.out.println("休眠2");
			Thread.sleep(1000);
			System.out.println("休眠2Over");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t.resumeBaseThread();
		
	}
}
