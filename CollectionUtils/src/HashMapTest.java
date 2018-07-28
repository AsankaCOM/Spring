//import java.util.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.Comparator;

public class HashMapTest {

//   John = 3
//   Mike = 3
//   Ricaro = 2
//   Bob = 1

    public String findTheWinner(String[] votes)
    {
        if (votes.length == 0)
            return "";

        Map<String,Integer> votesMap = new HashMap<>();

        for (String candidate : votes)
        {
            int count = votesMap.containsKey(candidate) ? votesMap.get(candidate) : 0;
            votesMap.put(candidate, count + 1);

        }

        List<Map.Entry<String, Integer>> sortedEntriesList = new ArrayList<>(votesMap.entrySet());

        Collections.sort(sortedEntriesList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                Integer v2 = e2.getValue();
                Integer v1 = e1.getValue();

                if (v1.equals(v2))
                    return e2.getKey().compareTo(e1.getKey());

                return v2.compareTo(v1);
            }
        });

        // reform the map
//        HashMap sortedHashMap = new LinkedHashMap();
//        for (Iterator it = sortedEntries.iterator(); it.hasNext();) {
//            Map.Entry entry = (Map.Entry) it.next();
//            sortedHashMap.put(entry.getKey(), entry.getValue());
//        }
//        return sortedHashMap;

        Map.Entry<String,Integer> entry = sortedEntriesList.iterator().next();
        return entry.getKey();

    }

    public static void main(String[] arg){
        //   John = 3
        //   Mike = 3
        //   Ricaro = 1
        //   Bob = 1
        //   ZORO = 1
        String[] votes = new String[]{"Zoro", "Mike",  "Bob","John", "Mike", "Ricado", "Mike", "John", "John" };
        //String[] votes = new String[]{ };
        HashMapTest test = new HashMapTest();
        System.out.println(test.findTheWinner(votes));
    }

}


