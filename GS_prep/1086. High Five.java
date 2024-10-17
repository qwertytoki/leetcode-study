
class Solution {

    public int[][] highFive(int[][] items) {
        TreeMap<Integer, Queue<Integer>> allScores = new TreeMap();
        for (int[] item : items) {
            int id = item[0];
            int score = item[1];
            if (!allScores.containsKey(id)) {
                allScores.put(id, new PriorityQueue<Integer>((a, b) -> b - a));
            }
            allScores.get(id).add(score);
        }

        List<int[]> result = new ArrayList<>();
        for (int id : allScores.keySet()) {
            int sum = 0;
            for (int i = 0; i < 5; i++) {
                sum += allScores.get(id).poll();
            }
            result.add(new int[]{id, sum / 5});
        }
        int[][] solution = new int[result.size()][];
        return result.toArray(solution);

    }
}
