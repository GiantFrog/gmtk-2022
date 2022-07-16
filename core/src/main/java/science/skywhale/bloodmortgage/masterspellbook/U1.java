package science.skywhale.bloodmortgage.masterspellbook;

import science.skywhale.bloodmortgage.Character;

public class U1 extends Glyph {
	public U1 (Character owner) {  // TODO: CHange to glyph file name
		super();
		this.name = "Birch's Roots";
		this.description = "Permanently increase your health by the Value of this Face.";
		this.owner = owner;
		this.glyphType = 1;  // TODO: MODIFY FOR GLYPH TYPE
		this.flavor = "Draw forth from the soil the nutrients for growth.";
	}
	
	@Override
	public int useGlyph() {
		// TODO: CHANGE THIS FOR EACH GLYPH
		owner.addToMaxHealth(this.diceSide);
		return 0;
	}
}
