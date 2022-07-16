package science.skywhale.bloodmortgage.masterspellbook;

import science.skywhale.bloodmortgage.Character;

public class C4 extends Glyph {
	public C4(Character owner) {
		super();
		this.name = "Empty";
		this.description = "Description not found.";
		this.owner = owner;
		this.glyphType = 0;
	}
	
	@Override
	public int useGlyph() {
		return 0;
	}
}
