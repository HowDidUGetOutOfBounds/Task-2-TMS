package Lesson9;

import java.util.Scanner;

public class ShortTasks {
    public static boolean checkString(String s)
    {
        for (int i =0; i < s.length()/2; i++)
        {
            if(s.charAt(i) != s.charAt(s.length()-1-i))
            {
                return false;
            }
        }
        return true;
    }

    public static void checkPalindrom(){
        Scanner in = new Scanner(System.in);
        String toCheck = in.nextLine();
        if(checkString(toCheck)){
            System.out.println("Palindrom");
        }
        else
        {
            System.out.println("Not palindrom");
        }
    }

    public static void replaceAllChar(String character){
        Scanner in = new Scanner(System.in);
        String toCheck = in.nextLine();
        String[] words = toCheck.split(" ");

        for (int i = 0; i < words.length; i++)
        {
            if (words[i].toLowerCase().contains(character))
            {
                words[i] = "***";
            }
        }

        for (int i = 0; i < words.length ; i++) {
            System.out.print(words[i] + " ");
        }

    }

    public static void main(String[] args) {
        StringBuffer strBuffer = new StringBuffer("hello world!");
        strBuffer.replace(6,11,"Dambldoor");
        System.out.println(strBuffer);

    }
}
