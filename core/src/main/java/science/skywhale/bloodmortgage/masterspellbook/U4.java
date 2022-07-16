package science.skywhale.bloodmortgage.masterspellbook;

import science.skywhale.bloodmortgage.Character;

public class U4 extends Glyph {
	public U4 (Character owner) {  // TODO: CHange to glyph file name
		super();
		this.name = "Ultralightweighting";
		this.description = "Significantly increase the likelihood of this Face being rolled. Effect stacks each time this Glyph is rolled";
		this.owner = owner;
		this.glyphType = 1;  // TODO: MODIFY FOR GLYPH TYPE
		this.flavor = "";
	}
	
	@Override
	public int useGlyph() {
		// TODO: CHANGE THIS FOR EACH GLYPH
		this.weightMod += 3;
		return diceSide;
	}
}
