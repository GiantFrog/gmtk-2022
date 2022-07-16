package science.skywhale.bloodmortgage;

import com.badlogic.gdx.Game;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms.
 */
public class BloodMortgage extends Game
{
	@Override
	public void create()
	{
		setScreen(new GameScreen());
	}
	
	@Override
	public void dispose()
	{
		getScreen().dispose();
	}
}