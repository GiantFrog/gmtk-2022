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
	float x = 0, y = 0;
	private Texture texture;

    public Character(String name, int numDice, Texture texture){
        this.name = name;
        dice = new Dice[numDice];
        spellbook = new ArrayList<Glyph>();
        this.initSpellbook();
		this.texture = texture;
    }

    private void initSpellbook(){
        spellbook.add(new C1(this));
		spellbook.add(new C2(this));
		spellbook.add(new C3(this));
		spellbook.add(new C4(this));
		spellbook.add(new C5(this));
    }

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
	
	
	public void render (SpriteBatch batch) {
		batch.draw(texture, x, y, (float)texture.getWidth()/FirstScreen.TILESIZE, (float)texture.getHeight()/FirstScreen.TILESIZE);
	}
}
