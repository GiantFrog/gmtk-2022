package science.skywhale.bloodmortgage.masterspellbook;

import science.skywhale.bloodmortgage.Character;

public class U8 extends Glyph {
	public U8 (Character owner) {  // TODO: CHange to glyph file name
		super();
		this.name = "Mark of Mulligan";
		this.description = "Does nothing besides Roll again.";
		this.owner = owner;
		this.glyphType = 1;  // TODO: MODIFY FOR GLYPH TYPE
		this.flavor = "Somehow, the Die always seems to roll off the table or land on an uneven surface when this side comes up. And we all know that means you get a re-roll";
		//this.imgPath = "runes/.png";
	}
	
	@Override
	public int useGlyph() {
		// TODO: CHANGE THIS FOR EACH GLYPH
		return 0;
	}
}
