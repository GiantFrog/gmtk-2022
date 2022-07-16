package science.skywhale.bloodmortgage;


public class Battle {
	//TODO: negative damage heals other side
    private CharacterEntity opponent;
    private CharacterEntity player;
	private Character winner;
    //private ArrayList<CharacterEntity> opponentMinions;
    //private ArrayList<CharacterEntity> playerMinions;

    public Battle(Character player, Character opponent){
        this.player = new CharacterEntity(player);
        this.opponent = new CharacterEntity(opponent);
		this.winner = null;
    }
	
	private CharacterEntity getOtherSide(CharacterEntity current){
		if (current.name.equals(opponent.name)){
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
		turn(player);
		return winner != null;
	}
	
	public Boolean opponentTurn(){
		turn(opponent);
		
		return winner != null;
	}
	
	public void checkWinner(){
		// TODO: Only one winner so this could be interesting if both are 0
		if (opponent.health <= 0){
			winner = player.character;
			//return player;
		}
		if (player.health <= 0){
			winner = opponent.character;
			//return opponent;
		}
		//return null;
	}
	
	public Character getWinner(){
		return winner;
	}
	
    public void turn(CharacterEntity myTurn){
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
		
		// heal first
		CharacterEntity otherSide = getOtherSide(myTurn);
		// do negative damage, heal opponent
		if (damageDone < 0) {
			otherSide.character.setToHeal((-1*damageDone));
			damageDone = 0; // set to 0 so don't take damage
		}
		otherSide.heal();
		myTurn.heal();
		otherSide.takeDamage(damageDone);
		checkWinner();
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
		@Override
		public String toString() {
			return name;
		}
		public void heal(){
			health += character.getToHeal();
			if (health > character.getMaxHealth()){
				health = character.getMaxHealth();
			}
			character.setToHeal(0);
		}

        public void takeDamage(int damage){
            // if this is > 0 all damage was blocked
            int block = character.getBattleBlock();
            if (damage - block > 0) {
                health = health - damage + block;
            }
            character.setBattleBlock(0);
        }
    }

}
