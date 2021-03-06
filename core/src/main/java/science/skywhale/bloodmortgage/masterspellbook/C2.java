package science.skywhale.bloodmortgage.masterspellbook;

import science.skywhale.bloodmortgage.Character;

public class C2 extends Glyph{
    public C2(Character owner) {
        super();
        this.name = "Ward";
        this.description = "Block twice the Value of this Face.";
        this.owner = owner;
        this.glyphType = 0;
		this.flavor = "\"For the knight is dumb and full of errors\" --Athdranax";
		this.imgPath = "runes/c2.png";
    }

    @Override
    public int useGlyph() {
        owner.setBattleBlock(2*diceSide);
        return 0;
    }
}
