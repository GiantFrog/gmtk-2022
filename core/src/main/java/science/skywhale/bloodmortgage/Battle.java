package science.skywhale.bloodmortgage;

import java.util.ArrayList;

public class Battle {
	//TODO: negative damage heals other side
    private CharacterEntity opponent;
    private CharacterEntity player;
    //private ArrayList<CharacterEntity> opponentMinions;
    //private ArrayList<CharacterEntity> playerMinions;

    public Battle(Character player, int playerStartHealth, Character opponent, int opponentStartHealth){
        this.player = new CharacterEntity(player, playerStartHealth);
        this.opponent = new CharacterEntity(opponent, opponentStartHealth);
    }

	public void battle(){
		CharacterEntity winner = null;
		CharacterEntity current = opponent;
		while (winner == null){
			// switch players
			current = getOtherSide(current);
			// take players turn
			winner = turn(current);
			logScores();
		}
		System.out.println("WINNER! " + current.name);
	}
	
	private CharacterEntity getOtherSide(CharacterEntity current){
		if (current.name == opponent.name){
			current = player;
		} else {
			current = opponent;
		}
		return current;
	}
	
	private void logScores(){
		//System.out.println("ROUND");
		System.out.println("Player: " + player.health);
		System.out.println("Opponent: " + opponent.health);
		System.out.println();
	}
	
    public CharacterEntity turn(CharacterEntity myTurn){
        System.out.println("Turn: " + myTurn.name);
		
		// roll dice
		Dice dice = myTurn.character.getDie();
		int roll = dice.roll();
		System.out.println("Rolled: " + roll);
		
		int damageDone = dice.executeRoll(roll);
		// TODO: if damageDone is negative, heal other player
		
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

        public CharacterEntity(Character character, int health){
            this.character = character;
            this.health = health;
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
