import java.util.ArrayList;
import java.util.Objects;

public class QuickSort {

    public static void sort(ArrayList<Integer> arrayList, int le, int ri){

        if (le < ri) {

            int pivotIndex = partition(arrayList, le, ri);

            sort(arrayList, le, pivotIndex - 1);
            sort(arrayList, pivotIndex + 1, ri);
        }

    }

    private static int partition(ArrayList<Integer> arrayList, int le, int ri) {
        int pivot = arrayList.get(defpivot(le, ri));
        int i = le - 1;

        for (int j = le; j < ri; j++) {
            if (arrayList.get(j) <= pivot) {
                i = i + 1;

                int temp = arrayList.get(i);
                arrayList.set(i, arrayList.get(j));
                arrayList.set(j, temp);
            }
        }

        int temp = arrayList.get(i+1);
        arrayList.set(i+1, arrayList.get(ri));
        arrayList.set(ri, temp);

        return i + 1;
    }

    public static int defpivot(int le, int ri) {
        return ri;
    }
}
