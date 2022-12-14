package day1;

import ultils.fileReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class day1 {

    public static Integer run1(List<String> x){
        List<Integer> y = getIntegers(x);
        return y.get(y.size()-1);
    }


    public static Integer run2(List<String> x){
        List<Integer> y = getIntegers(x);
        return y.get(y.size()-1)+y.get(y.size()-2)+y.get(y.size()-3);
    }

    private static List<Integer> getIntegers(List<String> data) {
        List<Integer> listOfCalories = new ArrayList<>();
        int currentCalorie = 0;
        for (String line : data){
            if (line.equals("")){
                listOfCalories.add(currentCalorie);
                currentCalorie=0;
            }else {
                currentCalorie += Integer.parseInt(line);
            }
        }
        Collections.sort(listOfCalories);
        return listOfCalories;
    }


    public static void main(String[] args) {
        List<String> x = fileReader.inputFileToStringList("InputFiles/day1inputp1");
        System.out.println(run1(x));
        System.out.println(run2(x));
    }
}
