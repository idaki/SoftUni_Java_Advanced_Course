package LAB;

import java.util.*;

public class PB07_Cities_by_Continent_and_Country {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> continentMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            String continent = input[0];
            String country = input[1];
            String city = input[2];



            if (!continentMap.containsKey(continent)) {
                continentMap.put(continent,new LinkedHashMap<>() );
                continentMap.get(continent).put(country,new ArrayList<>());
                continentMap.get(continent).get(country).add(city);
            } else if(continentMap.get(continent).containsKey(country)){
                continentMap.get(continent).get(country).add(city);
            }else{
                continentMap.get(continent).put(country, new ArrayList<>());
                continentMap.get(continent).get(country).add(city);
            }
            }

        for (Map.Entry<String, LinkedHashMap<String,ArrayList<String>>> continentEntry: continentMap.entrySet()) {
            String continent = continentEntry.getKey();
            System.out.println(continent+":");
            for (Map.Entry<String, ArrayList<String>> countryEntry: continentEntry.getValue().entrySet()) {
                String country = countryEntry.getKey();
                ArrayList <String> cityList = countryEntry.getValue();
                String printCity = cityList.toString().replaceAll("[\\[\\]]","");

                System.out.println(" "+country+" -> "+ printCity ) ;
            }
        }


        }
    }

