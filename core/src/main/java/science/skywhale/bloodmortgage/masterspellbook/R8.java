package science.skywhale.bloodmortgage.masterspellbook;

import science.skywhale.bloodmortgage.Character;

public class R8 extends Glyph {
	int damage=0;
	public R8 (Character owner) {  // TODO: CHange to glyph file name
		super();
		this.name = "Athdranax's Die Buster";
		this.description = "Adds an increasing Bonus to die Damage, and increases the probability of this Face being rolled again. Effect stacks each time this Glyph is Rolled. Current Bonus = "+damage;
		this.owner = owner;
		this.glyphType = 2;  // TODO: MODIFY FOR GLYPH TYPE
		this.flavor = "It's blatant cheating at this point. But Athdranax was never bothered by that.";
	}
	
	@Override
	public int useGlyph() {
		// TODO: CHANGE THIS FOR EACH GLYPH
		damage++;
		this.weightMod++;
		return this.diceSide+damage-1;
	}
}