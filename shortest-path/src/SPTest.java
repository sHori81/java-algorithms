import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SPTest {

    public static void main(String[] args){
        MyGraph mygraph = new MyGraph();
        ArrayList<Integer> pointsList = new ArrayList<>();
        String filename = inputFile();
        inputpoints(pointsList, mygraph.readFromFile(filename));
        mygraph.SPSearch(pointsList);
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

    public static void inputpoints(ArrayList<Integer> arrayList, Integer points){
        Scanner sc = new Scanner(System.in);
        int[] check = new int[points];
        while (true) {
            try {
                System.out.print("0以上"+ points +"以下の整数で始点番号を入力してください");
                int x = sc.nextInt();
                check[x] = 1;
                arrayList.add(x);
                break;
            } catch (InputMismatchException | IndexOutOfBoundsException ex) {
                System.out.println("それは入力できません");
                sc.next();
            }
        }
        while (true) {
            try {
                System.out.print("0以上"+ points +"以下の整数で終点番号を入力してください");
                int x = sc.nextInt();
                check[x] = 1;
                arrayList.add(x);
                break;
            } catch (InputMismatchException | IndexOutOfBoundsException ex) {
                System.out.println("それは入力できません");
                sc.next();
            }
        }
    }


}
