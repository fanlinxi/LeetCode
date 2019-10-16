package string;

import java.util.HashMap;

/**
 * @Description: 383. 赎金信(简单) 59 ms	36.9 MB
 * @Author: 無曦
 * @CreateDate: 2019/10/16 10:03
 */
public class RansomNote {

    public static void main(String[] args) {
        System.out.println(canConstruct(null, null));//true
        System.out.println(canConstruct("", ""));//true
        System.out.println(canConstruct("a", "b"));//false
        System.out.println(canConstruct("aa", "ab"));//false
        System.out.println(canConstruct("aa", "aab"));//true
        System.out.println(canConstruct("aa", "ab"));//false
        System.out.println(canConstruct("bg","efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj"));//true
    }

    /**
         给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，
                判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。
                如果可以构成，返回 true ；否则返回 false。
                (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)

         注意：
            你可以假设两个字符串均只含有小写字母。

        例子：
             canConstruct("a", "b") -> false
             canConstruct("aa", "ab") -> false
             canConstruct("aa", "aab") -> true

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/ransom-note
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct(String ransomNote, String magazine) {
        /**
         * 解题思路
         *      判空
         *      循环 ransomNote
         *          循环 magazine
         *              判断是否有 ransomNote 的元素
         *                  若有
         *                      判断已记录索引值中是否有此值
         *                          若有跳过
         *                          没有
         *                              判断索引值集合是否与 ransomNote 长度相等
         *                                  相等 返回true
         *                                  不相等 记录索引值
         *              没有继续循环
         *注 注意判断条件 判断条件的先后与多少会影响性能
         */

        if((null == ransomNote && null == magazine) || ransomNote.length() == 0 || ransomNote.equals(magazine)){
            return true;
        }

        char[] ransomNoteChars = ransomNote.toCharArray();
        char[] magazineChars = magazine.toCharArray();
        HashMap<Integer, String> stringIntegerHashMap = new HashMap<>();

        for(int i = 0;i < ransomNoteChars.length; i++){
            char ransomNoteChar = ransomNoteChars[i];

            for(int j = 0;j < magazineChars.length; j++){
                char magazineChar = magazineChars[j];

                if(ransomNoteChar == magazineChar && !stringIntegerHashMap.containsKey(j)){
                    stringIntegerHashMap.put(j,String.valueOf(magazineChar));

                    if(ransomNoteChars.length ==  stringIntegerHashMap.size()){
                        return true;
                    }

                    break;
                }
            }

        }

        return false;

    }

}