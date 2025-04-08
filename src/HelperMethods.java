import java.util.ArrayList;

public class HelperMethods {
    public static boolean allZero(ArrayList<Integer> arr) {
        for (int num : arr) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
    public static int sumOfArray(ArrayList<Integer> arr) {
        int total = 0;
        for (int num : arr) {
            total+=num;
        }
        return total;
    }
}
