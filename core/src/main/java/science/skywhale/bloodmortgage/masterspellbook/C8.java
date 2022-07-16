package science.skywhale.bloodmortgage.masterspellbook;

import science.skywhale.bloodmortgage.Character;

public class C8 extends Glyph {
	public C8(Character owner) {
		super();
		this.name = "Birch's Leaves";
		this.description = "Heal yourself by the Value of this Face.";
		this.owner = owner;
		this.glyphType = 0;
	}
	
	@Override
	public int useGlyph() {
		return 0;
	}
}
