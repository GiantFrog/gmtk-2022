package science.skywhale.bloodmortgage.masterspellbook;

import science.skywhale.bloodmortgage.Character;

public class L1 extends Glyph {
	public L1 (Character owner) {  // TODO: CHange to glyph file name
		super();
		this.name = "Birch's Boon";
		this.description = "Permanently increase max health, heal self, block, and deal damage equal to the Value of this Face";
		this.owner = owner;
		this.glyphType = 3;  // TODO: MODIFY FOR GLYPH TYPE
		this.flavor = "The might of the forest stands by your side!";
	}
	
	@Override
	public int useGlyph() {
		// TODO: CHANGE THIS FOR EACH GLYPH
		owner.addToMaxHealth(this.diceSide);
		owner.setToHeal(this.diceSide);
		owner.setBattleBlock((this.diceSide));
		return this.diceSide;
	}
}