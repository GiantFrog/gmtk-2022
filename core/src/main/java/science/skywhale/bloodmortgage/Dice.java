package science.skywhale.bloodmortgage;

import science.skywhale.bloodmortgage.masterspellbook.Glyph;

public class Dice {
    private Glyph[] glyphs;

    public Dice(int numSides){
        glyphs = new Glyph[numSides];

    }

    public void setSide(Glyph newSide, int side){
        // TODO: Remove existing glyph if there is one
        // TODO: Check that side is within proper range and handle
        glyphs[side-1] = newSide;
    }

    public void printGlyphs(){
        for(int i=0; i<glyphs.length; i++){
            System.out.print((i+1) + ": ");
            if (glyphs[i] != null){
                System.out.println(glyphs[i].getName());
            } else {
                System.out.println("Empty");
            }
        }
    }

    // returns damage points done by roll
    public int roll(){
        int rolled = getRoll();
        Glyph glyph = glyphs[rolled];

        // see if roll resulted in a glyph
        if (glyph == null){
            // if not return rolled for damage
            return rolled;
        } else {
            return glyph.useGlyph();
        }
    }

    // returns an integer 1 to the number of sides of the dice
    public int getRoll(){
        String options = "";
        for(int i = 0; i<glyphs.length; i++){
            if (glyphs[i] == null) {
                for(int j=0; j<10; j++){
                    options += Integer.toString(i);
                }
            } else {
                int loteryReps = 10;

                int mod = glyphs[i].getWeightMod();
                loteryReps = loteryReps + mod;
                if (loteryReps < 1) {
                    loteryReps = 1;
                }
                for (int j = 0; j < loteryReps ; j++) {
                    options += Integer.toString(i);
                }
            }
        }
        //System.out.println("Options string: " + options);

        int position = (int) Math.floor(Math.random() * options.length());
        //System.out.println("Postioon: " + position);
        return Integer.parseInt(String.valueOf(options.charAt(position))) + 1;
    }
}
