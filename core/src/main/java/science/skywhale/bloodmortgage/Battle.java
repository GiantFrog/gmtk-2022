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

    public void playerTurn(){
        // player roll dice
    }


    // for keeping character and helath together if more than two parties
    private class CharacterEntity {
        public Character character;
        public int health;

        public CharacterEntity(Character character, int health){
            this.character = character;
            this.health = health;
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
