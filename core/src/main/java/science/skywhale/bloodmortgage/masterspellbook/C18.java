package science.skywhale.bloodmortgage.masterspellbook;

import science.skywhale.bloodmortgage.Character;

public class C18 extends Glyph {
	public C18 (Character owner) {  // TODO: CHange to glyph file name
		super();
		this.name = "Ward";
		this.description = "Block for Twice the Value of this Face";
		this.owner = owner;
		this.glyphType = 0;  // TODO: MODIFY FOR GLYPH TYPE
		this.flavor = "Easy to cast, easy to break";
		this.imgPath = "runes/c2.png";
	}
	
	@Override
	public int useGlyph() {
		// TODO: CHANGE THIS FOR EACH GLYPH
		owner.setBattleBlock(2*diceSide);
		return 0;
	}
}
