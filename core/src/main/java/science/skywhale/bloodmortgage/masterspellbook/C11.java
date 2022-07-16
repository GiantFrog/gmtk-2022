package science.skywhale.bloodmortgage.masterspellbook;

import science.skywhale.bloodmortgage.Character;

public class C11 extends Glyph {
	public C11 (Character owner) {  // TODO: CHange to glyph file name
		super();
		this.name = "Blood Sacrifice";
		this.description = "Damage yourself for the Value on this Face, then deal three times as much damage.";
		this.owner = owner;
		this.glyphType = 0;  // TODO: MODIFY FOR GLYPH TYPE
		this.flavor = "No pain, no gain. It rhymes so it must be true.";
	}
	
	@Override
	public int useGlyph() {
		// TODO: CHANGE THIS FOR EACH GLYPH
		owner.setToHeal(-1*this.diceSide);
		return this.diceSide*3;
	}
}

