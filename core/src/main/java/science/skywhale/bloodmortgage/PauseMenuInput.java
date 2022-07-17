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
			case Input.Keys.NUM_1:
				menu.setSideSelected(1);
				break;
			case Input.Keys.NUM_2:
				menu.setSideSelected(2);
				break;
			case Input.Keys.NUM_3:
				menu.setSideSelected(3);
				break;
			case Input.Keys.NUM_4:
				menu.setSideSelected(4);
				break;
			case Input.Keys.NUM_5:
				menu.setSideSelected(5);
				break;
			case Input.Keys.NUM_6:
				menu.setSideSelected(6);
				break;
			case Input.Keys.A:
				menu.changeDiceSide(0);
				break;
			case Input.Keys.B:
				menu.changeDiceSide(1);
				break;
			case Input.Keys.C:
				menu.changeDiceSide(2);
				break;
			case Input.Keys.D:
				menu.changeDiceSide(3);
				break;
			case Input.Keys.E:
				menu.changeDiceSide(4);
				break;
			case Input.Keys.F:
				menu.changeDiceSide(5);
				break;
			case Input.Keys.G:
				menu.changeDiceSide(6);
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
