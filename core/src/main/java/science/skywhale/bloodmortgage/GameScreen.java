package science.skywhale.bloodmortgage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import java.util.ArrayList;

/**
 * First screen of the application. Displayed after the application is created.
 */
public class GameScreen implements Screen
{
	static final int TILESIZE = 64;
	
	BloodMortgage game;
	OrthographicCamera camera;
	ExtendViewport viewport;
	private MouseKeyboardInput mouseKeyboardInput;
	private OrthogonalTiledMapRenderer mapRenderer;
	private TiledMap map;
	SpriteBatch batch;
	double leftToZoom = 0;
	
	HUD hud;
	Character kal, testCharacter2;
	Music intro, vibing, battlemusic, currentSong;
	
	Battle battle;
	ArrayList<Character> onMap = new ArrayList<Character>();
	
	public GameScreen(BloodMortgage game)
	{
		this.game = game;
		batch = new SpriteBatch();
		map = new TmxMapLoader().load("map-1.tmx");
		mapRenderer = new OrthogonalTiledMapRenderer(map, (float)1 / TILESIZE);
		camera = new OrthographicCamera();
		viewport = new ExtendViewport(10, 10, camera);
		camera.setToOrtho(false, 8, 8);
		camera.zoom = 0.7f;
		mapRenderer.setView(camera);
		
		mouseKeyboardInput = new MouseKeyboardInput(this);
		
		Texture[] kalTextureArray = {new Texture(Gdx.files.internal("Kal.png")), new Texture(Gdx.files.internal("Kal down walk.png"))};
		kal = new Character("Kal", 1, new Animation<Texture>(0.24f, kalTextureArray), 20);
		kal.x = kal.homeX = 3.6f;
		kal.y = kal.homeY = 15.2f;
		kal.setDie(6);
		// TESTING TESTY THIBNGS
		testCharacter2 = new Character("Ennis", 1, new Animation<Texture>(0.24f, kalTextureArray), 20);
		testCharacter2.x = 9;
		testCharacter2.y = 9;
		testCharacter2.setDie(6);
		onMap.add(testCharacter2);
		
		
		hud = new HUD(camera, this);
		
		//audio setup
		intro = Gdx.audio.newMusic(Gdx.files.internal("thewandererstheme.wav"));
		intro.setVolume(0.8f);
		intro.setLooping(true);
		vibing = Gdx.audio.newMusic(Gdx.files.internal("vibing.wav"));
		vibing.setVolume(0.5f);
		vibing.setLooping(true);
		battlemusic = Gdx.audio.newMusic(Gdx.files.internal("battle.wav"));
		battlemusic.setVolume(0.5f);
		battlemusic.setLooping(true);
		
		intro.play();
		currentSong = intro;
	}
	
	@Override
	public void show()
	{
		// Prepare your screen here.
		Gdx.input.setInputProcessor(mouseKeyboardInput);
	}
	
	@Override
	public void render(float delta)
	{
		//camera movement
		camera.position.x = kal.x + 0.5f;
		camera.position.y = kal.y + 0.5f;
		
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
		kal.render(delta, batch, TILESIZE);
		for (int i = 0; i< onMap.size(); i++){
			onMap.get(i).render(delta, batch, TILESIZE);
		}
		batch.end();
		
		//render overlay & HUD
		hud.render(delta);
		
		// test distances
		if (! kal.inBattle()){
			for (int i=0; i <onMap.size(); i++){
				testToBattle(onMap.get(i));
			}
		}
	}
	
	
	
	private void testToBattle(Character compare){
		double xDif = Math.abs(kal.x - compare.x);
		double yDif = Math.abs(kal.y - compare.y);
		double dist = Math.sqrt(xDif*xDif + yDif*yDif);
		if (dist < 1){
			System.out.println("Battle mode engaged");
			// TODO: Put log on screen here
			kal.vertiSpeed = kal.horiSpeed = 0;
			battle = new Battle(kal, compare, onMap, this);
			hud.initBattleScreen();
			currentSong.stop();
			battlemusic.play();
		}
	}
	
	@Override
	public void resize(int width, int height)
	{
		// Resize your screen here. The parameters represent the new window size.
		viewport.update(width, height);
		hud.updateView(width, height);
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