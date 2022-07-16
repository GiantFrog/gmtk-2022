package science.skywhale.bloodmortgage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

/**
 * First screen of the application. Displayed after the application is created.
 */
public class GameScreen implements Screen
{
	private static final int TILESIZE = 64;
	
	OrthographicCamera camera;
	ExtendViewport viewport;
	private MouseKeyboardInput mouseKeyboardInput;
	private OrthogonalTiledMapRenderer mapRenderer;
	private TiledMap map;
	private SpriteBatch batch, hudBatch;
	double leftToZoom = 0;
	
	Character testCharacter, chaeri;
	
	Music intro, vibing;
	
	public GameScreen()
	{
		batch = new SpriteBatch();
		hudBatch = new SpriteBatch();
		map = new TmxMapLoader().load("empty-map.tmx");
		mapRenderer = new OrthogonalTiledMapRenderer(map, (float)1 / TILESIZE);
		camera = new OrthographicCamera();
		viewport = new ExtendViewport(10, 10, camera);
		camera.setToOrtho(false, 8, 8);
		mapRenderer.setView(camera);
		
		mouseKeyboardInput = new MouseKeyboardInput(this);
		Gdx.input.setInputProcessor(mouseKeyboardInput);
		
		testCharacter = new Character("Kal", 1, new Texture("Kal.png"));
		chaeri = new Character("Chaeri", 2, new Texture("chaeri.png"));
		chaeri.x = (float)Gdx.graphics.getWidth()/TILESIZE + 100;
		chaeri.y = (float)Gdx.graphics.getHeight()/TILESIZE;
		
		//audio setup
		/*
		intro = Gdx.audio.newMusic(Gdx.files.internal("intro.mp3"));
		intro.setVolume(0.8f);
		vibing = Gdx.audio.newMusic(Gdx.files.internal("vibing.mp3"));
		vibing.setVolume(0.5f);
		vibing.setLooping(true);
		
		intro.play();
		*/
	}
	
	@Override
	public void show()
	{
		// Prepare your screen here.
	}
	
	@Override
	public void render(float delta)
	{
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
		testCharacter.render(delta, batch, TILESIZE);
		batch.end();
		
		//render overlay & HUD
		//TODO fix aspect ratio of things rendered in this way (they have no viewport)
		hudBatch.begin();
		chaeri.render(delta, hudBatch, 1);
		hudBatch.end();
	}
	
	@Override
	public void resize(int width, int height)
	{
		// Resize your screen here. The parameters represent the new window size.
		viewport.update(width, height);
		chaeri.x = 5;
		chaeri.y = 5;
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