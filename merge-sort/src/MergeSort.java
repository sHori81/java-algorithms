import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

public class MergeSort {

    public static void sort(ArrayList<Integer> arr) {
        if (arr.size() > 1) {
            int mid = (arr.size() / 2);
            ArrayList<Integer> left = split(arr, 0, mid - 1);
            ArrayList<Integer> right = split(arr, mid, arr.size() - 1);

            sort(left);
            sort(right);
            merge(arr, left, right);
        }

    }

    public static void merge(ArrayList<Integer> arr, ArrayList<Integer> left, ArrayList<Integer> right) {
        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {

            if (left.get(i) <= right.get(j)) {
                arr.set(k, left.get(i));
                i++;
                k++;
            } else {
                arr.set(k, right.get(j));
                j++;
                k++;
            }
        }

        while (i < left.size()) {
                arr.set(k, left.get(i));
                i++;
                k++;
        }

        while (j < right.size()) {
                arr.set(k, right.get(j));
                j++;
                k++;
        }
    }


    public static ArrayList<Integer> split(ArrayList<Integer> arr, int left, int right) {
        ArrayList<Integer> subList = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            subList.add(arr.get(i));
        }
        return subList;
    }

}

