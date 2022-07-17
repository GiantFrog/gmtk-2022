package science.skywhale.bloodmortgage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.github.tommyettinger.textra.Font;
import com.github.tommyettinger.textra.TypingLabel;

import static science.skywhale.bloodmortgage.GameScreen.TILESIZE;

public class HUD
{
	OrthographicCamera camera;
	FitViewport hudView;
	Character chaeri;
	Stage stage;
	SpriteBatch batch;
	TypingLabel chaeriDialog;
	String tooltip;
	
	Texture d6Texture;
	TextureRegion one, two, three, four, five, six;
	
	public HUD (OrthographicCamera camera)
	{
		this.camera = camera;
		hudView = new FitViewport((float) Gdx.graphics.getWidth() / TILESIZE,
						(float)Gdx.graphics.getHeight() / TILESIZE, camera);
		batch = new SpriteBatch();
		stage = new Stage(hudView);
		tooltip = "Press R to {SHAKE}roll!";
		chaeriDialog = new TypingLabel(tooltip, new Font("fairies-32.fnt"));
		chaeri = new Character("Chaeri", 2, new Texture("chaeri.png"), 1000);
		chaeri.x = 580;
		chaeri.y = 0;
		
		//dice textures
		d6Texture = new Texture(Gdx.files.internal("basic dice.png"));
		one = new TextureRegion(d6Texture, 0, 128, 128, 128);
		two = new TextureRegion(d6Texture, 128, 128, 128, 128);
		three = new TextureRegion(d6Texture, 128, 256, 128, 128);
		four = new TextureRegion(d6Texture, 128, 0, 128, 128);
		five = new TextureRegion(d6Texture, 256, 128, 128, 128);
		six = new TextureRegion(d6Texture, 384, 128, 128, 128);
	}
	
	public void render (float delta)
	{
		stage.act(delta);
		batch.begin();
		batch.draw(two, 40, 40);
		chaeri.render(delta, batch, 1);
		//stage.draw();
		batch.end();
	}
	
	public void updateView (int width, int height)
	{
		hudView.update(width, height);
	}
}
