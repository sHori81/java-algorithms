import java.io.*;
import java.util.*;

public class SortTest {

    private static void inputArrayListFromFile(String filename, ArrayList<Integer> arrayList){
        try{
            File inputfile = new File(filename);
            Scanner sc = new Scanner(inputfile);

            while(sc.hasNext()){
                int num = sc.nextInt();
                arrayList.add(num);
            }
        }catch(InputMismatchException ex){
            System.out.println("入力ファイルが不正です。");
            System.exit(0);
        }catch (FileNotFoundException ex) {
            System.out.println( filename + "は見つかりませんでした。");
            System.exit(0);
        }
    }

    private static void outputArrayListToConsole(ArrayList<Integer> arrayList){
        int a = String.valueOf(arrayList.getLast()).length();
        int b = String.valueOf(arrayList.getFirst()).length();
        int maxdegit = Math.max(a, b) + 1;

        for(int i = 0; i<arrayList.size(); i++){
            System.out.printf("%"+ maxdegit + "d", arrayList.get(i));
            if((i+1)% 10 == 0){
                System.out.print("\n");
            }
        }
    }

    public static void main(String[] args) {
        if(args.length == 0){
            System.out.println("ファイル名を指定してください");
            System.exit(0);
        }
        String filename = args[0];
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        inputArrayListFromFile(filename, arrayList);
        BubbleSort.sort(arrayList);
        outputArrayListToConsole(arrayList);
    }
}
