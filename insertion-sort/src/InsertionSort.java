import java.util.ArrayList;

public class InsertionSort {

    public static void sort(ArrayList<Integer> arrayList){
        for(int i = 0; i < arrayList.size(); i++){
            for(int j = 0; j < i; j++){
                if(arrayList.get(j) > arrayList.get(i)){
                    arrayList.add(j, arrayList.get(i));
                    arrayList.remove(i+1);
                    break;
                }
            }
        }
    }
}
