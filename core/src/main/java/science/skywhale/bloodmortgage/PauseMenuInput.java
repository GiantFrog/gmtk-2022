package science.skywhale.bloodmortgage;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class PauseMenuInput implements InputProcessor
{
	private PauseMenu menu;
	
	public PauseMenuInput (PauseMenu menu)
	{
		this.menu = menu;
	}
	
	@Override
	public boolean keyDown(int keycode)
	{
		switch (keycode)
		{
			case Input.Keys.ESCAPE:
				menu.previousScreen.game.setScreen(menu.previousScreen);
				break;
		}
		return false;
	}
	
	@Override
	public boolean keyUp(int keycode)
	{
		return false;
	}
	
	@Override
	public boolean keyTyped(char character)
	{
		return false;
	}
	
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button)
	{
		return false;
	}
	
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button)
	{
		return false;
	}
	
	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer)
	{
		return false;
	}
	
	@Override
	public boolean mouseMoved(int screenX, int screenY)
	{
		return false;
	}
	
	@Override
	public boolean scrolled(float amountX, float amountY)
	{
		return false;
	}
}
