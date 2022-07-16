package science.skywhale.bloodmortgage;

import java.util.ArrayList;

public class Battle {
	//TODO: negative damage heals other side
    private CharacterEntity opponent;
    private CharacterEntity player;
	private CharacterEntity winner;
    //private ArrayList<CharacterEntity> opponentMinions;
    //private ArrayList<CharacterEntity> playerMinions;

    public Battle(Character player, Character opponent){
        this.player = new CharacterEntity(player);
        this.opponent = new CharacterEntity(opponent);
		this.winner = null;
    }

	public void battleRound(){
		// Player goes
		CharacterEntity current = player;
		
		winner = turn(current);
		logScores();
		// switch players to opponent
		current = getOtherSide(current);
		// take players turn
		winner = turn(current);
		logScores();
	}
	
	private CharacterEntity getOtherSide(CharacterEntity current){
		if (current.name == opponent.name){
			current = player;
		} else {
			current = opponent;
		}
		return current;
	}
	
	public void logScores(){
		//System.out.println("ROUND");
		System.out.println("Player: " + player.health);
		System.out.println("Opponent: " + opponent.health);
		System.out.println();
	}
	
	// **** TRUE RESPONSE means there was a winner, not which one won*****
	public Boolean playerTurn(){
		CharacterEntity result = turn(player);
		if (result != null){
			winner = result;
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean opponentTurn(){
		CharacterEntity result = turn(opponent);
		if (result != null){
			winner = result;
			return true;
		} else {
			return false;
		}
	}
	
	public Character checkWinner(){
		// TODO: Only one winner so this could be interesting if both are 0
		if (opponent.health <= 0){
			winner = player;
			return player.character;
		}
		if (player.health <= 0){
			winner = opponent;
			return opponent.character;
		}
		return null;
	}
	
    public CharacterEntity turn(CharacterEntity myTurn){
        System.out.println("Turn: " + myTurn.name);
		
		// roll dice
		Dice dice = myTurn.character.getDie();
		int roll = dice.roll();
		String glyphName = "NONE";
		if (dice.getSide(roll) != null){
			glyphName = dice.getSide(roll).getName();
		}
		System.out.println("Rolled: " + roll + " Glyph: " + glyphName);
		
		int damageDone = dice.executeRoll(roll);
		
		// negative dameDone heals
		if (damageDone < 0){
			CharacterEntity otherSide = getOtherSide(myTurn);
			otherSide.health -= damageDone;
			// don't let helath go above max possible
			if (otherSide.health > otherSide.character.getMaxHealth()){
				otherSide.health = otherSide.character.getMaxHealth();
			}
			// return null because nobody will lose because no loss in health
			return null;
		}
		// damage other side
		if (getOtherSide(myTurn).takeDamage(damageDone) == true){
			return myTurn;
		} else {
			return null;
		}
    }


    // for keeping character and helath together if more than two parties
    private class CharacterEntity {
        public Character character;
        public int health;
		public String name;

        public CharacterEntity(Character character){
            this.character = character;
            this.health = character.getMaxHealth();
			this.name = character.getName();
        }


        public Boolean takeDamage(int damage){
            // if this is > 0 all damage was blocked
            int block = character.getBattleBlock();
            if (damage - block > 0) {
                health = health - damage + block;
            }
            character.setBattleBlock(0);
			
			// look for healing
			health += character.getToHeal();
			// make sure doesn't go over max health
			if (health > character.getMaxHealth()){
				health = character.getMaxHealth();
			}
			character.setToHeal(0);
			
			// check if dead
			if (health <= 0){
				return true;
			} else {
				return false;
			}
        }
    }

}
