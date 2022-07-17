package science.skywhale.bloodmortgage.masterspellbook;

import science.skywhale.bloodmortgage.Character;

public class C1 extends Glyph {
    public C1(Character owner) {
        super();
        this.name = "Arcane Boost";
        this.description = "Increase the Value of this Face by 1.";
        this.owner = owner;
        this.glyphType = 0;
		this.flavor = "A simple Glyph you learned in Scribing 101.";
		this.imgPath = "runes/c1.png";
    }

    @Override
    public int useGlyph() {
        return this.diceSide + 1;
    }
}
