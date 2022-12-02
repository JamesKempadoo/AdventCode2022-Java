package day2;

import ultils.fileReader;

import java.util.List;

public class day2 {

    //A = Rock , B = Paper , C = Scissors
    //x = Rock , Y = Paper , Z = Scissors
    //win = 6 , draw = 3, lose = 0
    // Rock = 1, paper = 2, scissors = 3
    public static int run1(List<String> x){
        int totalScore = 0;
        for (String lines: x){
            int valueCheck = lines.charAt(2) - lines.charAt(0);
            if ((valueCheck==21 || lines.charAt(0)<lines.charAt(2)-23) && valueCheck!=25){
                totalScore = getTotalScore(totalScore, lines) +6 ;
            } else if (valueCheck==25 || lines.charAt(0)>lines.charAt(2)-23 ) {
                totalScore = getTotalScore(totalScore, lines);
            } else if (valueCheck==23){
                totalScore = getTotalScore(totalScore,lines) +3;
            }
        }
        return totalScore;
    }

    private static int getTotalScore(int totalScore, String lines) {
        if (lines.charAt(2)=='X'){
            totalScore +=1;
        } else if (lines.charAt(2)=='Y') {
            totalScore +=2;
        } else if (lines.charAt(2)=='Z') {
            totalScore +=3;
        }
        return totalScore;
    }


    //A = Rock , B = Paper , C = Scissors
    //X = Lose , Y = Draw , Z = Win
    //win = 6 , draw = 3, lose = 0
    // Rock = 1, paper = 2, scissors = 3
    //12091
    public static int run2(List<String> x){
        int totalScore = 0;
        for (String line : x){
            if (line.charAt(2)=='X'){
                if ((line.charAt(0)-66<0)){
                    totalScore+=3;
                } else {
                    totalScore+=line.charAt(0)-65;
                }
            } else if (line.charAt(2)=='Y') {
                totalScore +=line.charAt(0)-64 +3;

            } else if (line.charAt(2)=='Z') {
                totalScore +=6;
                if (line.charAt(0)-64>2){
                    totalScore+=1;
                } else {
                    totalScore+=line.charAt(0)-63;
                }
            }
        }
        return totalScore;
    }

    public static void main(String[] args) {
        List<String> x = fileReader.inputFileToStringList("InputFiles/day2input1");
        System.out.println(run1(x));
        System.out.println(run2(x));
    }
}
