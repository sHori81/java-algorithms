import java.util.*;

public class MyGraphTest {
    public static void main(String[] args){
        MyGraph mygraph = new MyGraph();
        mygraph.readFromFile(inputFile());
        outputEdgesToConsole(mygraph.getEdges(returnid()));
    }

    public static String inputFile(){
        Scanner sc = new Scanner(System.in);
        String inputfilename;
        while (true) {
            try {
                System.out.print("ファイル名を入力してください");
                inputfilename = sc.next();
                break;
            } catch (InputMismatchException ex) {
                System.out.println("ファイル名以外が入力されました");
                sc.next();
            }
        }
        return inputfilename;
    }

    public static int returnid(){
        Scanner sc = new Scanner(System.in);
        int inputidname = 0;
        while (true) {
            try {
                System.out.print("頂点番号を入力してください");
                inputidname = sc.nextInt();
                break;
            } catch (InputMismatchException ex) {
                System.out.println("頂点番号以外が入力されました");
                sc.next();
            }
        }
        return inputidname;
    }

    private static  void outputEdgesToConsole(LinkedList<MyEdge> linkedList){
        for(int i = 0; i<linkedList.size(); i++){
            System.out.println(linkedList.get(i));
        }
    }




}
