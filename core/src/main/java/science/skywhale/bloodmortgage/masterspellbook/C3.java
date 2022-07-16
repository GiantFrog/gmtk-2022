package science.skywhale.bloodmortgage.masterspellbook;

import science.skywhale.bloodmortgage.Character;

public class C3 extends Glyph{
	int damage;
    public C3(Character owner) {
        super();
        this.name = "Channel Energy";
        this.description = "Adds a bonus to the Value of this Face. This Glyph Grows stronger each time it is ";
		this.description += " activated, but starts with a minor penalty. Current Bonus: [placeholder for current boost]";
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
