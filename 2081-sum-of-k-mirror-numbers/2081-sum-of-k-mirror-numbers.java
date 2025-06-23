class Solution {
    public long kMirror(int k, int n) {
        long sum = 0;
        int count = 0;
        int len = 1;

        while (count < n) {
            for (long i = (long)Math.pow(10, (len - 1) / 2); i < Math.pow(10, (len + 1) / 2); i++) {
                String half = Long.toString(i);
                String rev = new StringBuilder(half).reverse().toString();
                String full = half + (len % 2 == 0 ? rev : rev.substring(1));
                long num = Long.parseLong(full);
                if (isKPalindrome(num, k)) {
                    sum += num;
                    if (++count == n) return sum;
                }
            }
            len++;
        }

        return sum;
    }

    private boolean isKPalindrome(long num, int k) {
        String baseK = toBaseK(num, k);
        return baseK.equals(new StringBuilder(baseK).reverse().toString());
    }

    private String toBaseK(long num, int k) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % k);
            num /= k;
        }
        return sb.reverse().toString();
    }
}
