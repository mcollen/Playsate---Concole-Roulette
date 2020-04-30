package com.playsafe.roulette;

public class launchConsole implements Runnable{

	@Override
	public void run() {
			
		try {
			
			//wait 30seconds before a rerun
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
