package science.skywhale.bloodmortgage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.github.tommyettinger.textra.TypingLabel;

import java.util.HashMap;

import static science.skywhale.bloodmortgage.GameScreen.TILESIZE;

public class HUD
{
	OrthographicCamera camera;
	FitViewport hudView;
	Character chaeri;
	Stage stage;
	SpriteBatch batch;
	String tooltip;
	Boolean battleOver;
	
	// dialog bools
	Boolean chaeriDialogUp;
	HashMap<String, Integer> dialogCounter;
	TypingLabel chaeriDialog;
	
	TextureRegion lastRoll, enemyRoll;
	Texture lastGlyph, enemyGlyph;
	
	Table battleTable, table, chaeriTable;
	Skin skin;
	GameScreen level;
	
	public HUD (OrthographicCamera camera, GameScreen level)
	{
		this.camera = camera;
		this.level = level;
		skin = new Skin(Gdx.files.internal("tracer/tracer-ui.json"));
		hudView = new FitViewport((float) Gdx.graphics.getWidth() / TILESIZE,
						(float)Gdx.graphics.getHeight() / TILESIZE, camera);
		batch = new SpriteBatch();
		battleOver = false;
		stage = new Stage(hudView);
		stage = new Stage();
		
		table = new Table();
		table.left();
		table.top();
		table.padTop(20);
		table.padLeft(20);
		table.setDebug(false); // This is optional, but enables debug lines for tables.
		table.setFillParent(true);
		battleTable = new Table();
		battleTable.padBottom(Gdx.graphics.getWidth()/5f);
		//battleTable.left();
		//battleTable.top();
		//battleTable.padTop(20);
		//battleTable.padLeft(20);
		//battleTable.setDebug(true); // This is optional, but enables debug lines for tables.
		//battleTable.setFillParent(true);
		
		
		table.add(battleTable);
		chaeriDialog = new TypingLabel("", skin);
		table.row();
		chaeriTable = new Table();
		chaeriTable.add(chaeriDialog);
		chaeriTable.padLeft(Gdx.graphics.getWidth()/5*2);
		chaeriTable.padTop(Gdx.graphics.getHeight()/3);
		table.add(chaeriTable);
		
		stage.addActor(table);
		chaeri = new Character("Chaeri", 2, new Texture("chaeri.png"), 1000);
		chaeri.x = 580;
		chaeri.y = 0;
		
		// character dialog controls
		chaeriDialogUp = false;
		dialogCounter = new HashMap<>();
		
		lastRoll = Dice.blueSides[0];
		enemyRoll = Dice.redSides[0];
	}
	
	public void updateBattleStage(String updates){
		battleTable.clearChildren(false); // TODO: want true or false?
		battleTable.add(new Label(updates, skin));
		//table.
	}
	public void initBattleScreen(){
		battleTable.clearChildren(false);
		tooltip = "[WHITE]{FADE}BATTLE TIME{ENDFADE}";
		battleTable.add(new TypingLabel(tooltip, skin));
		battleTable.row();
		
		tooltip = "[WHITE]Press R to {SHAKE}roll!";
		battleTable.add(new TypingLabel(tooltip, skin));
	}
	public void showChaeriTip()
	{
		// run everytime press c
		chaeriDialogUp = true;
		if (dialogCounter.getOrDefault("Chaeri", 0) >= Dialogs.chaeriDialogList.length){
			dialogCounter.put("Chaeri", 0);
		}
		String newDiag = Dialogs.addLineBreaks(Dialogs.chaeriDialogList[dialogCounter.getOrDefault("Chaeri", 0)],
											   40);
		chaeriDialog.setText(newDiag);
		// remove when player starts moving again
	}
	
	public void render (float delta)
	{
		/*if (level.kal.inBattle() || battleOver) {
			stage.act(delta);
			stage.draw();
		}*/
		if (!level.kal.inBattle() && !battleOver){
			battleTable.clearChildren();
		}
		
		stage.act(delta);
		stage.draw();
		
		batch.begin();
		batch.draw(lastRoll, 40, 40);
		if (lastGlyph != null)
			batch.draw(lastGlyph, 40, 40);
		batch.draw(enemyRoll, 792, 40);
		if (enemyGlyph != null)
			batch.draw(enemyGlyph, 792, 40);
		chaeri.render(delta, batch, .35f, null);
		batch.end();
	}
	
	public void updateView (int width, int height)
	{
		hudView.update(width, height);
	}
}
