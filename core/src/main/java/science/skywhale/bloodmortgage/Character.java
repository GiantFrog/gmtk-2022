package science.skywhale.bloodmortgage;

import science.skywhale.bloodmortgage.masterspellbook.Glyph;

import java.util.ArrayList;

public class Character {
    private String name;
    private Dice[] dice;
    private ArrayList<Glyph> spellbook;
    private int battleBlock = 0;


    public Character(String name, int numDice){
        this.name = name;
        dice = new Dice[numDice];
        spellbook = new ArrayList<Glyph>();
    }

    public int getBattleBlock(){
        return battleBlock;
    }

    public void setBattleBlock(int setTo){
        battleBlock = setTo;
    }

}
