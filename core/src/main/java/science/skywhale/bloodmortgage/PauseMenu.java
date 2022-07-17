package science.skywhale.bloodmortgage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class PauseMenu implements Screen
{
	GameScreen previousScreen;
	PauseMenuInput input;
	SpriteBatch batch;
	Texture dice;
	
	public PauseMenu (GameScreen previousScreen)
	{
		this.previousScreen = previousScreen;
		input = new PauseMenuInput(this);
		Gdx.input.setInputProcessor(input);
		batch = previousScreen.batch;
		dice = previousScreen.hud.d6Texture;
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
