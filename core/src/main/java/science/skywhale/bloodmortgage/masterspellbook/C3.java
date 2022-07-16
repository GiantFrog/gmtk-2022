package science.skywhale.bloodmortgage.masterspellbook;

import science.skywhale.bloodmortgage.Character;

public class C3 extends Glyph{
    public C3(Character owner) {
        super();
        this.name = "Channel Energy";
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
