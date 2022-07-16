package science.skywhale.bloodmortgage.masterspellbook;

import science.skywhale.bloodmortgage.Character;

public class C7 extends Glyph {
	public C7(Character owner) {
		super();
		this.name = "Light as a feather";
		this.description = "Increase the likelihood that this Face will be rolled. Effect stacks each time this Glyph is Rolled.";
		this.owner = owner;
		this.glyphType = 0;
	}
	
	@Override
	public int useGlyph() {
		this.weightMod++;
		return diceSide;
	}
}
