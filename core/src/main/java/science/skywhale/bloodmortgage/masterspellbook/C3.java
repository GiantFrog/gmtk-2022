package science.skywhale.bloodmortgage.masterspellbook;

import science.skywhale.bloodmortgage.Character;

public class C3 extends Glyph{
	int damage;
    public C3(Character owner) {
        super();
		damage = -3;
        this.name = "Channel Energy";
        this.description = "Adds a bonus to the Value of this Face. This Glyph Grows stronger each time it is ";
		this.description += " activated, but starts with a minor penalty. Current Bonus: " + damage;
        this.owner = owner;
        this.glyphType = 0;
		this.flavor = "It might not look like much now, but wait until next time!";
    }

    @Override
    public int useGlyph() {
        damage++;
        return damage-1+this.diceSide;
    }
}
