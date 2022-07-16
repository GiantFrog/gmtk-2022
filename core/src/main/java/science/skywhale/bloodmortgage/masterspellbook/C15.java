package science.skywhale.bloodmortgage.masterspellbook;

import science.skywhale.bloodmortgage.Character;

public class C15 extends Glyph {
	public C15 (Character owner) {  // TODO: CHange to glyph file name
		super();
		this.name = "Sigil of First Aid";
		this.description = "Heal yourself by the value of this Face.";
		this.owner = owner;
		this.glyphType = 0;  // TODO: MODIFY FOR GLYPH TYPE
		this.flavor = "It might be 'just a flesh wound', but you should still get that checked out";
	}
	
	@Override
	public int useGlyph() {
		// TODO: CHANGE THIS FOR EACH GLYPH
		owner.setToHeal(this.diceSide);
		return 0;
	}
}
