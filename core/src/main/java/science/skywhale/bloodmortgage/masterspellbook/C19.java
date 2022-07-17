package science.skywhale.bloodmortgage.masterspellbook;

import science.skywhale.bloodmortgage.Character;

public class C19 extends Glyph {
	public C19 (Character owner) {  // TODO: CHange to glyph file name
		super();
		this.name = "Empty";
		this.description = "Description found, but I'm not telling you";
		this.owner = owner;
		this.glyphType = 0;  // TODO: MODIFY FOR GLYPH TYPE
		this.flavor = "Sometimes they just don't have anything to offer. Shame.";
		//this.imgPath = "runes/.png";
	}
	
	@Override
	public int useGlyph() {
		// TODO: CHANGE THIS FOR EACH GLYPH
		return 0;
	}
}
