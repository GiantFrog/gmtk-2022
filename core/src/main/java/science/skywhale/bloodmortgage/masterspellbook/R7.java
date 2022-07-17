package science.skywhale.bloodmortgage.masterspellbook;

import science.skywhale.bloodmortgage.Character;
public class R7 extends Glyph {
	public R7 (Character owner) {  // TODO: CHange to glyph file name
		super();
		this.name = "Vampirism";
		this.description = "Deal twice the Value of this Face damage, then Heal self for that amount.";
		this.owner = owner;
		this.glyphType = 2;  // TODO: MODIFY FOR GLYPH TYPE
		this.flavor = "Who needs nine lives when this one never ends?";
		this.imgPath = "runes/r7.png";
	}
	
	@Override
	public int useGlyph() {
		// TODO: CHANGE THIS FOR EACH GLYPH
		owner.setToHeal(this.diceSide*2);
		return this.diceSide*2;
	}
}