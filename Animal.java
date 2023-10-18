import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Animal {
    protected String animalName;

    protected String animalDesc;
    protected String animalAge; // optional
    protected String animalBirthSeason;
    protected Date animalBirthdate;
    protected String animalGender;
    protected String animalWeight;
    protected String animalColor;
    protected String origin;
    protected String animalID;



    private static int animalCount = 0;

    public static void incrementAnimalCount() {
        animalCount++;

    }

    public static int getAnimalCount() {
        return animalCount;
    }




    public void setAnimalDesc(String animalDesc) {
        this.animalDesc = animalDesc;
    }

    public void setAnimalAge(String animalAge) {
        this.animalAge = animalAge;
    }

    public void setAnimalGender(String animalGender) {
        this.animalGender = animalGender;
    }

    public void setAnimalBirthSeason(String animalBirthSeason) {
        this.animalBirthSeason = animalBirthSeason;
    }

    public void setAnimalColor(String animalColor) {
        this.animalColor = animalColor;
    }

    public void setAnimalWeight(String animalWeight) {
        this.animalWeight = animalWeight;
    }

    public void setOrigin(String origin1) {
        this.origin = origin1;
    }

    public void setAnimalID(String animalID) {
        this.animalID = animalID;
    }

    public String getFormattedBirthDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
        return sdf.format(animalBirthdate);
    }

    public String getAnimalID() {
        return animalID;
    }

    public String getAnimalAge() {
        return animalAge;
    }

    public Date getAnimalBirthdate() {
        return animalBirthdate;
    }

    public String getAnimalDesc() {
        return animalDesc;
    }


    public String getAnimalGender() {
        return animalGender;
    }

    public String getAnimalBirthSeason() {
        return animalBirthSeason;
    }

    public String getAnimalColor() {
        return animalColor;
    }

    public String getAnimalWeight() {
        return animalWeight;
    }

    public String getOrigin() {
        return origin;
    }


    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalName() {
        return animalName;
    }

    public String getInfo() {
        // Customize this method to return the desired information about the animal
        // For example, return a formatted string with all the animal's details
        return "Animal information: " +
                "ID: " + getAnimalID() +
                ", Name: " + getAnimalName() +
                ", Age: " + getAnimalAge() +
                ", Birth Date: " + getAnimalBirthdate() +
                ", Color: " + getAnimalColor() +
                ", Gender: " + getAnimalGender() +
                ", Weight: " + getAnimalWeight() +
                ", Origin: " + getOrigin();
    }




}