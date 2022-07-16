package science.skywhale.bloodmortgage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector3;

public class MouseKeyboardInput implements InputProcessor
{
	private FirstScreen level;
	private Vector3 curr, lastTouched, delta;
	
	public MouseKeyboardInput(FirstScreen level)
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
			case Input.Keys.W, Input.Keys.UP -> level.movingUp = true;
			case Input.Keys.A, Input.Keys.LEFT -> level.movingLeft = true;
			case Input.Keys.S, Input.Keys.DOWN -> level.movingDown = true;
			case Input.Keys.D, Input.Keys.RIGHT -> level.movingRight = true;
			
			//modify cameraSpeed when shift is pressed
			case Input.Keys.SHIFT_LEFT, Input.Keys.SHIFT_RIGHT -> level.sprint = true;
		}
		return false;
	}
	
	@Override
	public boolean keyUp(int keycode)
	{
		switch (keycode)
		{
			case Input.Keys.W, Input.Keys.UP -> level.movingUp = false;
			case Input.Keys.A, Input.Keys.LEFT -> level.movingLeft = false;
			case Input.Keys.S, Input.Keys.DOWN -> level.movingDown = false;
			case Input.Keys.D, Input.Keys.RIGHT -> level.movingRight = false;
			
			case Input.Keys.SHIFT_LEFT, Input.Keys.SHIFT_RIGHT -> level.sprint = false;
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
