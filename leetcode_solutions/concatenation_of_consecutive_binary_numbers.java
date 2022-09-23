class Solution {
    public int concatenatedBinary(int n) {
        final long modulo = (long)(1e9+7);
        long result = 0;
        // records the number of binary digits that we would need to shift left for each decimal number 
        int leftshift_bits = 0;
        for (int i=1; i<=n; i++) {
            if ((i & (i-1)) == 0) leftshift_bits++; // arithmetic comparison operator "==" has a higher priority compared to bitwise comparison operator
            result = ((result << leftshift_bits) + i) % modulo; // shift operators have less priority than the additive
        }
        return (int)result;
    }
}
