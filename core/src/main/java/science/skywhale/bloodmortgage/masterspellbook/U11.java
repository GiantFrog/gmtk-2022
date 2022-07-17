package science.skywhale.bloodmortgage.masterspellbook;

import science.skywhale.bloodmortgage.Character;

public class U11 extends Glyph {
	public U11 (Character owner) {  // TODO: CHange to glyph file name
		super();
		this.name = "Aid of the Second Degree";
		this.description = "Heal yourself for 4 times the Value of this Face";
		this.owner = owner;
		this.glyphType = 1;  // TODO: MODIFY FOR GLYPH TYPE
		this.flavor = "It took decades for hospitals to develop the magic behind this medical marvel.";
		this.imgPath = "runes/u11.png";
	}
	
	@Override
	public int useGlyph() {
		// TODO: CHANGE THIS FOR EACH GLYPH
		owner.setToHeal(this.diceSide*4);
		return 0;
	}
}
