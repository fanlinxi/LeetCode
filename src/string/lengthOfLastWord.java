package string;

/**
 * @Description: 58. 最后一个单词的长度(简单) 5ms	 35.9MB
 * @Author: 無曦
 * @CreateDate: 2019/10/15 10:06
 */
public class lengthOfLastWord {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord(null));//0
        System.out.println(lengthOfLastWord(""));//0
        System.out.println(lengthOfLastWord(" "));//0
        System.out.println(lengthOfLastWord("Hello World"));//5
    }


    /**
         给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。

         如果不存在最后一个单词，请返回 0 。

         说明：一个单词是指由字母组成，但不包含任何空格的字符串。

         示例:
             输入: "Hello World"
             输出: 5

         来源：力扣（LeetCode）
         链接：https://leetcode-cn.com/problems/length-of-last-word
         著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public static int lengthOfLastWord(String s) {
        /**
         * 解题思路
         *      分组 计算最后一个元素的长度即可
         *      注意异常输入
         */
        //判空
        if(s == null || "".equals(s) || s.replaceAll(" ", "").length() == 0){
            return 0;
        }

        String[] split = s.split(" ");

        int length = split[split.length-1].length();

        return length;
    }

}