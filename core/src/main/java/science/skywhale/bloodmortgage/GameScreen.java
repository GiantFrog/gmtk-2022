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
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
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
	TiledMapTileLayer mapLayer;
	SpriteBatch batch;
	double leftToZoom = 0;
	
	HUD hud;
	Character kal, testCharacter2, scrungle, hut, athdranax, rand, birch, vampcat, matty, scraggy, scrumpus, chaeriNPC;
	Music intro, vibing, battlemusic, tophat_guy_anthem, currentSong, enemyTheme;
	
	Battle battle;
	ArrayList<Character> onMap = new ArrayList<Character>();
	
	public GameScreen(BloodMortgage game)
	{
		this.game = game;
		batch = new SpriteBatch();
		map = new TmxMapLoader().load("map-1.tmx");
		mapLayer = (TiledMapTileLayer)map.getLayers().get(0);
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
		//testCharacter2 = new Character("Ennis", 1, new Animation<Texture>(0.24f, kalTextureArray), 20);
		//testCharacter2.x = 9;
		//testCharacter2.y = 9;
		//testCharacter2.setDie(6);
		//onMap.add(testCharacter2);
		Texture scrungleTexture = new Texture(Gdx.files.internal("Generic Demon.png"));
		scrungle = new Character("Scrungle",1,scrungleTexture,30);
		scrungle.x = 12;
		scrungle.y = 12;
		scrungle.setDie(6);
		scrungle.addGlyphToDice(17,5);
		scrungle.addGlyphToDice(13,6);
		scrungle.addGlyphToDice(6,2);
		scrungle.addGlyphToDice(5,4);
		scrungle.addGlyphToDice(4,1);
		scrungle.addGlyphToDice(1,3);
		onMap.add(scrungle);
		
		Texture[] hutTextureArray = {new Texture(Gdx.files.internal("baba yaga house.png")), new Texture(Gdx.files.internal("baba yaga house down.png"))};
		hut = new Character("the Hut of Baba Yaga", 1, new Animation<Texture>(0.24f, hutTextureArray),60);
		hut.x = 16;
		hut.y = 3;
		hut.movingLeft = true;
		hut.setDie(6);
		hut.addGlyphToDice(21,3);
		hut.addGlyphToDice(20,6);
		hut.addGlyphToDice(17,2);
		hut.addGlyphToDice(15,1);
		hut.addGlyphToDice(5,5);
		hut.addGlyphToDice(1,4);
		onMap.add(hut);
		
		Texture vampcatTexture = new Texture("vampire cat.png");
		vampcat = new Character("Vampire Cat",1,vampcatTexture,45);
		vampcat.x = 17;
		vampcat.y = 15;
		vampcat.setDie(6);
		vampcat.addGlyphToDice(20,5);
		vampcat.addGlyphToDice(15,1);
		vampcat.addGlyphToDice(11,4);
		vampcat.addGlyphToDice(7,6);
		vampcat.addGlyphToDice(5,2);
		vampcat.addGlyphToDice(3,3);
		onMap.add(vampcat);
		
		Texture randTexture = new Texture("bob.png");
		rand = new Character("Rand the Rock",1,randTexture,2000);
		rand.x = 3;
		rand.y = 3;
		rand.setDie(6);
		onMap.add(rand);
		
		Texture[] tophatTextureArray = {new Texture(Gdx.files.internal("flipped Athdrananax.png")), new Texture(Gdx.files.internal("flipped Athdrananax down.png"))};
		athdranax = new Character("Athdranax",1,new Animation<Texture>(0.24f, tophatTextureArray),15);
		athdranax.x = 3;
		athdranax.y = 10;
		athdranax.setDie(6);
		athdranax.addGlyphToDice(21,3);
		athdranax.addGlyphToDice(9,4);
		athdranax.addGlyphToDice(4,5);
		athdranax.addGlyphToDice(2,6);
		athdranax.addGlyphToDice(1,2);
		athdranax.addGlyphToDice(0,1);
		onMap.add(athdranax);
		
		Texture mattyTexture = new Texture("Matty Mercy.png");
		matty = new Character("Matty Murky", 1,mattyTexture,100);
		matty.x = 10;
		matty.y = 16;
		matty.setDie(6);
		onMap.add(matty);
		
		Texture birchTexture = new Texture("MAGNIFICENT BIRCHt.png");
		birch = new Character("Magnificent Birch",1,birchTexture,200);
		birch.x = 6;
		birch.y = 7;
		birch.setDie(6);
		onMap.add(birch);
		
		Texture chaeriTexture = new Texture("chaeri.png");
		chaeriNPC = new Character("Chaeri_NPC",1,chaeriTexture,2);
		chaeriNPC.x = 4;
		chaeriNPC.y = 13;
		chaeriNPC.setDie(6);
		onMap.add(chaeriNPC);
		
		scraggy = new Character("Scraggy",1,scrungleTexture,30);
		scraggy.x = 10;
		scraggy.y = 6;
		scraggy.setDie(6);
		scraggy.addGlyphToDice(17,5);
		scraggy.addGlyphToDice(13,6);
		scraggy.addGlyphToDice(6,2);
		scraggy.addGlyphToDice(5,4);
		scraggy.addGlyphToDice(4,1);
		scraggy.addGlyphToDice(1,3);
		onMap.add(scraggy);
		
		scrumpus = new Character("Scraggy",1,scrungleTexture,30);
		scrumpus.x = 8;
		scrumpus.y = 16;
		scrumpus.setDie(6);
		scrumpus.addGlyphToDice(17,5);
		scrumpus.addGlyphToDice(13,6);
		scrumpus.addGlyphToDice(6,2);
		scrumpus.addGlyphToDice(5,4);
		scrumpus.addGlyphToDice(4,1);
		scrumpus.addGlyphToDice(1,3);
		onMap.add(scrumpus);
		
		
		
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
		tophat_guy_anthem = Gdx.audio.newMusic(Gdx.files.internal("tophat_guy_anthem.wav"));
		tophat_guy_anthem.setVolume(1.0f);
		tophat_guy_anthem.setLooping(true);
		
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
		kal.render(delta, batch, TILESIZE, mapLayer);
		for (int i = 0; i< onMap.size(); i++){
			onMap.get(i).render(delta, batch, TILESIZE, mapLayer);
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
			hud.battleOver = true;
			// TODO: Put log on screen here
			kal.vertiSpeed = kal.horiSpeed = 0;
			battle = new Battle(kal, compare, onMap, this);
			hud.initBattleScreen();
			switch (compare.getName())
			{
				case "Athdranax":
					enemyTheme = tophat_guy_anthem;
					break;
				default:
					enemyTheme = battlemusic;
			}
			currentSong.stop();
			enemyTheme.play();
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