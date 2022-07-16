package science.skywhale.bloodmortgage.masterspellbook;

import science.skywhale.bloodmortgage.Character;

public class R1 extends Glyph {
	public R1 (Character owner) {  // TODO: CHange to glyph file name
		super();
		this.name = "Birch's Trunk";
		this.description = "Permanently ";
		this.owner = owner;
		this.glyphType = 2;  // TODO: MODIFY FOR GLYPH TYPE
		this.flavor = "";
	}
	
	@Override
	public int useGlyph() {
		// TODO: CHANGE THIS FOR EACH GLYPH
		return this.diceSide;
	}
}
