package science.skywhale.bloodmortgage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
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
	
	Stage stage;
	Table table;
	Table sideSelect, glyphSelect;
	int editingSide = 1;
	ArrayList<Glyph> spellbook;
	Character kal;
	Texture background;
	
	Skin skinn = new Skin(Gdx.files.internal("MyTracer/myTracer.json"));
	Skin skin = new Skin(Gdx.files.internal("tracer/tracer-ui.json"));
	public PauseMenu (GameScreen previousScreen)
	{
		this.previousScreen = previousScreen;
		input = new PauseMenuInput(this);
		Gdx.input.setInputProcessor(input);
		batch = previousScreen.batch;
		background = new Texture("Menu.png");
		
		dice = previousScreen.hud.d6Texture;
		diceSides = previousScreen.hud.diceSides;
		
		spellbook = previousScreen.kal.getSpellbook();
		kal = previousScreen.kal;
		// make screen button things
		stage = new Stage();
		table = new Table();
		table.left();
		table.top();
		table.setFillParent(true);
		sideSelect = new Table();
		sideSelect.padLeft(15);
		sideSelect.padTop(15);
		sideSelect.setDebug(true);
		table.add(sideSelect);
		glyphSelect = new Table();
		glyphSelect.setDebug(true);
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
	
	public void setSideSelected(int side){
		editingSide = side;
		sideSelect.clearChildren(false);
		sideSelect.add(new TypingLabel(side + " selected", skin));
		listGlyphs();
	}
	
	public void listGlyphs(){
		glyphSelect.clearChildren(false);
		spellbook = previousScreen.kal.getSpellbook();
		String alpha = "abcdefghijklmnopqrstuvwxyz";
		String toRender = "";
		for (int i=0; i < spellbook.size(); i++){
			toRender += alpha.charAt(i) + " " + spellbook.get(i).getName() + "\n";
		}
		glyphSelect.add(new TypingLabel(toRender, skin));
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
		batch.end();
		
		stage.act(delta);
		stage.draw();
		
		
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
