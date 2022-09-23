impl Solution {
    pub fn find_length(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        let mut max_len: i32 = 0;
        let len1 = nums1.len() as i32;
        let len2 = nums2.len() as i32;
        for ind_diff in -len1+1..len1 {
            let overlap_len: i32 = len1 - ind_diff.abs();
            if max_len >= overlap_len { continue };
            let i1_base: i32 = if ind_diff>0 { len1-overlap_len } else { 0 }; 
            let i2_base: i32 = if ind_diff>=0 { 0 } else { -ind_diff };
            let mut matched_len: i32 = 0;
            let mut i1: i32 = i1_base;
            let mut i2: i32 = i2_base;
            while i1<len1 && i2<len2 {
                if nums1[i1 as usize] == nums2[i2 as usize] { 
                    matched_len+=1; 
                } else {
                    if matched_len > max_len { max_len=matched_len };
                    matched_len = 0;
                }
                i1+=1;
                i2+=1;
            }
            if matched_len > max_len { max_len = matched_len };
            if max_len==std::cmp::min(len1, len2) { return max_len };
        }
        return max_len;
    }
}
