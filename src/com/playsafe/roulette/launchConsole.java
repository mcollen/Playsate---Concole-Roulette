package com.playsafe.roulette;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

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
		try {
			
	        BufferedReader reader=new BufferedReader(new FileReader("playerList.txt"));
	       	        
	        // load all players
	        loadPlayers(reader);
	        
	        //Read console input
	        readConsoleInput();
	        
	        //generate rondom number
	        Random random = new Random();
	        int range = 36;
	        int randomNumber =  random.nextInt(range) + 1;
	        System.out.println("Winning Number is:    "+randomNumber);
	        
	        //check winners
	        checkWinners(randomNumber);
	        
		} catch (FileNotFoundException ex) {
			System.out.println("Please add Players List file(payerList.txt) to :"+System.getProperty("user.dir"));
		}
		return true;       
	}

	private void checkWinners(int randomNumber) {
				
	}

	private void loadPlayers(BufferedReader reader) throws IOException {
		String line;
		while ((line = reader.readLine()) != null) {
        	record = new ArrayList<String>();
        	lists.put(line, record);
        }
		System.out.println("Player name list Loaded Successful");
	}
	
	private void readConsoleInput() throws IOException {
		Scanner reader = new Scanner(System.in);
		String line = reader.next();
		String[] bet;
		while (line != null && !line.contentEquals("end")) {
			bet = line.split(" ");
			record = new ArrayList<String>();
			if (bet.length > 1) {
				record.add(bet[1]); //store bet number
				record.add(bet[2]); //store bet amount
				lists.get(bet[0]).addAll(record); //keep history
			} else {
				System.out.println("Please Enter correct input \n <Player name> [bet] [amount] ... or 'end' to end list");
			}
			reader = new Scanner(System.in);
			line = reader.next();
		}
	}
	
}
