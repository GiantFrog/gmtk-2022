package science.skywhale.bloodmortgage.masterspellbook;

import science.skywhale.bloodmortgage.Character;

public class C7 extends Glyph {
	public C7(Character owner) {
		super();
		this.name = "Light as a feather";
		this.description = "Increase the likelihood that this Face will be rolled. Effect stacks each time this Glyph is Rolled.";
		this.owner = owner;
		this.glyphType = 0;
		this.flavor = "\"You're going to have to learn to tip the Die in your favor if you want to survive in this cutthroat market\" --Athdranax";
		this.imgPath = "runes/c7.png";
	}
	
	@Override
	public int useGlyph() {
		this.weightMod++;
		return diceSide;
	}
}
