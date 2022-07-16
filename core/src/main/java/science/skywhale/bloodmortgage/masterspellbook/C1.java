package science.skywhale.bloodmortgage.masterspellbook;

import science.skywhale.bloodmortgage.Character;

public class Common1 extends Glyph {
    public Common1(Character owner) {
        super();
        this.name = "Common1";
        this.description = "Increase this face by 1";
        this.owner = owner;
        this.glyphType = 0;
    }

    @Override
    public int useGlyph() {
        return this.diceSide + 1;
    }
}
