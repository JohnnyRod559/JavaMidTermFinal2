import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnimalNames {

    // declare a map that will store animal names for different species
    // string key (species)
    // list of string values (names)
    private static Map<String, List<String>> speciesNames = new HashMap<>();

    static {
        loadNamesFromFile();
    }

    public static void loadNamesFromFile() {
        String filePath ="C:\\Users\\Johnny\\JavaFiles\\animalNames.txt" ; // Update with the actual file path

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            String currentSpecies = null;
            List<String> currentNames = new ArrayList<>();

            // if the current species is not null and line is not empty, it adds the names to list of names for current species
            while ((line = br.readLine()) != null) {

                // trim leading and trailing whitespaces
                line = line.trim();
                // used to identify line containing beginning of new species
                if (line.endsWith(" Names:")) {
                    if (currentSpecies != null) {
                        //the name for species are added to the 'species names' map with the species name as key and the names as the value
                        speciesNames.put(currentSpecies, currentNames);
                    }
                    //current species is updated by extracting species name and removing "name"
                    currentSpecies = line.replace(" Names:", "").trim();
                    currentNames = new ArrayList<>();
                    // if conditions are met (current species is not null & line is not empty) then add names
                } else if (currentSpecies != null && !line.isEmpty()) {
                    currentNames.add(line);
                }
            }

            // if condition is met then processing is finished
            if (currentSpecies != null) {
                speciesNames.put(currentSpecies, currentNames);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // allows you to retrieve names for species
    public static List<String> getNamesForSpecies(String species) {
        return speciesNames.get(species);
    }
}