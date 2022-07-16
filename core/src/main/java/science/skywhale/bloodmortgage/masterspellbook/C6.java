package science.skywhale.bloodmortgage.masterspellbook;

import science.skywhale.bloodmortgage.Character;

public class C6 extends Glyph {
	public C6(Character owner) {
		super();
		this.name = "Weighted down";
		this.description = "Decreases the likelihood that this Face will be rolled. Effect stacks each time this Glyph is Rolled.";
		this.owner = owner;
		this.glyphType = 0;
	}
	
	@Override
	public int useGlyph() {
		this.weightMod--;
		return diceSide;
	}
}
