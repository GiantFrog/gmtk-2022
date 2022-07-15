package science.skywhale.bloodmortgage;

import science.skywhale.bloodmortgage.masterspellbook.Glyph;

import java.util.ArrayList;

public class Character {
    private String name;
    private Dice[] dice;
    private ArrayList<Glyph> spellbook;

    public Character(String name, int numDice){
        this.name = name;
        dice = new Dice[numDice];
        spellbook = new ArrayList<Glyph>();
    }
}
