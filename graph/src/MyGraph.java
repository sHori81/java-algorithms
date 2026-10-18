import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MyGraph {
    //一番外のリストのインデックスがスタートの頂点、そこにリストを作り、行先と重みを定義したMyEdgeを格納する
    ArrayList<LinkedList<MyEdge>> EdgeSet = new ArrayList<>();

    public void readFromFile(String filename){
        try {
            File inputfile = new File(filename);
            Scanner sc = new Scanner(inputfile);

            int points = sc.nextInt();
            int edges = sc.nextInt();

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

                //各頂点に置ける辺の追加
                for (int i = 0; i < points; i++) {
                    EdgeSet.add(new LinkedList<>());
                }

                EdgeSet.get(st).add(new MyEdge(id, weight));
                EdgeSet.get(id).add(new MyEdge(st, weight));
            }
        }catch (FileNotFoundException ex){
            System.out.println("ファイル" + filename + "は見つかりませんでした");
            System.exit(0);
        }
    }

    public LinkedList<MyEdge> getEdges(int id){
        return EdgeSet.get(id);
    }
}
