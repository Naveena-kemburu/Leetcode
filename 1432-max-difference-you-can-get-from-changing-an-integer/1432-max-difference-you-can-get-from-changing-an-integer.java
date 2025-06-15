class Solution {
    public int maxDiff(int num) {
        String s = String.valueOf(num);
        String a = s, b = s;

        for (char c : s.toCharArray()) {
            if (c != '9') {
                a = s.replace(c, '9');
                break;
            }
        }

        if (s.charAt(0) != '1') {
            b = s.replace(s.charAt(0), '1');
        } else {
            for (int i = 1; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c != '0' && c != '1') {
                    b = s.replace(c, '0');
                    break;
                }
            }
        }

        return Integer.parseInt(a) - Integer.parseInt(b);
    }
}
