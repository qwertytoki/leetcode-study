
class Solution {

    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map = new TreeMap<>();
        for (int[] item : items) {
            int id = item[0];
            int score = item[1];
            if (!map.containsKey(id)) {
                map.put(id, new PriorityQueue<>((a, b) -> b - a));
            }
            map.get(id).add(score);
        }
        List<int[]> result = new ArrayList<>();

        for (int id : map.keySet()) {
            PriorityQueue<Integer> scores = map.get(id);
            int sum = 0;
            for (int i = 0; i < 5; i++) {
                sum += scores.poll();
            }
            result.add(new int[]{id, sum / 5});
        }
        return result.toArray(new int[result.size()][]);

    }
}
