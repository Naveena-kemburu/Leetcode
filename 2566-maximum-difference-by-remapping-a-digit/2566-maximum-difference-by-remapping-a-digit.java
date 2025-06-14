class Solution {
    public int minMaxDifference(int num) {
        String s = String.valueOf(num);
        int minVal = Integer.parseInt(s.replace(s.charAt(0), '0'));
        int maxVal = num;
        for (char c : s.toCharArray()) {
            if (c != '9') {
                maxVal = Integer.parseInt(s.replace(c, '9'));
                break;
            }
        }
        return maxVal - minVal;
    }
}
