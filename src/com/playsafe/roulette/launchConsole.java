package com.playsafe.roulette;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        loadPlayers(reader);
        
        //Read console input
        readConsoleInput();
        
        //generate rondom number
        int play = Integer.parseInt(String.valueOf(Math.random()));
        System.out.println("Winning Number is:    "+play);
        
		return true;       
	}

	private void loadPlayers(BufferedReader reader) throws IOException {
		String line;
		while ((line = reader.readLine()) != null) {
        	record = new ArrayList<String>();
        	lists.put(line, record);
        }
		
	}
	
	private void readConsoleInput() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = reader.readLine();
		String[] bet = line.split(" ");
		while (bet != null && !bet[0].equals("end")) {
			record = new ArrayList<String>();
			if (bet.length > 1) {
				record.add(bet[1]); //store bet number
				record.add(bet[2]); //store bet amount
				lists.get(bet[0]).addAll(record); //keep history
			} else {
				System.out.println("Please Enter correct input \n <Player name> [bet] [amount] ... or 'end' to end list");
			}
		}
	}
	
}
