package string;

/**
 * @Description: 125 验证回文串(简单)(百度过思路...) 8 ms	39 MB
 * @Author: 無曦
 * @CreateDate: 2019/10/15 10:52
 */
public class ValidPalindrome {

    public static void main(String[] args) {
//        System.out.println(isPalindrome(""));//true
//        System.out.println(isPalindrome(" "));//true
//        System.out.println(isPalindrome(null));//true
//        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));//true
//        System.out.println(isPalindrome("race a car"));//false
//        System.out.println(isPalindrome("Live on evasions? No I save no evil."));//false




//        System.out.println(isPalindromeNew("Live on evasions? No I save no evil."));//false
        System.out.println(isPalindromeNew("A man, a plan, a canal: Panama"));//true
    }


    /**
         给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

         说明：本题中，我们将空字符串定义为有效的回文串。

         示例 1:
             输入: "A man, a plan, a canal: Panama"
             输出: true

         示例 2:
             输入: "race a car"
             输出: false

         来源：力扣（LeetCode）
         链接：https://leetcode-cn.com/problems/valid-palindrome
         著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {//自己写的(超出时间限制,因为LeetCode给的倒数第二个事例长度高达几千而不是回文字符串)
        /**
         * 解题思路
         *      判空
         *      去空字符与转换为小写
         *      转换为char数组
         *      倒序循环数组
         *          如果元素为数字或小写字母 添加到一个字符串
         *          如果元素不为数字或小写字母   去除字符串中的这个元素
         *      判断原字符串与倒序字符串是否相等
         *          相等       true
         *          不相等     false
         */
        if(s == null || "".equals(s) || s.replaceAll(" ", "").length() == 0){
            return true;
        }

        s = s.toLowerCase().replaceAll(" ", "");

        char[] chars = s.toCharArray();
        String gnirtr = "";

        for(int i = chars.length-1;i >= 0; i--){
            char aChar = chars[i];
            if((aChar <= 127 && 97 <= aChar) || (aChar <= 57 && 48 <= aChar)){
                gnirtr += String.valueOf(aChar);
            }else {
                String s1 = String.valueOf(aChar);
                s = s.replaceAll("\\" + s1, "");
            }
        }


        if(s.equals(gnirtr)){
            return true;
        }else {
            return false;
        }

    }


    public static boolean isPalindromeNew(String s) {//上网查过其他人的思路自己写的
        /**
         * 解题思路
         *      判空
         *      转换为char数组
         *      设置两个指针
         *          left    正序
         *          right   倒序
         *      循环数组(left<rigth的情况下)
         *          如果left指针与right指针对应的元素(跳过非数字字母元素)相等 那么进行下一次循环
         *          若不相等 返回false
         *      好处     不用循环完整个数组(回文字符串走半个 或 到错误元素处停止) 且 不用替换数据
         *
         */
        //判断是否为空与空字符串
        if(s == null || s.length() < 2){
            return true;
        }

        char[] chars = s.toCharArray();
        int left = 0;
        int right  = chars.length -1;

        //到达中间点之前循环
        while (left < right){
            //判断是否为字母或数字 不是的话左指针+1
            if(!isNumberOrLetter(chars[left])){
                left++;
            //判断是否为字母或数字 不是的话右指针-1
            }else if(!isNumberOrLetter(chars[right])){
                right--;
            //判断是否相等 注意 需要统一换成小(大)写字母
            }else if(!String.valueOf(chars[left]).toLowerCase().equals(String.valueOf(chars[right]).toLowerCase())){
                return false;
            }else{
                //指针相加与相减
                left++;
                right--;
            }
        }

        return true;
    }

    /**
     * 判断是否为字母或数字
     * @param aChar
     * @return
     */
    public static boolean isNumberOrLetter(char aChar){
        if((aChar <= 127 && 97 <= aChar) || (aChar <= 57 && 48 <= aChar) || (aChar <= 90 && 65 <= aChar)){
            return true;
        }else {
            return false;
        }
    }

}