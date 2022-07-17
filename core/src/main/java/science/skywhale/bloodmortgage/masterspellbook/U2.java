package science.skywhale.bloodmortgage.masterspellbook;

import science.skywhale.bloodmortgage.Character;

public class U2 extends Glyph {
	public U2 (Character owner) {  // TODO: CHange to glyph file name
		super();
		this.name = "Sign of Virility";
		this.description = "Doubles the damage dealt by this Face.";
		this.owner = owner;
		this.glyphType = 1;  // TODO: MODIFY FOR GLYPH TYPE
		this.flavor = "Technically not false advertising, but this Glyph definitely doesn't do what many people buy it for. ;)";
		this.imgPath = "runes/u2.png";
	}
	
	@Override
	public int useGlyph() {
		// TODO: CHANGE THIS FOR EACH GLYPH
		return this.diceSide*2;
	}
}
