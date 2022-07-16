package science.skywhale.bloodmortgage.masterspellbook;

import science.skywhale.bloodmortgage.Character;

public class U3 extends Glyph {
	public U3 (Character owner) {  // TODO: CHange to glyph file name
		super();
		this.name = "One-Two Punch";
		this.description = "";
		this.owner = owner;
		this.glyphType = 0;  // TODO: MODIFY FOR GLYPH TYPE
		this.flavor = "";
	}
	
	@Override
	public int useGlyph() {
		// TODO: CHANGE THIS FOR EACH GLYPH
		return this.diceSide;
	}
}
