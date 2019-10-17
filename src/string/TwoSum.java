package string;

import java.util.Arrays;

/**
 * @Description: 1. 两数之和 66 ms 36.3 MB
 * @Author: 無曦
 * @CreateDate: 2019/10/17 16:54
 */
public class TwoSum {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15},9)));
    }

    /**
         给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
            你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

         示例:
             给定 nums = [2, 7, 11, 15], target = 9
             因为 nums[0] + nums[1] = 2 + 7 = 9
             所以返回 [0, 1]

         来源：力扣（LeetCode）
         链接：https://leetcode-cn.com/problems/two-sum
         著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {

        /**
         * 解题思路
         *      循环数组
         *          获取当前值
         *          循环数组
         *              获取当前值
         *              判断外层循环与内层的值相加是否等于 target 且 不是同一个值
         *                  是    返回索引数组
         *                  不是  继续循环
         */
        for(int i = 0;i < nums.length;i++){
            int num = nums[i];

            for(int j = 0;j < nums.length;j++){
                int n = nums[j];
                if(i != j && (target - num == n)){
                    return new int[]{i, j};
                }

            }
        }

        return new int[]{-1, -1};
    }

}