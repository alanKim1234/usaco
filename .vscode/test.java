import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("First integer: ");
        int a = in.nextInt();
        System.out.print("Second integer: ");
        int b = in.nextInt();
        System.out.print("Enter a sentence: ");
        String s = in.nextLine();
        System.out.print("Enter your name: ");
        String n = in.next();
        String theRest = in.nextLine();
        System.out.println("a:" + a + " b:" + b + " s:" + s + " n:" + n + " theRest:" + theRest);
    }
}
