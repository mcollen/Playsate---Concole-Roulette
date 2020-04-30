package com.playsafe.roulette;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class launchConsole implements Runnable{

	@Override
	public void run() {
			
		try {
			while (startGame()) {			
				//wait 30seconds before a rerun
				Thread.sleep(30000);
			}
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private boolean startGame() throws IOException {		    
        BufferedReader reader=new BufferedReader(new FileReader("payerList.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
           System.out.println(line);
        }
		return false;       
	}

}
