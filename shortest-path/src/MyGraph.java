import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MyGraph {
    ArrayList<LinkedList<MyEdge>> EdgeSet = new ArrayList<>();
    int points = 0;
    int edges  = 0;

    //ファイルの読み込み
    public int readFromFile(String filename){
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
        return points;
    }

    //idを渡すとそれに隣接する頂点番号と重みを帰す
    public LinkedList<MyEdge> getEdges(int id){
        return EdgeSet.get(id);
    }

    public void SPSearch(ArrayList<Integer> arrayList) {
        int st = arrayList.get(0);
        int gl = arrayList.get(1);

        int[] dist = new int[points];
        int[] prev = new int[points];

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);
        dist[st] = 0;

        PriorityQueue<MyEdge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.offer(new MyEdge(st, 0));

        boolean[] visited = new boolean[points];
        visited[st] = true;

        while (!pq.isEmpty()) {
            MyEdge cur = pq.poll();
            int v = cur.id;

            if(v == gl) break;

            for (MyEdge e : getEdges(v)) {
                if (dist[e.id] > dist[v] + e.weight) {
                    dist[e.id] = dist[v] + e.weight;
                    prev[e.id] = v;

                    if(!visited[e.id]) {
                        pq.offer(new MyEdge(e.id, dist[e.id]));
                        visited[e.id] = true;
                    }
                }
            }
        }
        List<Integer> path = new ArrayList<>();

        for (int at = gl; at != -1; at = prev[at]) {
            path.add(at);
        }
        Collections.reverse(path);

        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            if (i < path.size() - 1) System.out.print(" ");
        }

        System.out.println();
        System.out.println(dist[gl]);
    }
}