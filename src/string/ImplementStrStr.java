package string;

/**
 * @Description: 28. 实现 strStr()(简单)    272 ms	37 MB
 * @Author: 無曦
 * @CreateDate: 2019/10/14 10:54
 */
public class ImplementStrStr {

    public static void main(String[] args) {
        System.out.println(strStr(null, "bba"));//-1
        System.out.println(strStr("aaaaa", null));//-1
        System.out.println(strStr("aaaaa", ""));//0
        System.out.println(strStr("aaaaa", "aaaaaaa"));//-1
        System.out.println(strStr("hello", "ll"));//2
        System.out.println(strStr("aaaaa", "bba"));//-1
        System.out.println(strStr("aaaba", "baa"));//-1
        System.out.println(strStr("mississippi", "issip"));//4
    }


    /**
        实现 strStr() 函数。

         给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

         示例 1:

         输入: haystack = "hello", needle = "ll"
         输出: 2
         示例 2:

         输入: haystack = "aaaaa", needle = "bba"
         输出: -1
         说明:

         当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

         对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。

         来源：力扣（LeetCode）
         链接：https://leetcode-cn.com/problems/implement-strstr
         著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        /**
         * 解题思路
         *      简单来说，实现一个indexof()
         *      给定两个字符串返回一个字符串在另一个字符串的索引位置 如果没有则返回-1
         *      两个字符串转换为 char 数组
         *      循环母数组(注 要的是第一次出现的索引位置)
         *          匹配子数组中的第一个字符 若相等 记录索引位置 然后匹配子数组中的第二个字符 直到最后一个字符
         *          若全部匹配这说明母字符中有子字符 记录的索引位置就是第一次出现的位置
         *              若匹配失败返回-1
         *                  判断是否为全部匹配失败
         *
         */
        //匹配失败索引
        final int failindex = -1;

        //判空
        if(haystack == null || needle == null){
            return failindex;
        }

        //判断空字符串
        if("".equals(needle)){
            return 0;
        }

        //判断字符串长度
        if(needle.length() > haystack.length()){
            return failindex;
        }

        //返回索引
        int index = -1;

        char[] haystackChars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();

        //循环母数组
        for (int i = 0; i < haystackChars.length; i++) {
            //判断子数组第一个元素是否等于当前循环索引
            if(needleChars[0] == haystackChars[i]){
                index = i;

                //循环子数组
                int fl = 1;
                for (int j = 1; j < needleChars.length; j++) {
                    //判断是否有索引越界的情况(有则返回-1)
                    if((i + fl) >= haystackChars.length){
                        index = failindex;
                        break;
                    }else {
                        //判断是否有匹配失败的情况(有返回-1)
                        if(needleChars[j] != haystackChars[i + fl]){
                            index = failindex;
                            break;
                        }
                    }
                    fl++;
                }
            }

            //母数组循环完毕 若index为-1说明 子数组前N个元素出现在母数组的i位置 但子数组并未完全匹配 或索引越界 或匹配失败 继续循环匹配 直到母数组最后一个元素
            //              若index不为-1说明 完全匹配成功
            if(index != -1){
                break;
            }
        }

        return index;
    }

}