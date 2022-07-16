package science.skywhale.bloodmortgage.masterspellbook;

import science.skywhale.bloodmortgage.Character;
import science.skywhale.bloodmortgage.Dice;

public abstract class Glyph {

    // these are set within each glyph
    // TODO: Image
    protected int weightMod = 0;
    protected String[] types = new String[]{"Common", "Uncommon", "Rare", "Legendary"};
    protected int glyphType;
    protected String name;
    protected String description;
    protected Character owner;
    protected Dice dice;
    protected int diceSide = 0; // 0 means no side



    // returns the number of damage points done
    public abstract int useGlyph();

    // set methods
    public String getName(){
        return name;
    }

    public void addToDice(Dice dice, int side){
        this.dice = dice;
        this.diceSide = side;
    }

    // TODO: public void removeGlyph(){}
    public void setWeightMod(int newMod){
        weightMod = newMod;
    }

    public int getWeightMod(){
        return weightMod;
    }

}
