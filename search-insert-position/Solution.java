import java.util.Arrays;
import java.util.Collections;

public class Solution {
    //using existing api
    public static int searchInsert(int[] nums, int target) {
        int pos = Collections.binarySearch(Arrays.stream(nums).boxed().toList(), target);
        if (pos > -1)
            return pos;
        return ~pos;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[] { 1, 2 }, 2));
    }
}