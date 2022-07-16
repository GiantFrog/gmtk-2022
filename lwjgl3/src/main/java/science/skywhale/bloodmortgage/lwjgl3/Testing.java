package science.skywhale.bloodmortgage.lwjgl3;

import science.skywhale.bloodmortgage.Battle;
import science.skywhale.bloodmortgage.Character;

public class Testing {
	
	public static void testBattle(){
		System.out.println("Testing battle");
		//Texture text = new Texture("Kal.png");
		// make characters player
		Character player = new Character("player", 1, 20);
		player.setDie(6);
		
		// make character opponent
		Character opponent = new Character("opponent", 1, 20);
		opponent.setDie(6);
		
		// Test with just regular dice
		//fight(player, opponent);
		
		// test glyphs
		//player.printSpellbook();
		
		player.addGlyphToDice(0, 1);
		player.addGlyphToDice(0, 2);
		player.addGlyphToDice(0, 3);
		player.addGlyphToDice(0, 4);
		player.getDie().printGlyphs();
		//player.printSpellbook();
		
		
		fight(player, opponent);
		
		
		
	}
	
	public static void fight(Character player, Character opponent){
		Battle battle = new Battle(player, opponent);
		
		// fight
		Boolean fightOver = false;
		battle.logScores();
		System.out.println("START BATTLE!");
		// while loop for testing
		Boolean playerTurn = true;
		while (!fightOver){
			if (playerTurn) {
				fightOver = battle.playerTurn();
			} else {
				fightOver = battle.opponentTurn();
			}
			battle.logScores();
			playerTurn = !playerTurn;
		}
		
		// print winner
		System.out.println("WINNER: " + battle.checkWinner().getName());
	}
	
}
