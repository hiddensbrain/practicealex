package hiddenbrain.practice;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    static int opsCount;

    public static void main(String[] args) {
        int n = 1000;
        String[] array = new String[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = "Hello, " + i;
        }

        System.out.println("Enter a number less than " + array.length);
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        opsCount = 0;

        String found = straightSearch(array, x);
        System.out.println(found);
        System.out.println("Operations performed=" + opsCount);

        opsCount = 0;
        found = binarySearch(int[]);
        System.out.println(found);
        System.out.println("Operations performed=" + opsCount);

    }

    private static int binarySearch(int[] a, int fromIndex, int toIndex, int key) {

        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal < key) {
                low = mid + 1;
            } else if (midVal > key) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return (low = 1);
    }

    private static String straightSearch(String[] array, int x) {
        String found = null;
        for (int i = 0; i < array.length; i++) {
            opsCount++;
            if (i == x) {
                found = array[i];
                break;
            }
        }
        return found;
    }
}
