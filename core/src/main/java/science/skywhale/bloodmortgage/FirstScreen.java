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
	public final int TILESIZE = 64;
	
	OrthographicCamera camera;
	ExtendViewport viewport;
	private MouseKeyboardInput mouseKeyboardInput;
	private TouchInput touchInput;
	private InputMultiplexer inputMultiplexer;
	private OrthogonalTiledMapRenderer mapRenderer;
	private TiledMap map;
	private SpriteBatch batch;
	double leftToZoom = 0;
	boolean sprint, movingUp, movingDown, movingLeft, movingRight;
	
	private Texture testTexture;
	
	public FirstScreen()
	{
		sprint = movingUp = movingDown = movingLeft = movingRight = false;
		
		batch = new SpriteBatch();
		map = new TmxMapLoader().load("empty-map.tmx");
		mapRenderer = new OrthogonalTiledMapRenderer(map, (float)1 / TILESIZE);
		camera = new OrthographicCamera();
		viewport = new ExtendViewport(8, 8, 50, 50, camera);
		camera.setToOrtho(false, 40, 22.5f);
		mapRenderer.setView(camera);
		
		mouseKeyboardInput = new MouseKeyboardInput(this);
		touchInput = new TouchInput(this);
		inputMultiplexer = new InputMultiplexer();
		inputMultiplexer.addProcessor(new GestureDetector(touchInput));
		inputMultiplexer.addProcessor(mouseKeyboardInput);
		Gdx.input.setInputProcessor(inputMultiplexer);
		
		batch = new SpriteBatch();
		testTexture = new Texture(Gdx.files.internal("Kal.png"));
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
		
		camera.update();
		
		//clear the last frame
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		//render world
		batch.begin();
		mapRenderer.render();
		batch.draw(testTexture, 1, 1, (float)testTexture.getWidth()/TILESIZE, (float)testTexture.getHeight()/TILESIZE);
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