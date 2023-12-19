package simpaths.data;

import java.util.*;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import simpaths.model.enums.baselineDataEnums.EntityType;
import simpaths.model.enums.baselineDataEnums.ValueType;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.collections4.keyvalue.MultiKey;
import org.apache.commons.collections4.map.MultiKeyMap;



/**
This class manages access to the baseline data required to run a scenario for the complexity project.
If noShockPropagation in LABSimModel is true, then outcome of all processes except employment status is not simulated but
 loaded from a dataset. The dataset used has been first created by running the model once, with standard settings and saving the outputs.

 This class needs to:
    1) Load and store baseline data
    2) Provide values stored in the baseline data when requested by the model
 */

public class BaselineData {

    /*
    VARIABLE DEFINITIONS
     */

    // MultiKeyMap where key is composed of year, person ID, and variable name, and value stores the baseline value.
    // Should provide a O(1) access time. Retrieval time shouldn't increase as the map grows larger.
    private MultiKeyMap<MultiKey, String> baselineValuesMapPersons, baselineValuesMapBenefitUnits;

    private Map<EntityType, MultiKeyMap<MultiKey, String>> maps;

    /*
    CONSTRUCTOR
     */
    public BaselineData() {
        baselineValuesMapPersons = new MultiKeyMap<>();
        baselineValuesMapBenefitUnits = new MultiKeyMap<>();
        maps = new HashMap<>();

        maps.put(EntityType.Person, baselineValuesMapPersons);
        maps.put(EntityType.BenefitUnit, baselineValuesMapBenefitUnits);
    }

    public void loadBaselineData(String filename, List<String> includedColumns, String idColumnName, EntityType entityType) {
        try (Reader reader = Files.newBufferedReader(Paths.get(filename));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withAllowMissingColumnNames().withFirstRecordAsHeader())) {

            // Identify the indices of the columns containing time and id
            int timeIndex = csvParser.getHeaderMap().get("time");
            int idEntityIndex = csvParser.getHeaderMap().get(idColumnName);

            // Create a set of included column names for faster lookup
            Set<String> includedColumnSet = new HashSet<>(includedColumns);

            // Get the MultiKeyMap for the given entity type
            MultiKeyMap map = maps.get(entityType);
            if (map == null) {
                map = new MultiKeyMap();
                maps.put(entityType, map);
            }
            int count = 0;
            // Read each row of the file and store the data in the MultiKeyMap
            for (CSVRecord record : csvParser) {
                int year = (int) Double.parseDouble(record.get(timeIndex));
                long entityId = Long.parseLong(record.get(idEntityIndex));

                // Iterate over the remaining columns and store the data in the MultiKeyMap
                for (String variableName : csvParser.getHeaderMap().keySet()) {
                    if (variableName.equals("time") || variableName.equals(idColumnName) || !includedColumnSet.contains(variableName)) {
                        continue;
                    }
                    String value = record.get(variableName); // All values are stored as string, and parsed when they are accessed. This should be computationally cheaper or comparable to storing all values as objects and casting when they need to be used.

                    MultiKey key = new MultiKey(year, entityId, variableName);
                    map.put(key, value);
                }
                count++;
                if (count >= 10000) {
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Failed to load baseline data from file: " + filename);
            e.printStackTrace();
        }
    }

    /*
    OTHER METHODS
     */

    /**
     * Returns the multi-key map for the specified entity type.
     *
     * @param entityType the type of entity to get the multi-key map for
     * @return the multi-key map for the specified entity type
     */
    public MultiKeyMap<MultiKey, String> getBaselineValuesMap(String entityType) {
        return maps.get(entityType);
    }

    /**
     *
     * @param entityType a string variable indicating which entity type (Person, Benefit Unit) the converted variable belongs to
     * @param year year for which the value should be retrived
     * @param entityId id of entity for which the value should be obtained
     * @param variableName name of the variable to obtain, e.g. dag
     * @param valueType an enum implementing ValueType interface which specifies how the conversion should be done
     * @return value of @variableName for @entityId for a given @year which has been converted to an appropriate @valueType
     * @param <T>
     */
    public <T> T getValue(EntityType entityType, int year, long entityId, String variableName, ValueType<T> valueType) {
        MultiKey key = new MultiKey(year, entityId, variableName);
        MultiKeyMap<MultiKey, String> map = maps.get(entityType);
        String value = map.get(key);
        if (value == null) {
            return null;
        } else {
            return valueType.convert(value);
        }
    }


}
