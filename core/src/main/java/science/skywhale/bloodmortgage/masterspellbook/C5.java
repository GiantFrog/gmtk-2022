package science.skywhale.bloodmortgage.masterspellbook;

import science.skywhale.bloodmortgage.Character;

public class C5 extends Glyph {
	public C5(Character owner) {
		super();
		this.name = "Confetti!";
		this.description = "";
		this.owner = owner;
		this.glyphType = 0;
	}
	
	@Override
	public int useGlyph() {
		return diceSide;
	}
}
