class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> catArr = new ArrayList<Integer>();
        //i refers to index at nums1, j refers to index at nums2
        int i=0;
        int j=0;
        int catLen = nums1.length+nums2.length;
        while (i<nums1.length || j<nums2.length) {
            if (i==nums1.length) {
                catArr.add(nums2[j]);
                j++;
            } 
            else if (j==nums2.length) {
                catArr.add(nums1[i]);
                i++;
            }
            else if (nums1[i]<=nums2[j]) {
                catArr.add(nums1[i]);
                i++;
            }
            else {
                catArr.add(nums2[j]);
                j++;
            }
        }
        if (catLen % 2 == 1) {
            return (double)catArr.get((catLen-1)/2);
        }
        return (double)(float)(catArr.get(catLen/2-1)+catArr.get(catLen/2))/2;
    }    
}
