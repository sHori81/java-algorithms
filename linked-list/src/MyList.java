import java.util.*;

public class MyList {

    public  void makeList(LinkedList<Integer> linkedList){
             linkedList.add(input());
    }

    public void insert(int x, LinkedList<Integer> linkedList){
        int size = linkedList.size();
        for(int i =0; i < size; i++){
            if(linkedList.get(i) >= x){
                linkedList.add(i, x);
                break;
            }
        }
        if(size == linkedList.size()){
            linkedList.add(x);
        }
    }

    public void delete(int x, LinkedList<Integer> linkedList){
        for(int i = 0; i < linkedList.size(); i++){
            if(x == linkedList.get(i)){
                linkedList.remove(i);
                i = i-1;
            }

        }
    }

    public void output(LinkedList<Integer> linkedList){
        for(int i = 0; i< linkedList.size(); i++) {
            System.out.print(linkedList.get(i) + " ");
        }
        System.out.print("\n");
    }

    public static int input() {
        Scanner sc = new Scanner(System.in);
        int num = 0;
        while (true) {
            try {
                System.out.print("整数を入力してください:");
                num = sc.nextInt();
                break;
            } catch (InputMismatchException ex) {
                System.out.println("整数以外が入力されました");
                sc.next();
            }
        }
        return num;
    }
}