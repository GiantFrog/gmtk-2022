package science.skywhale.bloodmortgage.masterspellbook;

import science.skywhale.bloodmortgage.Character;

public class U6 extends Glyph {
	int damage;
	public U6 (Character owner) {  // TODO: CHange to glyph file name
		super();
		damage = 0;
		this.name = "Improved Channel Energy";
		this.description = "Adds a Bonus to the Value of this Face. The Bonus increases each time this Glyph is Rolled. Starts at 0. Current Bonus = " + damage ;
		this.owner = owner;
		this.glyphType = 1;
		this.flavor = "They say \"Patience is a virtue,\" but I want to skip to the good parts!";
	}
	
	@Override
	public int useGlyph() {
		// TODO: CHANGE THIS FOR EACH GLYPH
		damage++;
		return this.diceSide+damage-1;
	}
}
