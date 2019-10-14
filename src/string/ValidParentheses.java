package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Description: 20. 有效的括号(简单)(百度过...)      3 ms	34.1 MB
 * @Author: 無曦
 * @CreateDate: 2019/10/14 09:40
 */
public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid(""));//true
        System.out.println(isValid(null));//false
        System.out.println(isValid("("));//false
        System.out.println(isValid("()"));//true
        System.out.println(isValid("()[]{}"));//true
        System.out.println(isValid("(]"));//false
        System.out.println(isValid("([)]"));//false
        System.out.println(isValid("{[]}"));//true
        System.out.println(isValid("([]"));//false
        System.out.println(isValid("([])"));//true
        System.out.println(isValid("[])"));//false
        System.out.println(isValid("(([]){[]})"));//true
    }

    /**
         给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

         有效字符串需满足：
             左括号必须用相同类型的右括号闭合。
             左括号必须以正确的顺序闭合。
             注意空字符串可被认为是有效字符串。

         示例 1:
             输入: "()"
             输出: true


         示例 2:
             输入: "()[]{}"
             输出: true


         示例 3:
             输入: "(]"
             输出: false


         示例 4:
             输入: "([)]"
             输出: false

         示例 5:
             输入: "{[]}"
             输出: true

         来源：力扣（LeetCode）
         链接：https://leetcode-cn.com/problems/valid-parentheses
         著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        /**
         * 解题思路
         *      首先创建一个map(可用其他代替)
         *          [   ]
         *          (   )
         *          {   }
         *      然后创建一个栈
         *      转换字符串为 char数组
         *      循环数组
         *      每出现一个左括号 把该左括号放入栈中(由于栈的特性是先进后出 所以说栈顶的元素是最后一次添加的括号)
         *      每出现一个右括号 用栈顶的左括号作为key从map中取值 取出对应的右括号 进行匹配如果符合那么删除栈顶的元素
         *      循环结束后 如果一切匹配成功 那么栈应该是空的 没有元素
         *          若有说明某一次匹配失败 那么该字符串不符合规则
         */
        //判空
        if(s == null){
            return false;
        }

        if("".equals(s)){
            return true;
        }

        //判断是否为偶数长度
        if(s.length()%2 != 0){
            return false;
        }

        Map<Character,Character> map = new HashMap<>();
        map.put('[',']');
        map.put('(',')');
        map.put('{','}');

        Stack<Character> stack = new Stack<>();

        char[] ch = s.toCharArray();

        for(Character c : ch){
            //判断是左括号还是右括号
            if(map.keySet().contains(c)){
                stack.push(c);//添加元素
            }else{
                //判断栈是否不为空(在右括号匹配完成之前栈中最少得有一个元素) & 栈顶左括号对应的右括号与循环右括号匹配
                if(!stack.empty() && map.get(stack.peek())==c) { //stack.peek()取出栈顶元素
                    stack.pop();//删除元素(栈顶)
                }else {
                    return false;
                }
            }
        }

        return stack.empty();
    }


}