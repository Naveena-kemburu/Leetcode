class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;

        // Reduce search space to only characters appearing at least k times
        List<Character> valid = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (freq[i] >= k) {
                valid.add((char)(i + 'a'));
            }
        }

        // BFS: Try all sequences up to length 7
        Queue<String> queue = new LinkedList<>();
        queue.add("");
        String res = "";

        while (!queue.isEmpty()) {
            String curr = queue.poll();
            for (char c : valid) {
                String next = curr + c;
                if (isKSubsequence(s, next, k)) {
                    queue.add(next);
                    // Update answer if longer or lexicographically larger
                    if (next.length() > res.length() || 
                       (next.length() == res.length() && next.compareTo(res) > 0)) {
                        res = next;
                    }
                }
            }
        }

        return res;
    }

    private boolean isKSubsequence(String s, String target, int k) {
        int i = 0, count = 0;
        for (char c : s.toCharArray()) {
            if (c == target.charAt(i)) {
                i++;
                if (i == target.length()) {
                    count++;
                    if (count == k) return true;
                    i = 0;
                }
            }
        }
        return false;
    }
}
