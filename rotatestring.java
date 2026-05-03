import java.util.*;

public class Main {
    public static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        String doubled = s + s;
        return doubled.contains(goal);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string s: ");
        String s = sc.nextLine();

        System.out.print("Enter string goal: ");
        String goal = sc.nextLine();

        boolean result = rotateString(s, goal);
        
        if (result) {
            System.out.println("True - goal is a rotation of s");
        } else {
            System.out.println("False - goal is NOT a rotation of s");
        }

        sc.close();
    }
}