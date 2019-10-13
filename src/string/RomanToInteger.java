package string;

/**
 * @Description: 13. 罗马数字转整数(简单)
 * @Author: 無曦
 * @CreateDate: 2019/10/11 15:10
 */
public class RomanToInteger {


    public static void main(String[] args) {
        System.out.println(romanToInt("III"));//3
        System.out.println(romanToInt("IV"));//4
        System.out.println(romanToInt("IX"));//9
        System.out.println(romanToInt("LVIII"));//58
        System.out.println(romanToInt("MCMXCIV"));//1994
    }


    /**
         罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。

            字符          数值
             I             1
             V             5
             X             10
             L             50
             C             100
             D             500
             M             1000
         例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

         通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，
         例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，
             所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
                 I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
                 X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
                 C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
             给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。

         示例 1:
             输入: "III"
             输出: 3


         示例 2:
             输入: "IV"
             输出: 4


         示例 3:
             输入: "IX"
             输出: 9


         示例 4:
             输入: "LVIII"
             输出: 58
             解释: L = 50, V= 5, III = 3.


         示例 5:
             输入: "MCMXCIV"
             输出: 1994
             解释: M = 1000, CM = 900, XC = 90, IV = 4.

         来源：力扣（LeetCode）
         链接：https://leetcode-cn.com/problems/valid-parentheses
         著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public static int romanToInt(String s) {
        /**
         * 解题思路
         *      匹配一个罗马数字添加对应阿拉伯数字
        *       判断是否有特殊格式的罗马数字
         *          若有  减去相应阿拉伯数字
         */
        Integer integer = 0;

        s = s.toUpperCase();
        for(int i = 0;i < s.length(); i++){
            char c = s.charAt(i);
            if(c == 'I'){
                integer += 1;
            }else if(c == 'V'){
                integer += 5;
            }else if(c == 'X'){
                integer += 10;
            }else if(c == 'L'){
                integer += 50;
            }else if(c == 'C'){
                integer += 100;
            }else if(c == 'D'){
                integer += 500;
            }else if(c == 'M'){
                integer += 1000;
            }
        }

        if(s.contains("IV") || s.contains("IX")){
            integer -= 2;
        }
        if(s.contains("XL") || s.contains("XC")){
            integer -= 20;
        }
        if(s.contains("CD") || s.contains("CM")){
            integer -= 200;
        }

        return integer;
    }

}
