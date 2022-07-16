package science.skywhale.bloodmortgage.masterspellbook;

import science.skywhale.bloodmortgage.Character;

public class Common2 extends Glyph{
    public Common2(Character owner) {
        super();
        this.name = "Common2";
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
