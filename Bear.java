

public class Bear extends Animal{
    private static int numberOfBears = 0;
    public Bear(){
        numberOfBears++;
    }

    public static int getNumberOfBears(){
        return numberOfBears;
    }

public static String bearSound = "GRRRRRRRR";
    static String getBearSound(){
        return bearSound;
    }




}
