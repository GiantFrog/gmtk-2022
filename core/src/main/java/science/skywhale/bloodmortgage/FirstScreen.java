package science.skywhale.bloodmortgage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
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
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;

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
	
	Character testCharacter;
	
	public FirstScreen()
	{
		batch = new SpriteBatch();
		map = new TmxMapLoader().load("empty-map.tmx");
		mapRenderer = new OrthogonalTiledMapRenderer(map, (float)1 / TILESIZE);
		camera = new OrthographicCamera();
		viewport = new ExtendViewport(10, 10, camera);
		camera.setToOrtho(false, 8, 8);
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
		
		//camera movement
		camera.position.x = testCharacter.x;
		camera.position.y = testCharacter.y;
		
		
		//smoothly scroll to the target level of zoom
		if (leftToZoom <= -.005 || leftToZoom >= .005)
		{
			//zoom the camera by the amount we need to multiplied by the time passed and the zoom speed, both are <1
			camera.zoom += 10 * leftToZoom * delta;
			leftToZoom -= 10 * leftToZoom * delta;
		}
		camera.update();
		mapRenderer.setView(camera);
		
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