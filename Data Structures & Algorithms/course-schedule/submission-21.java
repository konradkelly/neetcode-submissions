public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> courseMap = new HashMap<>();

        for (int[] prereq : prerequisites) {
            if (!courseMap.containsKey(prereq[0])) {
                courseMap.put(prereq[0], new ArrayList<>());
            }
            courseMap.get(prereq[0]).add(prereq[1]);
        }

        Set<Integer> visiting = new HashSet<>();
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            if (!canFinish(i, courseMap, visiting, visited)) return false;
            }

            return true;
        }


    private boolean canFinish(int course, Map<Integer, List<Integer>> courseMap,
                        Set<Integer> visiting, Set<Integer> visited) {
        if (visiting.contains(course)) return false;
        if (visited.contains(course)) return true;

        visiting.add(course);

        for (int prereq : courseMap.getOrDefault(course, new ArrayList<>())) {
            if (!canFinish(prereq, courseMap, visiting, visited)) {
                return false;
            }
        }

            visiting.remove(course);
            visited.add(course);
            return true;
        }    
    }