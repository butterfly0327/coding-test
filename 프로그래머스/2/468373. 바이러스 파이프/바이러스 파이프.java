import java.util.*;

class Solution {
    int n;
    int k;
    int answer;

    List<Edge>[] graph;

    // component[type][node] = 해당 type 파이프만 사용해서 node와 연결된 노드들
    BitSet[][] component;

    static class Edge {
        int to;
        int type;

        Edge(int to, int type) {
            this.to = to;
            this.type = type;
        }
    }

    public int solution(int n, int infection, int[][] edges, int k) {
        this.n = n;
        this.k = k;
        this.answer = 1;

        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int a = edge[0] - 1;
            int b = edge[1] - 1;
            int type = edge[2] - 1;

            graph[a].add(new Edge(b, type));
            graph[b].add(new Edge(a, type));
        }

        component = new BitSet[3][n];

        makeComponents();

        BitSet infected = new BitSet(n);
        infected.set(infection - 1);

        dfs(0, infected);

        return answer;
    }

    private void makeComponents() {
        for (int type = 0; type < 3; type++) {
            boolean[] visited = new boolean[n];

            for (int start = 0; start < n; start++) {
                if (visited[start]) {
                    continue;
                }

                BitSet set = new BitSet(n);
                ArrayList<Integer> nodes = new ArrayList<>();
                ArrayDeque<Integer> queue = new ArrayDeque<>();

                visited[start] = true;
                queue.offer(start);

                while (!queue.isEmpty()) {
                    int cur = queue.poll();

                    set.set(cur);
                    nodes.add(cur);

                    for (Edge edge : graph[cur]) {
                        if (edge.type != type) {
                            continue;
                        }

                        int next = edge.to;

                        if (visited[next]) {
                            continue;
                        }

                        visited[next] = true;
                        queue.offer(next);
                    }
                }

                for (int node : nodes) {
                    component[type][node] = (BitSet) set.clone();
                }
            }
        }
    }

    private void dfs(int depth, BitSet infected) {
        answer = Math.max(answer, infected.cardinality());

        if (answer == n) {
            return;
        }

        if (depth == k) {
            return;
        }

        for (int type = 0; type < 3; type++) {
            BitSet nextInfected = (BitSet) infected.clone();

            for (int node = infected.nextSetBit(0); node >= 0; node = infected.nextSetBit(node + 1)) {
                nextInfected.or(component[type][node]);
            }

            dfs(depth + 1, nextInfected);
        }
    }
}