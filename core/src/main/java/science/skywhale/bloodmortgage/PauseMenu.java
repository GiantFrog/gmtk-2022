package science.skywhale.bloodmortgage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.github.tommyettinger.textra.TypingLabel;
import science.skywhale.bloodmortgage.masterspellbook.Glyph;

import java.util.ArrayList;

public class PauseMenu implements Screen
{
	GameScreen previousScreen;
	PauseMenuInput input;
	SpriteBatch batch;
	Texture dice;
	TextureRegion[] diceSides;
	Texture background;
	
	Stage stage;
	Table table;
	Table sideSelect, glyphSelect, space, displayGlyphInfo;
	int editingSide = 1;
	ArrayList<Glyph> spellbook;
	Character kal;
	int[] glyphX, glyphY;
	
	Skin skinn = new Skin(Gdx.files.internal("MyTracer/myTracer.json"));
	Skin skin = new Skin(Gdx.files.internal("tracer/tracer-ui.json"));
	public PauseMenu (GameScreen previousScreen)
	{
		this.previousScreen = previousScreen;
		input = new PauseMenuInput(this);
		Gdx.input.setInputProcessor(input);
		batch = previousScreen.batch;
		background = new Texture("Menu.png");
		
		dice = Dice.blueD6Texture;
		diceSides = Dice.blueSides;
		
		spellbook = previousScreen.kal.getSpellbook();
		glyphX = new int[]{256, 384, 384, 384, 640, 512};
		glyphY = new int[]{256, 256, 384, 128, 256, 256};
		kal = previousScreen.kal;
		// make screen button things
		stage = new Stage();
		space = new Table();
		space.add(new Label("              ", skin, "menu"));
		table = new Table();
		table.left();
		//table.padLeft(Gdx.graphics.getWidth()/5);
		table.top();
		table.padTop(Gdx.graphics.getHeight()/10);
		table.setFillParent(true);
		sideSelect = new Table();
		sideSelect.padRight(Gdx.graphics.getWidth()/4);
		sideSelect.padLeft(Gdx.graphics.getWidth()/5);
		sideSelect.padTop(10);
		sideSelect.setDebug(true);
		table.add(sideSelect);
		table.row();
		displayGlyphInfo = new Table();
		table.add(displayGlyphInfo);
		//table.add(space);
		glyphSelect = new Table();
		glyphSelect.setDebug(true);
		glyphSelect.left();
		table.add(glyphSelect);
		stage.addActor(table);
		
		setSideSelected(1);
	}
	
	public void changeDiceSide(int index){
		if (index < spellbook.size()) {
			kal.addGlyphToDice(index, editingSide);
			listGlyphs();
		}
	}
	
	public void updateGlyphInfo(int keycode){
		// get index a = 29
		int index = keycode - 29;
		if (index < spellbook.size()){
			Glyph sel = spellbook.get(index);
			displayGlyphInfo.add(new Label(sel.getName(), skin, "menu"));
			displayGlyphInfo.row();
			displayGlyphInfo.add(new Label(sel.getFlavor(), skin, "menu"));
			displayGlyphInfo.row();
			displayGlyphInfo.add(new Label(sel.getDescription(), skin, "menu"));
		}
	}
	
	public void setSideSelected(int side){
		editingSide = side;
		sideSelect.clearChildren(false);
		sideSelect.add(new TypingLabel(side + " selected", skin, "menu"));
		listGlyphs();
	}
	
	public void listGlyphs(){
		glyphSelect.clearChildren(false);
		spellbook = previousScreen.kal.getSpellbook();
		String alpha = "abcdefghijklmnopqrstuvwxyz";
		String toRender = "Backspace Clear ruin\n";
		for (int i=0; i < spellbook.size(); i++){
			toRender += alpha.charAt(i) + " " + spellbook.get(i).getName() + "\n";
		}
		glyphSelect.add(new Label(toRender, skin, "menu"));
	}
	
	@Override
	public void show()
	{
	
	}
	
	@Override
	public void render(float delta)
	{
		//clear the last frame
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		batch.draw(background, 0, 0,960,704);
		batch.draw(dice, 256, 128);
		renderGlyphs();
		batch.end();
		
		stage.act(delta);
		stage.draw();
		
		
	}
	
	public void renderGlyphs(){
		// get kal's die
		Dice kalDie = kal.getDie();
		
		// overlay glyph on image
		for (int i=0; i < 6; i++){
			Glyph glySide = kalDie.getSide(i+1);
			try {
				batch.draw(new Texture(glySide.getImgPath()), glyphX[i], glyphY[i]);
			} catch (NullPointerException e){
			
			}
		}
	}
	
	@Override
	public void resize(int width, int height)
	{
	
	}
	
	@Override
	public void pause()
	{
	
	}
	
	@Override
	public void resume()
	{
	
	}
	
	@Override
	public void hide()
	{
	
	}
	
	@Override
	public void dispose()
	{
	
	}
}
