package science.skywhale.bloodmortgage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.github.tommyettinger.textra.Font;
import com.github.tommyettinger.textra.TypingLabel;

/**
 * First screen of the application. Displayed after the application is created.
 */
public class GameScreen implements Screen
{
	private static final int TILESIZE = 64;
	
	OrthographicCamera camera;
	ExtendViewport viewport;
	FitViewport hudView;
	private MouseKeyboardInput mouseKeyboardInput;
	private OrthogonalTiledMapRenderer mapRenderer;
	private TiledMap map;
	private SpriteBatch batch, hudBatch;
	double leftToZoom = 0;
	
	Stage stage;
	Table bigTable;
	
	Character testCharacter, chaeri;
	TypingLabel chaeriDialog;
	String tooltip;
	
	Texture d6Texture;
	TextureRegion one, two, three, four, five, six;
	
	Music intro, vibing;
	
	public GameScreen()
	{
		batch = new SpriteBatch();
		hudBatch = new SpriteBatch();
		map = new TmxMapLoader().load("empty-map.tmx");
		mapRenderer = new OrthogonalTiledMapRenderer(map, (float)1 / TILESIZE);
		camera = new OrthographicCamera();
		viewport = new ExtendViewport(10, 10, camera);
		hudView = new FitViewport((float)Gdx.graphics.getWidth()/TILESIZE, (float)Gdx.graphics.getHeight()/TILESIZE, camera);
		camera.setToOrtho(false, 8, 8);
		camera.zoom = 0.7f;
		mapRenderer.setView(camera);
		
		mouseKeyboardInput = new MouseKeyboardInput(this);
		Gdx.input.setInputProcessor(mouseKeyboardInput);
		
		stage = new Stage(hudView);
		bigTable = new Table();
		bigTable.setFillParent(true);
		stage.addActor(bigTable);
		tooltip = "Press R to {SHAKE}roll!";
		chaeriDialog = new TypingLabel(tooltip, new Font("fairies-32.fnt"));
		bigTable.add(chaeriDialog);
		
		testCharacter = new Character("Kal", 1, new Texture("Kal.png"));
		testCharacter.x = 6;
		testCharacter.y = 7;
		chaeri = new Character("Chaeri", 2, new Texture("chaeri.png"));
		chaeri.x = (float)Gdx.graphics.getWidth()/TILESIZE + 100;
		chaeri.y = (float)Gdx.graphics.getHeight()/TILESIZE;
		
		//dice textures
		d6Texture = new Texture(Gdx.files.internal("basic dice.png"));
		one = new TextureRegion(d6Texture, 0, 128, 128, 128);
		two = new TextureRegion(d6Texture, 128, 128, 128, 128);
		three = new TextureRegion(d6Texture, 128, 256, 128, 128);
		four = new TextureRegion(d6Texture, 128, 0, 128, 128);
		five = new TextureRegion(d6Texture, 256, 128, 128, 128);
		six = new TextureRegion(d6Texture, 384, 128, 128, 128);
		
		//audio setup
		//intro = Gdx.audio.newMusic(Gdx.files.internal("intro.mp3"));
		//intro.setVolume(0.8f);
		vibing = Gdx.audio.newMusic(Gdx.files.internal("vibing.wav"));
		vibing.setVolume(0.5f);
		vibing.setLooping(true);
		
		vibing.play();
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
		camera.position.x = testCharacter.x + 0.5f;
		camera.position.y = testCharacter.y + 0.5f;
		
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
		stage.act(delta);
		hudBatch.begin();
		hudBatch.draw(two, 40, 40);
		chaeri.render(delta, hudBatch, 1);
		stage.draw();
		hudBatch.end();
	}
	
	@Override
	public void resize(int width, int height)
	{
		// Resize your screen here. The parameters represent the new window size.
		viewport.update(width, height);
		hudView.update(width, height);
		chaeri.x = 560;
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