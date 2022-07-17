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
			case Input.Keys.H:
				menu.changeDiceSide(7);
				break;
			case Input.Keys.I:
				menu.changeDiceSide(8);
				break;
			case Input.Keys.J:
				menu.changeDiceSide(9);
				break;
			case Input.Keys.K:
				menu.changeDiceSide(10);
				break;
			case Input.Keys.L:
				menu.changeDiceSide(11);
				break;
			case Input.Keys.M:
				menu.changeDiceSide(12);
				break;
			case Input.Keys.N:
				menu.changeDiceSide(13);
				break;
			case Input.Keys.O:
				menu.changeDiceSide(14);
				break;
			case Input.Keys.P:
				menu.changeDiceSide(15);
				break;
			case Input.Keys.Q:
				menu.changeDiceSide(16);
				break;
			case Input.Keys.R:
				menu.changeDiceSide(17);
				break;
			case Input.Keys.S:
				menu.changeDiceSide(18);
				break;
			case Input.Keys.T:
				menu.changeDiceSide(19);
				break;
			case Input.Keys.U:
				menu.changeDiceSide(20);
				break;
			case Input.Keys.V:
				menu.changeDiceSide(21);
				break;
			case Input.Keys.W:
				menu.changeDiceSide(22);
				break;
			case Input.Keys.X:
				menu.changeDiceSide(23);
				break;
			case Input.Keys.Y:
				menu.changeDiceSide(24);
				break;
			case Input.Keys.Z:
				menu.changeDiceSide(25);
				break;
			//TODO MAKE HOLDING SHIFT THEN PRESSING A LETTER GIVE THE DESCRIPTION
			case Input.Keys.SHIFT_LEFT:
			case Input.Keys.SHIFT_RIGHT:
				
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
