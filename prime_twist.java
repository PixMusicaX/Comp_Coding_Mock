import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            if (isPossible(X, Y)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    static boolean isPossible(int X, int Y) {
        if (X < Y) {
            return false;
        }
        if (X == Y) {
            return true;
        }
        for (int p = 2; p < X; p++) {
            if (isPrime(p)) {
                if (isPossible(X - p, Y)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
