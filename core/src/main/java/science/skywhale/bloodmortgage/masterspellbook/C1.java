package science.skywhale.bloodmortgage.masterspellbook;

import science.skywhale.bloodmortgage.Character;

public class C1 extends Glyph {
    public C1(Character owner) {
        super();
        this.name = "Arcane Boost";
        this.description = "Increase this face by 1";
        this.owner = owner;
        this.glyphType = 0;
    }

    @Override
    public int useGlyph() {
        return this.diceSide + 1;
    }
}
