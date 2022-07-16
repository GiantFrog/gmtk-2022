package science.skywhale.bloodmortgage.masterspellbook;

import science.skywhale.bloodmortgage.Character;

public class C3 extends Glyph{
	int damage;
    public C3(Character owner) {
        super();
        this.name = "Channel Energy";
        this.description = "";
        this.owner = owner;
        this.glyphType = 0;
		damage = -3;
    }

    @Override
    public int useGlyph() {
        damage++;
        return damage;
    }
}
