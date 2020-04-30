package com.playsafe.roulette;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class launchConsole implements Runnable{
	
	ArrayList<String> record;
	HashMap<String,ArrayList<String>> lists = new HashMap<String,ArrayList<String>>();
	
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
        
        // load all players
        while ((line = reader.readLine()) != null) {
        	
        	
        	
        	//System.out.println(line);
        }
		return false;       
	}

	private void loadPlayers(BufferedReader reader) throws IOException {
		String line;
		while ((line = reader.readLine()) != null) {
        	record = new ArrayList<String>();
        	lists.put(line, record);
        }
		
	}
}
