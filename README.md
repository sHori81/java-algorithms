# Java Algorithms

大学の授業（計算機科学実験及演習）で、基本的なアルゴリズムとデータ構造をJavaで実装したものです。
各フォルダが1つの課題に対応しています。

| フォルダ | 内容 |
|---|---|
| [`bubble-sort/`](bubble-sort/) | バブルソート |
| [`insertion-sort/`](insertion-sort/) | 挿入ソート |
| [`merge-sort/`](merge-sort/) | マージソート |
| [`quick-sort/`](quick-sort/) | クイックソート（Lomutoの分割） |
| [`linked-list/`](linked-list/) | 単方向連結リスト |
| [`graph/`](graph/) | 重み付き無向グラフ（隣接リスト）をファイルから読み込む |
| [`graph-search/`](graph-search/) | グラフの幅優先探索・深さ優先探索 |
| [`shortest-path/`](shortest-path/) | ダイクストラ法による最短経路探索 |
| [`binary-search-tree/`](binary-search-tree/) | 二分探索木（インタフェースと `Branch` / `Leaf` による実装） |

## ソートの課題について

ソートの各フォルダには、テスト用の入力ファイルが入っています。

- `sample.txt`、`random.large.txt`：通常の入力・大きな入力
- `sorted.txt`、`samevalue.txt`、`one.txt`：整列済み・同じ値だけ・1要素といった境界のケース
- `string.txt`、`toomany.txt` など：数値でない入力や件数オーバーなどの異常な入力（エラー処理の確認用）

`SortTest.java` がファイルを読み込み、ソートして結果を出力します。

## 実行方法

```bash
cd quick-sort/src
javac *.java
java SortTest ../sample.txt
```

※ 引数の受け取り方は課題によって少しずつ違うので、各フォルダの `*Test.java` の `main` を確認してください。
