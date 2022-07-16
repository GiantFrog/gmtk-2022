package science.skywhale.bloodmortgage;

import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;

public class TouchInput implements GestureDetector.GestureListener
{
	private FirstScreen level;
	private float previousDistance;
	
	public TouchInput(FirstScreen level)
	{
		this.level = level;
		previousDistance = Float.NaN;
	}
	
	@Override
	public boolean touchDown(float x, float y, int pointer, int button)
	{
		//handle anything that has two fingers!
		return (pointer == 1);
	}
	
	@Override
	public boolean tap(float x, float y, int count, int button)
	{
		return false;
	}
	
	@Override
	public boolean longPress(float x, float y)
	{
		return false;
	}
	
	@Override
	public boolean fling(float velocityX, float velocityY, int button)
	{
		return false;
	}
	
	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY)
	{
		return false;
	}
	
	@Override
	public boolean panStop(float x, float y, int pointer, int button)
	{
		return false;
	}
	
	@Override
	public boolean zoom(float initialDistance, float distance)
	{
		//first time?
		if (Float.isNaN(previousDistance))
		{
			level.leftToZoom += 1 - distance / initialDistance;
			previousDistance = distance;
		}
		//without checking for the previous distance, a quick pinch scrolls infinitely until released.
		else
		{
			level.leftToZoom += 1 - distance / previousDistance;
			previousDistance = distance;
		}
		//make sure we can't zoom too far in, especially to 0.
		if (level.camera.zoom + level.leftToZoom < 0.1)
			level.leftToZoom = 0.1 - level.camera.zoom;
		return true;    //we handled the input, so don't keep passing it to other processors
	}
	
	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2)
	{
		return false;
	}
	
	@Override
	public void pinchStop()
	{
		previousDistance = Float.NaN;
	}
}
