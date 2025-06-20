class Solution {
    public int maxDistance(String s, int k) {
        int x = 0, y = 0;
        int maxDist = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == 'N') y++;
            else if (c == 'S') y--;
            else if (c == 'E') x++;
            else if (c == 'W') x--;

            int dist = Math.abs(x) + Math.abs(y);
            dist = Math.min(i + 1, dist + 2 * k);
            maxDist = Math.max(maxDist, dist);
        }

        return maxDist;
    }
}
