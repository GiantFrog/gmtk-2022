package science.skywhale.bloodmortgage.masterspellbook;

import science.skywhale.bloodmortgage.Character;

public class U7 extends Glyph {
	public U7 (Character owner) {  // TODO: CHange to glyph file name
		super();
		this.name = "Mystic Boost";
		this.description = "Increase the Value of this Face by 3.";
		this.owner = owner;
		this.glyphType = 1;  // TODO: MODIFY FOR GLYPH TYPE
		this.flavor = "Turns out, all it takes to elevate this Glyph from 'Arcane' to 'Mystic' is a bit of flair";
	}
	
	@Override
	public int useGlyph() {
		// TODO: CHANGE THIS FOR EACH GLYPH
		return this.diceSide+3;
	}
}
