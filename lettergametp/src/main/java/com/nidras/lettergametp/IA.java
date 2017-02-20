package com.nidras.lettergametp;

import java.util.ArrayList;

public class IA extends Player{
	
	private Game game;
	
	public IA(Game game){
		
		this.game = game;
		
	}
	
	public void play(){
		
		String poolContent = "";
		ArrayList<String> playableWords;
		
		for(int i = 0 ; i < game.getCommonPool().getNumberOfElements() ; i ++) poolContent += game.getCommonPool().getElement(i);
		
		playableWords = game.getDictionary().wordMaker(poolContent);
		
		String toPlay = "";
		
		for(String i : playableWords){
			
			if(game.getDictionary().countVowel(i) > game.getDictionary().countVowel(toPlay)) toPlay = i;
			
			if(toPlay.length() >= 5 - game.getPlayerPool().getNumberOfElements()){
				
				game.getIAPool().addElement(toPlay);
    			for(int j = 0 ; j < toPlay.length() ; j ++) game.getCommonPool().removeElement(toPlay.charAt(j));
    			game.getCommonPool().addElement(game.getPlayer().drawLetter());
    			game.getGUI().update();
    			break;
				
			}
			
		}
		
		System.out.println("toPlay : " + toPlay);
		
	}

}
