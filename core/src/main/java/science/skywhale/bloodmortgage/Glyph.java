public abstract class Glyph {
    //private image

    private int weightMod = 0;
    private String glyphName;

    public Glyph(String glyphName){
        this.glyphName = glyphName;
    }

    public String getName(){
        return glyphName;
    }

    public void setWeightMod(int newMod){
        weightMod = newMod;
    }

    public int getWeightMod(){
        return weightMod;
    }

    public abstract void useGlyph();
}
