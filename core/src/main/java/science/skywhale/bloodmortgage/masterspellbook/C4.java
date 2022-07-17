package science.skywhale.bloodmortgage.masterspellbook;

import science.skywhale.bloodmortgage.Character;

public class C4 extends Glyph {
	public C4(Character owner) {
		super();
		this.name = "Empty";
		this.description = "Description not found.";
		this.owner = owner;
		this.glyphType = 0;
		this.flavor = "You didn't think you'd get to start with a fully enhanced Die, did you?";
		this.imgPath = "runes/c4 none.png";
	}
	
	@Override
	public int useGlyph() {
		return this.diceSide;
	}
}
