package science.skywhale.bloodmortgage;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import science.skywhale.bloodmortgage.masterspellbook.*;

import java.util.ArrayList;

public class Character {
    private String name;
    private Dice[] dice;
    private ArrayList<Glyph> spellbook;
    private int battleBlock = 0;
	private int toHeal = 0;
	private int maxHealth;

	float x = 0, y = 0, horiSpeed = 0, vertiSpeed = 0, elapsedTime = 0;
	boolean movingLeft = false, sprinting = false;
	private Texture texture;
	private Animation<Texture> animation;

    public Character(String name, int numDice, Texture texture){
        this.name = name;
        dice = new Dice[numDice];
        spellbook = new ArrayList<Glyph>();
        this.initSpellbook();
		this.texture = texture;
    }
	public Character(String name, int numDice, Animation<Texture> animation){
		this.name = name;
		dice = new Dice[numDice];
		spellbook = new ArrayList<Glyph>();
		this.initSpellbook();
		this.animation = animation;
		this.texture = animation.getKeyFrame(0);
	}
	// ADDED MAX HELATH - TODO: Integrate later!
	public Character(String name, int numDice, Texture texture, int maxHealth){
		this.name = name;
		dice = new Dice[numDice];
		spellbook = new ArrayList<Glyph>();
		this.initSpellbook();
		this.texture = texture;
		this.maxHealth = maxHealth;
	}
	//NOTE: FOR TESTING ONLY
	public Character(String name, int numDice, int maxHealth){
		this.name = name;
		dice = new Dice[numDice];
		spellbook = new ArrayList<Glyph>();
		this.initSpellbook();
		//this.texture = texture;
		this.maxHealth = maxHealth;
	}

	// spellbook methods
    private void initSpellbook(){
        spellbook.add(new C1(this));
		spellbook.add(new C2(this));
		spellbook.add(new C3(this));
		spellbook.add(new C4(this));
		spellbook.add(new C5(this));
		spellbook.add(new C11(this));
    }
	public void printSpellbook(){
		System.out.println("Spellbook");
		for (int i=0; i<spellbook.size(); i++){
			System.out.println(i + " " + spellbook.get(i).getName());
		}
		System.out.println();
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
	
	// battle specific tracked within character
	public int getMaxHealth(){
		return maxHealth;
	}
	public void addToMaxHealth(int add){
		maxHealth += add;
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
		if (animation != null && (horiSpeed != 0 || vertiSpeed != 0))
		{
			elapsedTime += delta;
			texture = animation.getKeyFrame(elapsedTime, true);
		}
		
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
