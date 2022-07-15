package science.skywhale.bloodmortgage;

import java.util.ArrayList;

public class Battle {
    private Character opponent;
    private Character player;
    private int opponentHealth;
    private int playerHealth;
    //private ArrayList<CharacterEntity> opponentMinions;
    //private ArrayList<CharacterEntity> playerMinions;

    public Battle(Character player, int playerStartHealth, Character opponent, int opponentStartHealth){
        this.player = player;
        this.playerHealth = playerStartHealth;
        this.opponent = opponent;
        this.opponentHealth = opponentStartHealth;
    }


    /*
    // for keeping character and helath together if more than two parties
    private class CharacterEntity {
        public Character character;
        public int health;

        public CharacterEntity(Character character, int health){
            this.character = character;
            this.health = health;
        }
    }
     */
}
