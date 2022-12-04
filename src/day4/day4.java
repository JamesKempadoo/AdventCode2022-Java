package day4;

import ultils.fileReader;

import java.util.List;

public class day4 {
    public static int run1(List<String> x){
        int count = 0;
        for (String line : x){
            String[] f = line.split(",");
            String[] f1 = f[0].split("-");
            String[] f2 = f[1].split("-");
            if (ifStatement(f1,f2)){
                    count+=1;
            }
        }
        return count;
    }

    public static int run2(List<String> x){
        int count = 0;
        for (String line : x){
            String[] f = line.split(",");
            String[] f1 = f[0].split("-");
            String[] f2 = f[1].split("-");

            if ( ifStatementP2(f1,f2) || ifStatement(f1,f2)){
                count+=1;
            }
        }
        return  count;
    }

    public static boolean ifStatement(String[] f1, String[] f2){
        return (Integer.parseInt(f1[0])>=Integer.parseInt(f2[0]))
                &&(Integer.parseInt(f1[1])<=Integer.parseInt(f2[1]))
                ||
                (Integer.parseInt(f1[0])<=Integer.parseInt(f2[0]))  //2-8  //3-5
                        && Integer.parseInt(f1[1])>=Integer.parseInt(f2[1]);
    }

    public static boolean ifStatementP2(String[] f1, String[] f2){
        return (Integer.parseInt(f1[1]) >= Integer.parseInt(f2[0])
                && Integer.parseInt(f1[1]) <= Integer.parseInt(f2[1])) ||
                ( Integer.parseInt(f1[0]) <= Integer.parseInt(f2[1])
                        && Integer.parseInt(f1[1]) >= Integer.parseInt(f2[1]));
    }
    public static void main(String[] args) {
        List<String> x = fileReader.inputFileToStringList("InputFiles/day4input1");
        System.out.println(run1(x));
        System.out.println(run2(x));

    }
}
