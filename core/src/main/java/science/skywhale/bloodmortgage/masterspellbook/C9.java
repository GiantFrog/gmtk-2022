package science.skywhale.bloodmortgage.masterspellbook;

import science.skywhale.bloodmortgage.Character;

public class C9 extends Glyph {
	public C9 (Character owner) {
		super();
		this.name = "Wind-Up Punch";
		this.description = "Add the Value of this Face to your next Roll";
		this.owner = owner;
		this.glyphType = 0;
		this.flavor = "Not really a punch, but you get the idea.";
		this.imgPath = "runes/c9.png";
		// MEDIUM PRIORITY
	}
	
	@Override
	public int useGlyph() {
		// TODO: CHANGE THIS FOR EACH GLYPH
		return this.diceSide;
	}
}
