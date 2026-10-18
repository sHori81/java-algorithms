import java.util.LinkedList;

public class MyListTest {
    public static void main(String[] args){
        MyList myList = new MyList();
        LinkedList<Integer> List = new LinkedList<>();
        for(int i = 0; i < 3; i++){

            if(i ==0){
                System.out.println("リストを作ります");
                for(int j = 0; j < 10; j++){
                    myList.makeList(List);
                }
                myList.output(List);
            }

            if(i == 1){
                System.out.println("要素を挿入します");
                for(int j = 0; j < 10; j++){
                    myList.insert(MyList.input(), List);
                    myList.output(List);
                }
            }

            if(i == 2){
                System.out.println("要素を削除します");
                for (int j = 0; j < 10; j++) {
                    myList.delete(MyList.input(), List);
                    myList.output(List);
                }
            }
        }

    }
}
