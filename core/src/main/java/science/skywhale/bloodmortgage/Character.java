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
	float x = 0, y = 0;
	boolean movingLeft = false;
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
    }

    public int getBattleBlock(){
        return battleBlock;
    }

    public void setBattleBlock(int setTo){
        battleBlock = setTo;
    }

	public Texture getTexture() {
		return texture;
	}
	
	
	public void render (SpriteBatch batch) {
		batch.draw(texture, x, y, (float)texture.getWidth()/FirstScreen.TILESIZE, (float)texture.getHeight()/FirstScreen.TILESIZE, 0, 0, 64, 64, movingLeft, false);
	}
}
