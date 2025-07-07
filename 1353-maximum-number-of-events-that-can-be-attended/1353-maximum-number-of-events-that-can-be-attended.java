import java.util.*;

class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0, res = 0, day = 0, n = events.length;

        while (!pq.isEmpty() || i < n) {
            if (pq.isEmpty()) {
                day = events[i][0];
            }

            while (i < n && events[i][0] <= day) {
                pq.offer(events[i++][1]);
            }

            pq.poll();
            res++;
            day++;

            while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }
        }

        return res;
    }
}
