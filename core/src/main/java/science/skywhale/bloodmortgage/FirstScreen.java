package science.skywhale.bloodmortgage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

/**
 * First screen of the application. Displayed after the application is created.
 */
public class FirstScreen implements Screen
{
	public static final int TILESIZE = 64;
	
	OrthographicCamera camera;
	ExtendViewport viewport;
	private MouseKeyboardInput mouseKeyboardInput;
	private OrthogonalTiledMapRenderer mapRenderer;
	private TiledMap map;
	private SpriteBatch batch;
	double leftToZoom = 0;
	boolean sprint = false;
	float horiSpeed = 0, vertiSpeed = 0;
	
	private Character testCharacter;
	
	public FirstScreen()
	{
		batch = new SpriteBatch();
		map = new TmxMapLoader().load("empty-map.tmx");
		mapRenderer = new OrthogonalTiledMapRenderer(map, (float)1 / TILESIZE);
		camera = new OrthographicCamera();
		viewport = new ExtendViewport(8, 8, 50, 50, camera);
		camera.setToOrtho(false, 40, 22.5f);
		mapRenderer.setView(camera);
		
		mouseKeyboardInput = new MouseKeyboardInput(this);
		Gdx.input.setInputProcessor(mouseKeyboardInput);
		
		batch = new SpriteBatch();
		testCharacter = new Character("Kal", 1, new Texture("Kal.png"));
	}
	
	@Override
	public void show()
	{
		// Prepare your screen here.
	}
	
	@Override
	public void render(float delta)
	{
		//update the player position
		//TODO multiple delta by a speed if sprint, make it faster
		if (sprint)
		{
			testCharacter.x += delta*horiSpeed*1.75f;
			testCharacter.y += delta*vertiSpeed*1.75f;
		}
		else
		{
			testCharacter.x += delta*horiSpeed;
			testCharacter.y += delta*vertiSpeed;
		}
		
		
		camera.update();
		
		//clear the last frame
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		//render world
		batch.begin();
		mapRenderer.render();
		testCharacter.render(batch);
		batch.end();
	}
	
	@Override
	public void resize(int width, int height)
	{
		// Resize your screen here. The parameters represent the new window size.
		viewport.update(width, height);
	}
	
	@Override
	public void pause()
	{
		// Invoked when your application is paused.
	}
	
	@Override
	public void resume()
	{
		// Invoked when your application is resumed after pause.
	}
	
	@Override
	public void hide()
	{
		// This method is called when another screen replaces this one.
	}
	
	@Override
	public void dispose()
	{
		// Destroy screen's assets here.
	}
}