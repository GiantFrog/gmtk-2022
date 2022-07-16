package science.skywhale.bloodmortgage.masterspellbook;

public class L4 extends Glyph {
	public L4 (Character owner) {  // TODO: CHange to glyph file name
		super();
		this.name = "Randy's Boon";
		this.description = "Block all incoming damage from your opponent's next roll";
		this.owner = owner;
		this.glyphType = 2;  // TODO: MODIFY FOR GLYPH TYPE
		this.flavor = "Become the immovable obstacle and the unstoppable force!";
	}
	
	@Override
	public int useGlyph() {
		// TODO: CHANGE THIS FOR EACH GLYPH
		owner.setBattleBlock(1000);
		return 0;
	}
}