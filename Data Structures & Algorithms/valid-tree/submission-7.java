class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> neighborsMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            neighborsMap.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            neighborsMap.get(a).add(b);
            neighborsMap.get(b).add(a);
        }

        Set<Integer> visited = new HashSet<>();

        if (!dfs(0, -1, visited, neighborsMap)) {
            return false;
        }

        return visited.size() == n;
    }

    private boolean dfs(int node, int parent, Set<Integer> visited, Map<Integer, List<Integer>> neighborsMap) {
        if (visited.contains(node)) return false;
        
        visited.add(node);

        for (int neighbor : neighborsMap.get(node)) {
            if (neighbor == parent) {
                continue;
            }

            if (!dfs(neighbor, node, visited, neighborsMap)) {
                return false;
            }
        }
        return true;
    }
}
