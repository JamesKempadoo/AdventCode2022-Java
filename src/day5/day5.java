package day5;

import ultils.fileReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class day5 {
    public static String run1(List<String> x){
        List<Stack<Character>> stacks = createStacks(x);
        for (String line: x){
            String[] y = getStrings(line);
            if (y == null) continue;
            //move 1 from 8 to 4
            for (int i = 0; i < Integer.parseInt(y[0]); i++){
                Character z = stacks.get(Integer.parseInt(y[1]) - 1).pop();
                stacks.get(Integer.parseInt(y[2])-1).add(z);
            }
        }
        return getString(stacks);

    }

    private static String[] getStrings(String line) {
        if (!line.contains("move")){
            return null;
        }
        return line.replaceAll("move[^0-9]", "")
                .replaceAll("from ", "")
                .replaceAll("to ", "").split(" ");
    }

    private static String getString(List<Stack<Character>> stacks) {
        StringBuilder s = new StringBuilder();
        for (Stack<Character> stack: stacks){
            s.append(stack.peek());
        }
        return s.toString();
    }

    private static List<Stack<Character>> createStacks(List<String> x) {
        List<Stack<Character>> stacks = new ArrayList<>();
        for (int i = 1; i<35;i+=4){
            List<Character> stackCreator = new ArrayList<>();
            for (String line: x){
                if (line.contains(" 1   2   3   4   5   6   7   8   9")){
                    break;
                }
                if (line.charAt(i)==' '){
                    continue;
                }
                stackCreator.add(line.charAt(i));
            }
            Stack<Character> stackAddition = new Stack<>();
            Collections.reverse(stackCreator);
            stackAddition.addAll(stackCreator);
            stacks.add(stackAddition);
        }
        return stacks;
    }

    public static String run2(List<String> x){
        List<Stack<Character>> stacks = createStacks(x);
        for (String line: x){
            String[] y = getStrings(line);
            if (y == null) continue;
            List<Character> characters = new ArrayList<>();
            for (int i = 0; i < Integer.parseInt(y[0]); i++){
                Character z = stacks.get(Integer.parseInt(y[1]) - 1).pop();
                characters.add(z);
            }
            Collections.reverse(characters);
            stacks.get(Integer.parseInt(y[2])-1).addAll(characters);
        }
        return getString(stacks);
    }


    public static void main(String[] args) {
        List<String> x = fileReader.inputFileToStringList("InputFiles/day5input1");
        System.out.println(run1(x));
        System.out.println(run2(x));
    }
}
