package science.skywhale.bloodmortgage.masterspellbook;

import science.skywhale.bloodmortgage.Character;

public class Cx extends Glyph{
	int damage;
	public Cx (Character owner) {  // TODO: CHange to glyph file name
		super();
		this.name = "Channel Energy";
		this.description = "";
		this.owner = owner;
		this.glyphType = 0;  // TODO: MODIFY FOR GLYPH TYPE
		this.flavor = "";
	}
	
	@Override
	public int useGlyph() {
		// TODO: CHANGE THIS FOR EACH GLYPH
		return this.diceSide;
	}
}
