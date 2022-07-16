package science.skywhale.bloodmortgage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector3;

public class MouseKeyboardInput implements InputProcessor
{
	private GameScreen level;
	private Vector3 curr, lastTouched, delta;
	
	public MouseKeyboardInput(GameScreen level)
	{
		this.level = level;
		curr = new Vector3();
		//lastTouched = new Vector3(- 1, - 1, - 1);
		delta = new Vector3();
	}
	
	@Override
	public boolean keyDown(int keycode)
	{
		switch (keycode)
		{
			//move camera around the map
			case Input.Keys.W:
			case Input.Keys.UP:
				level.testCharacter.vertiSpeed = 3;
				break;
			case Input.Keys.A:
			case Input.Keys.LEFT:
				level.testCharacter.horiSpeed = -3;
				level.testCharacter.movingLeft = true;
				break;
			case Input.Keys.S:
			case Input.Keys.DOWN:
				level.testCharacter.vertiSpeed = -3;
				break;
			case Input.Keys.D:
			case Input.Keys.RIGHT:
				level.testCharacter.horiSpeed = 3;
				level.testCharacter.movingLeft = false;
				break;
			
			//modify cameraSpeed when shift is pressed
			case Input.Keys.SHIFT_LEFT:
			case Input.Keys.SHIFT_RIGHT:
				level.testCharacter.sprinting = true;
				break;
		}
		return false;
	}
	
	@Override
	public boolean keyUp(int keycode)
	{
		if (!Gdx.input.isKeyPressed(Input.Keys.W) && !Gdx.input.isKeyPressed(Input.Keys.UP) &&
			!Gdx.input.isKeyPressed(Input.Keys.S) && !Gdx.input.isKeyPressed(Input.Keys.DOWN))
			level.testCharacter.vertiSpeed = 0;
		if (!Gdx.input.isKeyPressed(Input.Keys.A) && !Gdx.input.isKeyPressed(Input.Keys.LEFT) &&
			!Gdx.input.isKeyPressed(Input.Keys.D) && !Gdx.input.isKeyPressed(Input.Keys.RIGHT))
			level.testCharacter.horiSpeed = 0;
		
		switch (keycode)
		{
			case Input.Keys.SHIFT_LEFT:
			case Input.Keys.SHIFT_RIGHT:
				level.testCharacter.sprinting = false;
		}
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
		//if (button == Buttons.RIGHT) //this gets right clicks
		
		/*
		//make a vector and translate its coordinates from screen pixels into map tiles
		Vector3 touchVector = new Vector3(screenX, screenY, 0);
		level.camera.unproject(touchVector);
		
		//if we tap the character, select them!
		if ((int)touchVector.x == level.character.getX() && (int)touchVector.y == level.character.getY())
			level.setSelected(level.character);
		//if we tap nothing, but do it on the map and something is selected, move that something there!
		else if (inBounds(touchVector))
			level.tryMove((int) touchVector.x, (int) touchVector.y);
		*/
		
		return false;
	}
	
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button)
	{
		
		//lastTouched.set(- 1, - 1, - 1);
		return false;
	}
	
	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer)
	{
		/*
		level.camera.unproject(curr.set(screenX, screenY, 0));
		if (! (lastTouched.x == - 1 && lastTouched.y == - 1 && lastTouched.z == - 1))
		{
			level.camera.unproject(delta.set(lastTouched.x, lastTouched.y, 0));
			delta.sub(curr);
			level.camera.position.add(delta.x, delta.y, 0);
		}
		lastTouched.set(screenX, screenY, 0);
		*/
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
		//.1 or .3 will be the "power" of a single scroll tick's zoom
		if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT))
			level.leftToZoom += .3 * amountY;
		else level.leftToZoom += .1 * amountY;
		//make sure we can't zoom too far in, especially to 0.
		if (level.camera.zoom + level.leftToZoom < 0.1)
			level.leftToZoom = 0.1 - level.camera.zoom;
		return false;
	}
	
	/*
	private boolean inBounds(Vector3 vector)
	{
		return vector.x >= 0 && vector.y >= 0 && vector.x < level.getMapProperties().get("width", Integer.class)
			   && vector.y < level.getMapProperties().get("height", Integer.class);
	}
	*/
}
