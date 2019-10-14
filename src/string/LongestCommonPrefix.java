package string;

/**
 * @Description: 14. 最长公共前缀(简单)     5 ms	37.3 MB
 * @Author: 無曦
 * @CreateDate: 2019/10/12 9:34
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strArr1 = {"flower","flow","flight"};//正常情况
        String[] strArr2 = {"dog","racecar","car"};//需要考虑没有公共前缀
        String[] strArr3 = {"a"};//需要考虑只有一个元素怎么办
        String[] strArr4 = {};//需要考虑空数组怎么办
        String[] strArr5 = {"aca","cba"};//需要考虑没有公共前缀(与事例2执行结果不同 需要加个判断)

        System.out.println(longestCommonPrefix(strArr1));
        System.out.println(longestCommonPrefix(strArr2));
        System.out.println(longestCommonPrefix(strArr3));
        System.out.println(longestCommonPrefix(strArr4));
        System.out.println(longestCommonPrefix(strArr5));
    }


    /**
        编写一个函数来查找字符串数组中的最长公共前缀。

         如果不存在公共前缀，返回空字符串 ""。

         示例 1:
             输入: ["flower","flow","flight"]
             输出: "fl"


         示例 2:
             输入: ["dog","racecar","car"]
             输出: ""
             解释: 输入不存在公共前缀。
             说明:
                 所有输入只包含小写字母 a-z 。
         来源：力扣（LeetCode）
         链接：https://leetcode-cn.com/problems/valid-parentheses
         著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        /**
         * 解题思路
         *      获取数组 长度最小元素 的值和长度
         *      循环数组判断 长度最小元素 是否为公共前缀
         *          若不是 长度最小元素 减去最后一个字符 继续判断
         */
        //返回值
        String minString = "";

        //判断是否为空
        if(strs.length == 0){
            return minString;
        }

        //获取 长度最小元素 的值和长度
        int minStringLength = strs[0].length();
        minString = strs[0];
        for (String str : strs) {
            int length = str.length();
            if(length < minStringLength){
                minStringLength = length;
                minString = str;
            }
        }

        //循环判断元素
        for(int i = 0;i < strs.length;i++){
            for (String str : strs) {
                //判空
                if(!minString.equals("")){
                    if(!str.startsWith(minString.substring(0,minStringLength))){
                        minStringLength -= 1;
                        minString = minString.substring(0,minStringLength);
                    }
                    if(minString.length() == 1 && !str.startsWith(minString.substring(0,minStringLength))){
                        minString = "";
                        break;
                    }
                }
            }
        }


        return minString;
    }


}