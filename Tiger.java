

public class Tiger extends Animal{
public static String tigerSound = "chuff";
static String getTigerSound() {
        return tigerSound;
    }
    private static int numbOfTigers = 0;

    public Tiger(){
        numbOfTigers++;
    }
    public static int getNumOfTiger() {
        return numbOfTigers;
    }





}




