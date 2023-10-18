import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {
        System.out.println("\nWelcome to my Zoo Program, where your animal will never be misplaced!!");

        //Create list for each species to store each of their names to be used later when assigning names.
        List<String> hyenaNamesList = new ArrayList<>(AnimalNames.getNamesForSpecies("Hyena"));
        List<String> lionNamesList = new ArrayList<>(AnimalNames.getNamesForSpecies("Lion"));
        List<String> bearNamesList = new ArrayList<>(AnimalNames.getNamesForSpecies("Bear"));
        List<String> tigerNamesList = new ArrayList<>(AnimalNames.getNamesForSpecies("Tiger"));

        System.out.println("\n");
        System.out.println("Hyena Names: " + hyenaNamesList);
        System.out.println("Lion Names: " + lionNamesList);
        System.out.println("Bear Names: " + bearNamesList);
        System.out.println("Tiger Names: " + tigerNamesList);
        System.out.println("\n");

        // Call getAnimalCount to get the total animal count at the start of program
        int totalAnimalCount = Animal.getAnimalCount();
        System.out.println("\nTotal Animal Count: " + totalAnimalCount);


        // load in the arriving animals list from arriving animals class
        List<Animal> arrivingAnimals = ArrivingAnimals.loadArrivingAnimalsFromFile("C:\\Users\\Johnny\\JavaFiles\\arrivingAnimals.txt");

        // create separate list by species to store species information from arriving animals file
        List<Animal> hyenas = new ArrayList<>();
        List<Animal> lions = new ArrayList<>();
        List<Animal> bears = new ArrayList<>();
        List<Animal> tigers = new ArrayList<>();

        // use to correctly parse out the digits of age
        Pattern agePattern = Pattern.compile("(\\d+) year old");

        // for every animal in arriving animals look to see if it contains either Hyena, Lion, Bear, or Tiger then add it to its corresponding array list
        for (Animal animal : arrivingAnimals) {
            String animalDesc = animal.getAnimalDesc();

            if (animalDesc.contains("hyena")) {
                hyenas.add(animal);
            } else if (animalDesc.contains("lion")) {
                lions.add(animal);
            } else if (animalDesc.contains("bear")) {
                bears.add(animal);
            } else if (animalDesc.contains("tiger")) {
                tigers.add(animal);
            }
        }

        // output the information after it has been separated into its corresponding species array list
        System.out.println("\nHyenas: \n");

        // create a for loop that creates a Hyena object for every hyena description in the hyenas array list
        for (Animal hyena : hyenas) {
            Hyena newHyena = new Hyena();
            // for every new hyena set an animal id using the genUniqueId method in the AnimalUtil class
            newHyena.setAnimalID(AnimalUtils.genUniqueId("Hyena"));


            // correctly extract age from the hyena descriptions
            Matcher matcher = agePattern.matcher(hyena.getAnimalDesc());

            // create a for loop that finds gets the age and birthseason
            if (matcher.find()) {
                String age = matcher.group(1);
                String birthSeason = hyena.getAnimalBirthSeason();
                Date birthdate;

                // create a nested if statement so that if a birth season is unknown it bypasses birth season and just uses current date and age
                if (!"unknown birth season".equalsIgnoreCase(birthSeason)) {
                    birthdate = AnimalUtils.calculateBirthdate(Integer.parseInt(age), birthSeason);

                } else { // create else statement that configures the birthday using the calculate birthdate method in AnimalUtil
                    Calendar calendar = Calendar.getInstance();
                    calendar.add(Calendar.YEAR, -Integer.parseInt(age));
                    calendar.set(Calendar.MONTH, Calendar.JANUARY);
                    calendar.set(Calendar.DAY_OF_MONTH, 1);
                    birthdate = calendar.getTime();
                }

                // set the format you want to be outputted
                SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
                String formattedBirthdate = sdf.format(birthdate);


                // display the created hyenas, set format.
                System.out.println(newHyena.getAnimalID() + "; " + /*+ newHyena.getAnimalName() + "; " +*/
                        age + " years old; birth date " + formattedBirthdate + "; " +
                        hyena.getAnimalColor() + "; " +
                        hyena.getAnimalGender() + "; " +
                        hyena.getAnimalWeight() + "; " +
                         hyena.getOrigin());


            }
            System.out.println();
        }

        // repeat the same steps done for hyena for each of the other three species Lions, Bears, and Tigers


        System.out.println("\nLions: \n");
        for (Animal lion : lions) {
            Lion newLion = new Lion();
           // newLion.setLionName(lionNamesList);
            newLion.setAnimalID(AnimalUtils.genUniqueId("Lion"));

            Matcher matcher = agePattern.matcher(lion.getAnimalDesc());
            if (matcher.find()) {
                String age = matcher.group(1);
                String birthSeason = lion.getAnimalBirthSeason();
                Date birthdate;
                if (!"unknown birth season".equalsIgnoreCase(birthSeason)) {
                    birthdate = AnimalUtils.calculateBirthdate(Integer.parseInt(age), birthSeason);
                } else {
                    Calendar calendar = Calendar.getInstance();
                    calendar.add(Calendar.YEAR, -Integer.parseInt(age));
                    calendar.set(Calendar.MONTH, Calendar.JANUARY);
                    calendar.set(Calendar.DAY_OF_MONTH, 1);
                    birthdate = calendar.getTime();
                }

                SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
                String formattedBirthdate = sdf.format(birthdate);

                System.out.println(newLion.getAnimalID() + "; " + /*newLion.getAnimalName() + "; " +*/
                        age + " years old; birth date " + formattedBirthdate + "; " +
                        lion.getAnimalColor() + "; " +
                        lion.getAnimalGender() + "; " +
                        lion.getAnimalWeight() + "; "
                         + lion.getOrigin());


            }
            System.out.println();
        }


        System.out.println("\nBears: \n");
        for (Animal bear : bears) {
            Bear newBear = new Bear();
           // newBear.setBearName(bearNamesList);
            newBear.setAnimalID(AnimalUtils.genUniqueId("Bear"));

            Matcher matcher = agePattern.matcher(bear.getAnimalDesc());
            if (matcher.find()) {
                String age = matcher.group(1);
                String birthSeason = bear.getAnimalBirthSeason();
                Date birthdate;
                if (!"unknown birth season".equalsIgnoreCase(birthSeason)) {
                    birthdate = AnimalUtils.calculateBirthdate(Integer.parseInt(age), birthSeason);
                } else {
                    Calendar calendar = Calendar.getInstance();
                    calendar.add(Calendar.YEAR, -Integer.parseInt(age));
                    calendar.set(Calendar.MONTH, Calendar.JANUARY);
                    calendar.set(Calendar.DAY_OF_MONTH, 1);
                    birthdate = calendar.getTime();
                }

                SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
                String formattedBirthdate = sdf.format(birthdate);

                System.out.println(newBear.getAnimalID() + "; " + /*newBear.getAnimalName() + "; " +*/
                        age + " years old; birth date " + formattedBirthdate + "; " +
                        bear.getAnimalColor() + "; " +
                        bear.getAnimalGender() + "; " +
                        bear.getAnimalWeight() +
                        "; " + bear.getOrigin());


            }
            System.out.println();
        }


        System.out.println("\nTigers: \n");
        for (Animal tiger : tigers) {
            Tiger newTiger = new Tiger();
            //newTiger.setTigerName(tigerNamesList);
            newTiger.setAnimalID(AnimalUtils.genUniqueId("Tiger"));

            Matcher matcher = agePattern.matcher(tiger.getAnimalDesc());
            if (matcher.find()) {
                String age = matcher.group(1);
                String birthSeason = tiger.getAnimalBirthSeason();
                Date birthdate;
                if (!"unknown birth season".equalsIgnoreCase(birthSeason)) {
                    birthdate = AnimalUtils.calculateBirthdate(Integer.parseInt(age), birthSeason);
                } else {
                    Calendar calendar = Calendar.getInstance();
                    calendar.add(Calendar.YEAR, -Integer.parseInt(age));
                    calendar.set(Calendar.MONTH, Calendar.JANUARY);
                    calendar.set(Calendar.DAY_OF_MONTH, 1);
                    birthdate = calendar.getTime();
                }

                SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
                String formattedBirthdate = sdf.format(birthdate);



                System.out.println(newTiger.getAnimalID() + "; " + /*newTiger.getAnimalName() + "; " +*/
                        age + " years old; birth date " + formattedBirthdate + "; " +
                        tiger.getAnimalColor() + "; " +
                        tiger.getAnimalGender() + "; " +
                        tiger.getAnimalWeight() +
                        "; " + tiger.getOrigin());


            }
            System.out.println();
        }




        System.out.println("There are now " + Hyena.getNumOfHyenas() + " Hyenas in the zoo" );
        System.out.println("There are now " + Lion.getNumberOfLions() + " Lions in the zoo");
        System.out.println("There are now "+ Bear.getNumberOfBears() + " Bears in the zoo");
        System.out.println("There are now " + Tiger.getNumOfTiger() + " Tigers in the zoo");

        int totalHyenas = hyenas.size();
        int totalLions= lions.size();
        int totalBears = bears.size();
        int totalTigers = tigers.size();

        System.out.println("Total Hyenas: " + totalHyenas);
        System.out.println("Total Lions: " + totalLions);
        System.out.println("Total Bears: " + totalBears);
        System.out.println("Total Tigers: " + totalTigers);

        int totalAnimals = totalBears + totalLions + totalHyenas + totalTigers;

        System.out.println("Total Animals: " + totalAnimals);





        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ZooPopulation.txt"))) {
            // Call getAnimalCount to get the total animal count

            writer.write("Zoo Population:");
            writer.newLine();

            // List<String> hyenaNames = AnimalNames.getNamesForSpecies("Hyena");
            // ... (rest of your code)


            // Hyenas Habitat
            writer.write("\n\nHyena Habitat:\n");
            writer.newLine();

            int hyenaCounter = 1; // Initialize a counter

            for (int i = 0; i < hyenas.size(); i++) {
                Animal hyena = hyenas.get(i);  // Get the current hyena from the list
                Matcher matcher = agePattern.matcher(hyena.getAnimalDesc());
                if (matcher.find()) {
                    String age = matcher.group(1);
                    String birthSeason = hyena.getAnimalBirthSeason();
                    Date birthdate;
                    if (!"unknown birth season".equalsIgnoreCase(birthSeason)) {
                        birthdate = AnimalUtils.calculateBirthdate(Integer.parseInt(age), birthSeason);
                    } else {
                        Calendar calendar = Calendar.getInstance();
                        calendar.add(Calendar.YEAR, -Integer.parseInt(age));
                        calendar.set(Calendar.MONTH, Calendar.JANUARY);
                        calendar.set(Calendar.DAY_OF_MONTH, 1);
                        birthdate = calendar.getTime();
                    }

                    SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
                    String formattedBirthdate = sdf.format(birthdate);

                    // Here, set the unique ID and name based on your object structure
                    String uniqueID = "Hy" + String.format("%02d", hyenaCounter); // Generate a unique ID
                    hyenaCounter++; // Increment the counter

                    String hyenaName = hyenaNamesList.get(i); // Get a name from the list

                    hyena.setAnimalID(uniqueID);
                    hyena.setAnimalName(hyenaName);

                    writer.write(hyena.getAnimalID() + "; " + hyena.getAnimalName() + "; " +
                            age + " years old; birth date " + formattedBirthdate + "; " +
                            hyena.getAnimalColor() + "; " +
                            hyena.getAnimalGender() + "; " +
                            hyena.getAnimalWeight() + " pounds; " +
                            "; " + "Sound profile:  "   +
                            "; " + "from " + hyena.getOrigin());
                    writer.newLine();
                }
            }


            writer.write("\n\nLion Habitat:\n");
            writer.newLine();

            int lionCounter = 1; // Initialize a counter

            for (int i = 0; i < lions.size(); i++) {
                Animal lion = lions.get(i);  // Get the current lion from the list
                Matcher matcher = agePattern.matcher(lion.getAnimalDesc());
                if (matcher.find()) {
                    String age = matcher.group(1);
                    String birthSeason = lion.getAnimalBirthSeason();
                    Date birthdate;
                    if (!"unknown birth season".equalsIgnoreCase(birthSeason)) {
                        birthdate = AnimalUtils.calculateBirthdate(Integer.parseInt(age), birthSeason);
                    } else {
                        Calendar calendar = Calendar.getInstance();
                        calendar.add(Calendar.YEAR, -Integer.parseInt(age));
                        calendar.set(Calendar.MONTH, Calendar.JANUARY);
                        calendar.set(Calendar.DAY_OF_MONTH, 1);
                        birthdate = calendar.getTime();
                    }

                    SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
                    String formattedBirthdate = sdf.format(birthdate);

                    // Here, set the unique ID and name based on your object structure
                    String uniqueID = "Li" + String.format("%02d", lionCounter); // Generate a unique ID
                    lionCounter++; // Increment the counter

                    String lionName = lionNamesList.get(i); // Get a name from the list

                    lion.setAnimalID(uniqueID);
                    lion.setAnimalName(lionName);

                    writer.write(lion.getAnimalID() + "; " + lion.getAnimalName() + "; " +
                            age + " years old; birth date " + formattedBirthdate + "; " +
                            lion.getAnimalColor() + "; " +
                            lion.getAnimalGender() + "; " +
                            lion.getAnimalWeight() + " pounds; " +
                            "; " + "Sound profile:  "  +
                            "; " + "from " + lion.getOrigin());
                    writer.newLine();
                }
            }
            writer.write("\n\nBear Habitat:\n");
            writer.newLine();

            int bearCounter = 1; // Initialize a counter

            for (int i = 0; i < bears.size(); i++) {
                Animal bear = bears.get(i);  // Get the current bear from the list
                Matcher matcher = agePattern.matcher(bear.getAnimalDesc());
                if (matcher.find()) {
                    String age = matcher.group(1);
                    String birthSeason = bear.getAnimalBirthSeason();
                    Date birthdate;
                    if (!"unknown birth season".equalsIgnoreCase(birthSeason)) {
                        birthdate = AnimalUtils.calculateBirthdate(Integer.parseInt(age), birthSeason);
                    } else {
                        Calendar calendar = Calendar.getInstance();
                        calendar.add(Calendar.YEAR, -Integer.parseInt(age));
                        calendar.set(Calendar.MONTH, Calendar.JANUARY);
                        calendar.set(Calendar.DAY_OF_MONTH, 1);
                        birthdate = calendar.getTime();
                    }

                    SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
                    String formattedBirthdate = sdf.format(birthdate);

                    // Here, set the unique ID and name based on your object structure
                    String uniqueID = "Br" + String.format("%02d", bearCounter); // Generate a unique ID
                    bearCounter++; // Increment the counter

                    String bearName = bearNamesList.get(i); // Get a name from the list

                    bear.setAnimalID(uniqueID);
                    bear.setAnimalName(bearName);

                    writer.write(bear.getAnimalID() + "; " + bear.getAnimalName() + "; " +
                            age + " years old; birth date " + formattedBirthdate + "; " +
                            bear.getAnimalColor() + "; " +
                            bear.getAnimalGender() + "; " +
                            bear.getAnimalWeight() + " pounds; " +
                            "; " + "Sound profile:  "  +
                            "; " + "from " + bear.getOrigin());
                    writer.newLine();
                }
            }
            writer.write("\n\nTiger Habitat:\n");
            writer.newLine();

            int tigerCounter = 1; // Initialize a counter

            for (int i = 0; i < tigers.size(); i++) {
                Animal tiger = tigers.get(i);  // Get the current hyena from the list
                Matcher matcher = agePattern.matcher(tiger.getAnimalDesc());
                if (matcher.find()) {
                    String age = matcher.group(1);
                    String birthSeason = tiger.getAnimalBirthSeason();
                    Date birthdate;
                    if (!"unknown birth season".equalsIgnoreCase(birthSeason)) {
                        birthdate = AnimalUtils.calculateBirthdate(Integer.parseInt(age), birthSeason);
                    } else {
                        Calendar calendar = Calendar.getInstance();
                        calendar.add(Calendar.YEAR, -Integer.parseInt(age));
                        calendar.set(Calendar.MONTH, Calendar.JANUARY);
                        calendar.set(Calendar.DAY_OF_MONTH, 1);
                        birthdate = calendar.getTime();
                    }

                    SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
                    String formattedBirthdate = sdf.format(birthdate);

                    // Here, set the unique ID and name based on your object structure
                    String uniqueID = "Ti" + String.format("%02d", tigerCounter); // Generate a unique ID
                    tigerCounter++; // Increment the counter

                    String tigerName = tigerNamesList.get(i); // Get a name from the list

                    String sound = Tiger.getTigerSound();
                    tiger.setAnimalID(uniqueID);
                    tiger.setAnimalName(tigerName);

                    writer.write(tiger.getAnimalID() + "; " + tiger.getAnimalName() + "; " +
                            age + " years old; birth date " + formattedBirthdate + "; " +
                            tiger.getAnimalColor() + "; " +
                            tiger.getAnimalGender() + "; " +
                            tiger.getAnimalWeight() + " pounds; " +
                            "; " + "Sound profile:  " + sound  +
                            "; " + "from " + tiger.getOrigin());
                    writer.newLine();
                }
            }


            // Repeat this structure for lions, bears, and tigers

            // ...

        } catch (IOException e) {
            e.printStackTrace(); // Handle or report the error
        }
    }
}





