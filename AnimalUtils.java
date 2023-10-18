import java.text.SimpleDateFormat;
import java.util.*;

public class AnimalUtils extends Animal {

        // generate unique id for each of the species giving them a prefix followed 2 digits
    public static String genUniqueId(String species) {
        switch (species.toLowerCase()) {
            case "hyena":
                return "Hy" + String.format("%02d", Hyena.getNumOfHyenas());
            case "lion":
                return "Li" + String.format("%02d", Lion.getNumberOfLions());
            case "tiger":
                return "Ti" + String.format("%02d", Tiger.getNumOfTiger());
            case "bear":
                return "Br" + String.format("%02d", Bear.getNumberOfBears());
            default:
                throw new IllegalArgumentException("Unsupported species: " + species);
        }
    }

    // method to calculate birthdate based off of current date - age, with default month and day of the start of corresponding birth season for the animal
    public static Date calculateBirthdate(int age, String birthSeason){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy", Locale.US);

        // Get today's date:
        Date today = calendar.getTime();

        // Calculate the birth year based on the current date and age
        calendar.add(Calendar.YEAR, -age);
        Date birthdate = calendar.getTime();

        // Calculate the birth month and day based on the birth season
        if (birthSeason.contains("spring")) {
            // Set the birthdate to March 31st of the birth year
            calendar.set(Calendar.MONTH, Calendar.MARCH);
            calendar.set(Calendar.DAY_OF_MONTH, 19);
        } else if (birthSeason.contains("fall")) {
            // Set the birthdate to September 30th of the birth year
            calendar.set(Calendar.MONTH, Calendar.SEPTEMBER);
            calendar.set(Calendar.DAY_OF_MONTH, 23);
        } else if (birthSeason.contains("winter")) {
            // Set the birthdate to September 30th of the birth year
            calendar.set(Calendar.MONTH, Calendar.DECEMBER);
            calendar.set(Calendar.DAY_OF_MONTH, 21);
            // You can add more cases for other seasons if needed
        }else if (birthSeason.contains("summer")) {
            // Set the birthdate to September 30th of the birth year
            calendar.set(Calendar.MONTH, Calendar.JUNE);
            calendar.set(Calendar.DAY_OF_MONTH, 20);
            // You can add more cases for other seasons if needed
        }


        // Set the final birthdate with the calculated month and day
        birthdate = calendar.getTime();

        return birthdate;
    }
    public static int extractAge(String animalDesc) {
        String[] wordsInDesc = animalDesc.split(" ");
        for (int i = 0; i < wordsInDesc.length; i++) {
            if (wordsInDesc[i].equalsIgnoreCase("years") && i > 0) {
                try {
                    return Integer.parseInt(wordsInDesc[i - 1]);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0; // Default to 0 if age is not found
    }

    public static String extractGender(String animalDesc) {
        String[] wordsInDesc = animalDesc.split(" ");
        for (String word : wordsInDesc) {
            if ("male".equalsIgnoreCase(word) || "female".equalsIgnoreCase(word)) {
                return word.toLowerCase();
            }
        }
        return "unknown"; // Default to "unknown" if gender is not found
    }






}



