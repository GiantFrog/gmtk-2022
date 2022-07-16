package science.skywhale.bloodmortgage.masterspellbook;

import science.skywhale.bloodmortgage.Character;

public class C2 extends Glyph{
    public C2(Character owner) {
        super();
        this.name = "Ward";
        this.description = "Block up to 2N damage";
        this.owner = owner;
        this.glyphType = 0;
    }

    @Override
    public int useGlyph() {
        owner.setBattleBlock(2*diceSide);
        return 0;
    }
}
