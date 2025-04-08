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
    public static Class getClass (ArrayList<Class> classObjects, int period){
        ArrayList<Class> correctPeriodClasses = new ArrayList<>();
        for ( Class classObject : classObjects ){
            if ( classObject.getPeriod() == period ){
                correctPeriodClasses.add(classObject);
            }
        }
        int randomIdx = (int) (Math.random() * correctPeriodClasses.size());
        return correctPeriodClasses.get(randomIdx);
    }
}
