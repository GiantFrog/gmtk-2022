package science.skywhale.bloodmortgage.lwjgl3;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.Texture;
import science.skywhale.bloodmortgage.Battle;
import science.skywhale.bloodmortgage.BloodMortgage;
import science.skywhale.bloodmortgage.Character;

/** Launches the desktop (LWJGL3) application. */
public class Lwjgl3Launcher {
	public static void main(String[] args) {
		//System.out.println("Testing battle");
		//testBattle();
		createApplication();
	}
	
	public static void testBattle(){
		//Texture text = new Texture("Kal.png");
		// make characters player
		Character player = new Character("player", 1);
		player.setDie(6);
		
		// make character opponent
		Character opponent = new Character("opponent", 1);
		opponent.setDie(6);
		
		
		// fight
		Battle battle = new Battle(player, 20, opponent, 20);
		battle.battle();
		
	}
	private static Lwjgl3Application createApplication() {
		return new Lwjgl3Application(new BloodMortgage(), getDefaultConfiguration());
	}

	private static Lwjgl3ApplicationConfiguration getDefaultConfiguration() {
		Lwjgl3ApplicationConfiguration configuration = new Lwjgl3ApplicationConfiguration();
		configuration.setTitle("BloodMortgage");
		configuration.useVsync(true);
		//// Limits FPS to the refresh rate of the currently active monitor.
		configuration.setForegroundFPS(Lwjgl3ApplicationConfiguration.getDisplayMode().refreshRate);
		//// If you remove the above line and set Vsync to false, you can get unlimited FPS, which can be
		//// useful for testing performance, but can also be very stressful to some hardware.
		//// You may also need to configure GPU drivers to fully disable Vsync; this can cause screen tearing.
		configuration.setWindowedMode(640, 480);
		configuration.setWindowIcon("libgdx128.png", "libgdx64.png", "libgdx32.png", "libgdx16.png");
		return configuration;
	}
}