package science.skywhale.bloodmortgage;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

import static science.skywhale.bloodmortgage.Dice.diceSides;

public class Battle {
    private CharacterEntity opponent;
    private CharacterEntity player;
	private Character winner;
	private ArrayList<String> log;
	private ArrayList<Character> onMap;
	private GameScreen game;
    //private ArrayList<CharacterEntity> opponentMinions;
    //private ArrayList<CharacterEntity> playerMinions;

    public Battle(Character player, Character opponent, ArrayList<Character> onMap, GameScreen game){
		player.setInBattle(true);
        this.player = new CharacterEntity(player);
        this.opponent = new CharacterEntity(opponent);
		this.winner = null;
		log = new ArrayList<String>();
		log.add("Battle Started");
		log.add(0, player.getName() + " vs. " + opponent.getName());
		this.onMap = onMap;
		this.game = game;
    }
	
	public String renderLog(int numLines){
		String output = "";
		for(int i =0; i < numLines-log.size();i++){
			output += "\n";
		}
		if (numLines-log.size() >0 ){
			numLines = log.size();
		}
		
		for (int i=numLines-1; i >= 0; i--){
			output += log.get(i) + "\n";
		}
		
		return output;
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
			player.character.setInBattle(false);
			onMap.remove(opponent.character);
			game.enemyTheme.stop();
			game.vibing.play();
			game.currentSong = game.vibing;
			//return player;
		}
		if (player.health <= 0){
			winner = opponent.character;
			player.character.setInBattle(false);
			player.character.x = player.character.homeX;
			player.character.y = player.character.homeY;
			game.enemyTheme.stop();
			game.intro.play();
			game.currentSong = game.intro;
			//return opponent;
		}
		//return null;
	}
	
	public Character getWinner(){
		return winner;
	}
	
    public void turn(CharacterEntity myTurn){
        System.out.println("Turn: " + myTurn.name);
		log.add(0, myTurn.name + "'s turn");
		
		// roll dice
		Dice dice = myTurn.character.getDie();
		int roll = dice.roll();
		String glyphName = "NONE";
		if (dice.getSide(roll) != null){
			glyphName = dice.getSide(roll).getName();
		}
		if (myTurn.name.equals("Kal"))
		{
			game.hud.lastRoll = diceSides[roll-1];
			//TODO I think each Glyph should have a Texture, making a new one from the path is bad
			if (dice.getSide(roll) != null)
				game.hud.lastGlyph = new Texture(Gdx.files.internal(dice.getSide(roll).getImgPath()));
		}
		System.out.println("Rolled: " + roll + " Glyph: " + glyphName);
		log.add(0, "   Rolled " + roll + " with glpyh " + glyphName);
		
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
		log.add(0, "   " + player.name + ": " + player.health +
				   " " + opponent.name + ": " + opponent.health);
		checkWinner();
		if (winner != null){
			log.add(0, "**" + winner.getName() + " won!**");
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
