package day3;

import ultils.fileReader;

import java.util.*;

public class day3 {
    public static int run1(List<String> x){
        int sumOfItemTypes = 0;
        for (String line: x){
            List<Character> characters1 = new ArrayList<>();
            List<Character> characters2 = new ArrayList<>();
            for (int i = 0; i<line.length();i++){
                if (i<line.length()/2){
                    characters1.add(line.charAt(i));
                } else {
                    characters2.add(line.charAt(i));
                }
            }
            for (Character c : characters1){
                if (characters2.contains(c)){
                    sumOfItemTypes = getSumOfItemTypes(c, sumOfItemTypes);
                    break;
                }
            }
        }
        return sumOfItemTypes;
    }

    public static int run2(List<String> x){
        String abc = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        List<Set<Character>> characters = new ArrayList<>();
        int sumOfItemTypes = 0;
        for (int i = 0; i<x.size();i+=3){
            Set<Character> characters1 = new HashSet<>();
            addCharacters(x, i, characters1);
            Set<Character> characters2 = new HashSet<>();
            addCharacters(x, i + 1, characters2);
            Set<Character> characters3 = new HashSet<>();
            addCharacters(x, i + 2, characters3);
            for (int k = 0; k<abc.length();k++){
                if (characters1.contains(abc.charAt(k)) && characters2.contains(abc.charAt(k))
                        && characters3.contains(abc.charAt(k))){
                    sumOfItemTypes = getSumOfItemTypes(abc.charAt(k), sumOfItemTypes);
                }
            }
        }
        return sumOfItemTypes;
    }

    private static int getSumOfItemTypes(char abc, int sumOfItemTypes) {
        if (Character.isLowerCase(abc)){
            sumOfItemTypes +=Character.getNumericValue(abc)-9;
        }else {
            sumOfItemTypes +=Character.getNumericValue(abc)+17;
        }
        return sumOfItemTypes;
    }

    private static void addCharacters(List<String> x, int i, Set<Character> characters) {
        for (int j = 0; j< x.get(i).length(); j++){
            characters.add(x.get(i).charAt(j));
        }
    }
    public static void main(String[] args) {
        List<String> x = fileReader.inputFileToStringList("InputFiles/day3input1");
        System.out.println(run1(x));
        System.out.println(run2(x));
    }
}
