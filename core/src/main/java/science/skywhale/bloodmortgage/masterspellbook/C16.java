package science.skywhale.bloodmortgage.masterspellbook;

import science.skywhale.bloodmortgage.Character;

public class C16 extends Glyph {
	public C16 (Character owner) {  // TODO: CHange to glyph file name
		super();
		this.name = "Blood Sacrifice";
		this.description = "Damage yourself by the Value on this Face, then deal three times as much damage.";
		this.owner = owner;
		this.glyphType = 0;  // TODO: MODIFY FOR GLYPH TYPE
		this.flavor = "You should see the other guy!";
		this.imgPath = "runes/c11.png";
	}
	
	@Override
	public int useGlyph() {
		// TODO: CHANGE THIS FOR EACH GLYPH
		owner.setToHeal(-1*this.diceSide);
		return this.diceSide*3;
	}
}
