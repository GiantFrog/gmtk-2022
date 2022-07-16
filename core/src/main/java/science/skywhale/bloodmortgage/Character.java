package science.skywhale.bloodmortgage;

import science.skywhale.bloodmortgage.masterspellbook.*;

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
        this.initSpellbook();
    }

    private void initSpellbook(){
        spellbook.add(new C1(this));
        spellbook.add(new C2(this));
    }

    public int getBattleBlock(){
        return battleBlock;
    }

    public void setBattleBlock(int setTo){
        battleBlock = setTo;
    }

}
