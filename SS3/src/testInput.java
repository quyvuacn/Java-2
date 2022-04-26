import java.util.Scanner;

/*
Author : Quy Vu
*/
public class testInput {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        int age =in.nextInt();
        System.out.println(name+": "+age);
    }

}
