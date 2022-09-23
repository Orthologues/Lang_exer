import java.util.*;
import java.util.stream.Collectors;

class Solution {
    
    private List<List<Integer>> twoDimIntegerList (List<List<Integer>> twoDimIntegerList) {
        return twoDimIntegerList.stream().distinct().collect(Collectors.toList());
    }
    
    public List<List<Integer>> threeSum(int[] nums) {
        int intArrLen = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();
        for (int lowIndex=0; lowIndex<(intArrLen-2); lowIndex++) {
            // if the smallest number in a triplet is larger than 0, there would be no more eligible triplets
            int smallNum = nums[lowIndex];
            int mediumIndex = lowIndex+1;
            int highIndex = intArrLen-1;
            if (smallNum > 0 || smallNum + nums[mediumIndex] > 0) return twoDimIntegerList(triplets);
            while (mediumIndex < highIndex) {
                int mediumNum = nums[mediumIndex];
                int bigNum = nums[highIndex];
                int triple_sum = smallNum + mediumNum + bigNum;
                if (triple_sum > 0) {
                    highIndex--;
                }
                else if (triple_sum < 0) {
                    mediumIndex++;
                }
                else {
                    triplets.add(List.of(smallNum, mediumNum, bigNum));
                    while (nums[highIndex]==nums[highIndex-1] && mediumIndex<highIndex) highIndex--;
                    while (nums[mediumIndex]==nums[mediumIndex+1] && mediumIndex<highIndex) mediumIndex++;
                    mediumIndex++;
                    highIndex--;
                }

            }
        }
        return twoDimIntegerList(triplets);
    }
    
}
