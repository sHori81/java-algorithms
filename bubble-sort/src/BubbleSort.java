import java.util.*;

public class BubbleSort {
    public static void sort(ArrayList<Integer> arrayList){
        for(int i=0; i< arrayList.size() - 1; i++){
            for(int j=0; j< arrayList.size() - i -1 ; j++){

                int le = arrayList.get(j);
                int ri = arrayList.get(j+1);

                if(le > ri){
                   arrayList.set(j, ri);
                   arrayList.set(j+1, le);
                }
            }
        }
    }
}
