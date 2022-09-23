import java.lang.Math;

class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int max_len = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        // slide nums2 thourgh nums1 from left to right
        // $ind_diff indicates how many indeces is the head of $nums2 compared to the head pf $nums1
        // left: "-", right: "+"
        for (int ind_diff=-len1+1; ind_diff<=len1-1; ind_diff++) {
            int overlap_len = len1 - Math.abs(ind_diff);
            if (max_len >= overlap_len) continue; // no need to inspect
            int i1_base = ind_diff > 0 ? len1-overlap_len : 0;
            int i2_base = ind_diff >= 0 ? 0 : -ind_diff;
            int matched_len = 0;
            int i1 = i1_base;
            int i2 = i2_base;
            while(i1 < len1 && i2 < len2) {
                if (nums1[i1++]==nums2[i2++]) {
                    matched_len++;
                } else {
                    if (matched_len > max_len) max_len = matched_len;
                    matched_len = 0;
                }
            }
            if (matched_len > max_len) max_len = matched_len;
            if (max_len==Math.min(len1, len2)) return max_len;
        }
        return max_len;
    }
}
