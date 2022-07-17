package science.skywhale.bloodmortgage.masterspellbook;

import science.skywhale.bloodmortgage.Character;

public class R1 extends Glyph {
	public R1 (Character owner) {  // TODO: CHange to glyph file name
		super();
		this.name = "Birch's Trunk";
		this.description = "Permanently increase your health by the Value of this Face, then heal that much";
		this.owner = owner;
		this.glyphType = 2;  // TODO: MODIFY FOR GLYPH TYPE
		this.flavor = "A birch with no trunk is just a bush. And this is the Magnificent Birch, not Magnificent Bush.";
		this.imgPath = "runes/r1.png";
	}
	
	@Override
	public int useGlyph() {
		// TODO: CHANGE THIS FOR EACH GLYPH
		owner.addToMaxHealth(this.diceSide);
		owner.setToHeal(this.diceSide);
		return this.diceSide;
	}
}
