import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        // double for-loop and a while loop, which would have a o(n^3) time complexity
        int N = nums.length;
        if (nums[N-1] < Integer.MIN_VALUE/4 || nums[0] > Integer.MAX_VALUE/4) return new ArrayList<>();  
        // i, j, k, l would be the index of a, b, c, d respectively
        for (int i=0; i<N-3; i++) {
            int a = nums[i];
            for (int j=i+1; j<N-2; j++) {
                int b = nums[j];
                int k = j+1;
                int l = N-1;
                // n is the target sum of c and d
                int new_target = target - a - b;
                while (k<l) {
                    int c = nums[k];
                    int d = nums[l];
                    int c_d = c+d;
                    if (d < Integer.MIN_VALUE/4) return res.stream().collect(Collectors.toList());
                    if (c_d > new_target) { 
                        l--;
                    } else if (c_d < new_target) {
                        k++;
                    } else {
                        List<Integer> quads = List.of(a, b, c, d);
                        if (!res.contains(quads)) res.add(quads);
                        while (nums[l-1]==d && k<l) l--;
                        while (nums[k+1]==c && k<l) k++;
                        l--;
                        k++;
                    }
                }
            }
        }
    
        return res.stream().collect(Collectors.toList());
    }

}
