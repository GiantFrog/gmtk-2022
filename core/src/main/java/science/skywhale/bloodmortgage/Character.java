package science.skywhale.bloodmortgage;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import science.skywhale.bloodmortgage.masterspellbook.*;

import java.util.ArrayList;

public class Character {
    private String name;
    private Dice[] dice;
    private ArrayList<Glyph> spellbook;
    private int battleBlock = 0;
	private int toHeal = 0;
	private int maxHealth;
	private Boolean inBattle = false;

	float x = 0, y = 0, horiSpeed = 0, vertiSpeed = 0, elapsedTime = 0;
	float homeX = 0, homeY = 0;
	boolean movingLeft = false, sprinting = false;
	private Texture texture;
	private Animation<Texture> animation;
	Character inRange;

 
	public Character(String name, int numDice, Animation<Texture> animation, int maxHealth){
		this.name = name;
		dice = new Dice[numDice];
		spellbook = new ArrayList<Glyph>();
		this.initSpellbook();
		this.animation = animation;
		this.texture = animation.getKeyFrame(0);
		this.maxHealth = maxHealth;
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
		//Base
        spellbook.add(new C1(this));
		spellbook.add(new C2(this));
		spellbook.add(new C3(this));
		spellbook.add(new C4(this));
		spellbook.add(new C5(this));
		spellbook.add(new C11(this));
		//Full List
		spellbook.add(new C6(this));
		spellbook.add(new C7(this));
		spellbook.add(new C8(this));
		spellbook.add(new C15(this));
		spellbook.add(new C16(this));
		spellbook.add(new C18(this));
		spellbook.add(new U1(this));
		spellbook.add(new U2(this));
		spellbook.add(new U4(this));
		spellbook.add(new U5(this));
		spellbook.add(new U6(this));
		spellbook.add(new U7(this));
		spellbook.add(new U11(this));
		spellbook.add(new R1(this));
		spellbook.add(new R7(this));
		spellbook.add(new R8(this));
		spellbook.add(new L1(this));
		spellbook.add(new L4(this));
    }
	public ArrayList<Glyph> getSpellbook(){
		return spellbook;
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
	
	public void removeGlyphToDice(int diceSide){
		removeGlyphToDice(diceSide, 0);
	}
	public void removeGlyphToDice(int diceSide, int diceNum){
		Glyph oldGlyph = dice[diceNum].clearSide(diceSide);
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
	@Override
	public String toString() {
		return name;
	}
	
	// battle specific tracked within character
	public int getMaxHealth(){
		return maxHealth;
	}
	public void addToMaxHealth(int add){
		maxHealth += add;
	}
	public void setInBattle(Boolean inBattle){
		this.inBattle = inBattle;
	}
	public Boolean inBattle(){
		return inBattle;
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
	
	
	public void render (float delta, SpriteBatch batch, float tilesize, TiledMapTileLayer mapLayer) {
		if (animation != null && (horiSpeed != 0 || vertiSpeed != 0))
		{
			elapsedTime += delta;
			texture = animation.getKeyFrame(elapsedTime, true);
		}
		
		//update the player position
		if (horiSpeed != 0 || vertiSpeed != 0)
		{
			float xChange = 0, yChange = 0;
			if (sprinting)
			{
				xChange = delta * horiSpeed * 1.75f;
				yChange = delta * vertiSpeed * 1.75f;
			}
			else
			{
				xChange = delta * horiSpeed;
				yChange = delta * vertiSpeed;
			}
			//look to see if we would rub against a tile marked as solid
			if (!mapLayer.getCell(Math.round(x + xChange), Math.round(y)).getTile().getProperties().get("solid", Boolean.class))
				x += xChange;
			if (!mapLayer.getCell(Math.round(x), Math.round(y + yChange)).getTile().getProperties().get("solid", Boolean.class))
				y += yChange;
		}
		
		batch.draw(texture, x, y, (float)texture.getWidth()/tilesize, (float)texture.getHeight()/tilesize, 0, 0, 64, 64, movingLeft, false);
	}
	
	public void addGlyphToDice()
	{
	}
}
