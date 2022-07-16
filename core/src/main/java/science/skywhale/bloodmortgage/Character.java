package science.skywhale.bloodmortgage;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import science.skywhale.bloodmortgage.masterspellbook.*;

import java.util.ArrayList;

public class Character {
    private String name;
    private Dice[] dice;
    private ArrayList<Glyph> spellbook;
    private int battleBlock = 0;
	private int toHeal = 0;

	float x = 0, y = 0, horiSpeed = 0, vertiSpeed = 0;
	boolean movingLeft = false, sprinting = false;
	private Texture texture;

    public Character(String name, int numDice, Texture texture){
        this.name = name;
        dice = new Dice[numDice];
        spellbook = new ArrayList<Glyph>();
        this.initSpellbook();
		this.texture = texture;
    }
	
	//NOTE: FOR TESTING ONLY
	public Character(String name, int numDice){
		this.name = name;
		dice = new Dice[numDice];
		spellbook = new ArrayList<Glyph>();
		this.initSpellbook();
		//this.texture = texture;
	}

	// spellbook methods
    private void initSpellbook(){
        spellbook.add(new C1(this));
		spellbook.add(new C2(this));
		spellbook.add(new C3(this));
		spellbook.add(new C4(this));
		spellbook.add(new C5(this));
    }
	public void addGlyphToDice(int index, int diceSide){
		addGlyphToDice(index, diceSide, 0);
	}
	
	public void addGlyphToDice(int index, int diceSide, int diceNum){
		Glyph oldGlyph = dice[diceNum].setSide(spellbook.remove(index), diceSide);
		if (oldGlyph != null){
			spellbook.add(oldGlyph);
		}
	}
	
	// set Dice
	public void setDie(int numSides){
		setDie(numSides, 0);
	}
	
	public void setDie(int numSides, int diePosition){
		dice[diePosition] = new Dice(numSides);
	}
	
	// getter methods
	public Dice getDie(){
		return dice[0];
	}
	public String getName(){
		return name;
	}
	
	// battle specific methods for tracking things
    public int getBattleBlock(){
        return battleBlock;
    }
    public void setBattleBlock(int setTo){
        battleBlock = setTo;
    }
	public int getToHeal(){
		return toHeal;
	}
	public void setToHeal(int setTo){
		toHeal = setTo;
	}
	
	public Texture getTexture() {
		return texture;
	}
	
	
	public void render (float delta, SpriteBatch batch, int tilesize) {
		//update the player position
		if (sprinting)
		{
			x += delta*horiSpeed*1.75f;
			y += delta*vertiSpeed*1.75f;
		}
		else
		{
			x += delta*horiSpeed;
			y += delta*vertiSpeed;
		}
		
		batch.draw(texture, x, y, (float)texture.getWidth()/tilesize, (float)texture.getHeight()/tilesize, 0, 0, 64, 64, movingLeft, false);
	}
}
