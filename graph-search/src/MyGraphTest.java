import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class MyGraphTest {
    public static void main(String[] args){
        MyGraph.readFromFile(inputFile());
        int st = returnid();
        System.out.print("幅優先探索:");
        outputPointsTOConsole(MyGraph.BSF(st, 0));
        System.out.print("\n" + "深さ優先探索:");
        outputPointsTOConsole(MyGraph.BSF(st, 1));


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

    private static void outputPointsTOConsole(ArrayList<Integer> arrayList){
        for(int i = 0; i<arrayList.size(); i++){
            System.out.print(arrayList.get(i)+ " ");
        }
    }




}
