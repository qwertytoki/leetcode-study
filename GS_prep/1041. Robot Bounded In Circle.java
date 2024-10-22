
class Solution {

    public boolean isRobotBounded(String instructions) {
        // 0:north,1:east,2:south,3:west
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int index = 0; // start from north;
        int x = 0, y = 0;
        for (char c : instructions.toCharArray()) {

            // これとか知ってないと浮かばない
            if (c == 'R') {
                index = (index + 1) % 4;
            } else if (c == 'L') {
                index = (index + 3) % 4;
            } else {
                x += directions[index][0];
                y += directions[index][1];
            }
        }

        return (x == 0 && y == 0) || index != 0;
    }
}
