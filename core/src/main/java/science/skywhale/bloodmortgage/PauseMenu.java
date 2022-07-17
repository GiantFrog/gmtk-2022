package science.skywhale.bloodmortgage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class PauseMenu implements Screen
{
	GameScreen previousScreen;
	PauseMenuInput input;
	SpriteBatch batch;
	Texture dice;
	TextureRegion[] diceSides;
	
	Stage stage;
	Table diceButtons;
	Button btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix;
	ClickListener clThree;
	
	public PauseMenu (GameScreen previousScreen)
	{
		this.previousScreen = previousScreen;
		input = new PauseMenuInput(this);
		Gdx.input.setInputProcessor(input);
		batch = previousScreen.batch;
		dice = previousScreen.hud.d6Texture;
		diceSides = previousScreen.hud.diceSides;
		
		// make screen button things
		stage = new Stage();
		diceButtons = new Table();
		diceButtons.setDebug(true);
		diceButtons.setFillParent(true);
		btnOne = new Button(previousScreen.hud.skin);
		btnTwo = new Button(previousScreen.hud.skin);
		btnThree = new Button(previousScreen.hud.skin, "home");
		btnFour = new Button(previousScreen.hud.skin);
		btnFive = new Button(previousScreen.hud.skin);
		btnSix = new Button(previousScreen.hud.skin);
		//previousScreen.hud.skin.
		clThree = new ClickListener();
		btnThree.addListener(clThree);
		makeDiceButtonTable();
		stage.addActor(diceButtons);
	}
	
	public void makeDiceButtonTable(){
		
		diceButtons.add();
		diceButtons.add(btnThree);
		diceButtons.add();
		diceButtons.add();
		diceButtons.row();
		diceButtons.add(btnOne);
		diceButtons.add(btnTwo);
		diceButtons.add(btnSix);
		diceButtons.add(btnFive);
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
		batch.draw(dice, 10, 10);
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
