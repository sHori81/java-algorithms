import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class MyGraph {
    //一番外のリストのインデックスがスタートの頂点、そこにリストを作り、行先と重みを定義したMyEdgeを格納する
    static ArrayList<LinkedList<MyEdge>> EdgeSet = new ArrayList<>();
    static int points = 0;
    static int edges = 0;

    public static void readFromFile(String filename){
        try {
            File inputfile = new File(filename);
            Scanner sc = new Scanner(inputfile);

            points = sc.nextInt();
            edges = sc.nextInt();

            //各頂点に置ける辺の追加
            for (int i = 0; i < points; i++) {
                EdgeSet.add(new LinkedList<>());
            }

            if (points > 50) {
                System.out.println("頂点数は50以下である必要があります.");
                System.exit(0);
            }

            if (edges > 100) {
                System.out.println("辺の数は100以下である必要があります.");
                System.exit(0);
            }

            while (sc.hasNext()) {
                int st = sc.nextInt();
                int id = sc.nextInt();
                int weight = sc.nextInt();

                if (weight > 9999) {
                    System.out.println("辺の重みは1以上9999以下である必要があります");
                    System.exit(0);
                }

                EdgeSet.get(st).add(new MyEdge(id, weight));
                EdgeSet.get(id).add(new MyEdge(st, weight));
            }
        }catch (FileNotFoundException ex){
            System.out.println("ファイル" + filename + "は見つかりませんでした");
            System.exit(0);
        }
    }

    public static LinkedList<MyEdge> getEdges(int id){
        return EdgeSet.get(id);
    }

    public static ArrayList<Integer> BSF(int start, int x){
        ArrayList<Integer> Searching = new ArrayList<>();
        ArrayList<Integer> Searched = new ArrayList<>();

        Searching.add(start);
        int at = start;

        while(!Searching.isEmpty()) {
            if(x == 0) {
                at = Searching.getFirst();
                Searching.removeFirst();
            }else if(x == 1){
                at = Searching.getLast();
                Searching.removeLast();
            }

            if(!Searched.contains(at)){
                Searched.add(at);
            }

            for (MyEdge e : getEdges(at)) {
                if(!Searched.contains(e.id)){
                    Searching.add(e.id);
                }
            }
        }
        return(Searched);

    }


}
