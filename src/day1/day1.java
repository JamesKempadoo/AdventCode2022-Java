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

    private static List<Integer> getIntegers(List<String> x) {
        List<Integer> y = new ArrayList<>();
        int z = 0;
        for (String value : x){
            if (value.equals("")){
                y.add(z);
                z=0;
            }else {
                z += Integer.parseInt(value);
            }
        }
        Collections.sort(y);
        return y;
    }


    public static void main(String[] args) {
        List<String> x = fileReader.inputFileToStringList("InputFiles/day1inputp1");
        System.out.println(run1(x));
        System.out.println(run2(x));
    }
}
