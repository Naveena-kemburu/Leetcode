class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }

        List<Integer> list = new ArrayList<>();
        for (int f : freq) {
            if (f > 0) list.add(f);
        }

        Collections.sort(list);
        int n = list.size();
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int maxAllowed = list.get(i) + k;
            int deletions = 0;

            for (int j = 0; j < i; j++) {
                deletions += list.get(j);
            }

            for (int j = i + 1; j < n; j++) {
                if (list.get(j) > maxAllowed) {
                    deletions += list.get(j) - maxAllowed;
                }
            }

            ans = Math.min(ans, deletions);
        }

        return ans;
    }
}
