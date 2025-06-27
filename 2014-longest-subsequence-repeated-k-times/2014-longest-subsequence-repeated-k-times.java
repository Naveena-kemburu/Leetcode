class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;

        List<Character> valid = new ArrayList<>();
        for (int i = 25; i >= 0; i--) {
            if (freq[i] >= k) {
                int times = freq[i] / k;
                for (int j = 0; j < times; j++) {
                    valid.add((char) ('a' + i));
                }
            }
        }

        res = "";
        dfs("", valid, s, k);
        return res;
    }

    String res;

    private void dfs(String curr, List<Character> valid, String s, int k) {
        if (curr.length() > 7) return;
        if (curr.length() > res.length() || (curr.length() == res.length() && curr.compareTo(res) > 0)) {
            if (isKSubsequence(s, curr, k)) {
                res = curr;
            }
        }

        for (char c : valid) {
            dfs(curr + c, valid, s, k);
        }
    }

    private boolean isKSubsequence(String s, String seq, int k) {
        int i = 0, count = 0;
        for (char c : s.toCharArray()) {
            if (c == seq.charAt(i)) {
                i++;
                if (i == seq.length()) {
                    count++;
                    if (count == k) return true;
                    i = 0;
                }
            }
        }
        return false;
    }
}

