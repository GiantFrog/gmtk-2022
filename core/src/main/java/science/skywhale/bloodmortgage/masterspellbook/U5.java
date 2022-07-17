package science.skywhale.bloodmortgage.masterspellbook;

import science.skywhale.bloodmortgage.Character;

public class U5 extends Glyph {
	public U5 (Character owner) {  // TODO: CHange to glyph file name
		super();
		this.name = "Ultra Heavy Weight";
		this.description = "Significantly decrease the likelihood of this Face being Rolled again. Effect stacks each time this Glyph is Rolled.";
		this.owner = owner;
		this.glyphType = 1;  // TODO: MODIFY FOR GLYPH TYPE
		this.flavor = "The only reason it isn't obvious this die is weighted is magic, obviously.";
		this.imgPath = "runes/u5.png";
	}
	
	@Override
	public int useGlyph() {
		// TODO: CHANGE THIS FOR EACH GLYPH
		this.weightMod -= 3;
		return this.diceSide;
	}
}
