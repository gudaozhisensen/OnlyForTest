/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Cal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author anderson
 */
public class Cal {
    
    char[] ch;
    StringBuilder sb;
    
    Cal(String str) {
        sb = new StringBuilder(str);
        ch = str.toCharArray();
        init();
    }
    
    void init() {
        //先括號
        int start = 0;
        int end = 0;
        String lv_str = "";
        List list;
        while (sb.indexOf(")") > 1) {//只要還有括號就循環
            System.out.println("start_sb:" + sb);
            start = sb.lastIndexOf("(");
            lv_str = sb.substring(start + 1);//從最後一個左括號截取字符串
            end = lv_str.indexOf(")");
            lv_str = lv_str.substring(0, end);
//            sb.replace(start, end + start + 2, calculated(lv_str));//把括號內的運算替換成普通運算
            System.out.println("lv_str:" + lv_str);
            list = toSuffix(lv_str);
            sb.replace(start, end + start + 2, Double.toString(calculate(list)));//把括號內的運算替換成普通運算
            
            System.out.println("sb:" + sb);
//            break;
        }
        Iterator it = toSuffix(sb.toString()).iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println("");
        System.out.println(calculate(toSuffix(sb.toString())));

        //後乘除
        //再加減
    }
    
//    String calculated(String str) {
//        return str;
//    }
    
    double calculate(List<Object> list) {
        Stack<Double> stack = new Stack<Double>();
        for (Object obj : list) {
            if (obj instanceof Double) {
                stack.push((Double) obj);
            } else {
                double b = stack.pop();
                double a = stack.pop();
                if (obj.equals("+")) {
                    stack.push(a + b);
                }
                if (obj.equals("-")) {
                    stack.push(a - b);
                }
                if (obj.equals("*")) {
                    stack.push(a * b);
                }
                if (obj.equals("/")) {
                    stack.push(a / b);
                }
            }
        }
        return stack.pop();
    }
    
    List<Object> toSuffix(String s) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("+", 0);
        map.put("-", 0);
        map.put("*", 1);
        map.put("/", 1);
        List<Object> list = new ArrayList<Object>();
        String[] number = s.split("[^\\d]");
        for(Object o : number){
            System.out.println("o : "+o);
        }
        String[] operator = s.split("\\d+");
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < number.length; i++) {
            if (operator[i].length() != 0) {
                if (!stack.isEmpty() && map.get(operator[i]) <= map.get(stack.peek())) {//如果stack不為空，而且當前運算符優先級不高於stack內優先級
                    list.add(stack.pop());//把stack內符號彈出到list裡
                }
                stack.push(operator[i]);//如果stack是空，就把運算符push進去
            }
            list.add(Double.parseDouble(number[i]));
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }
    
    public static void main(String[] args) {
        new Cal("1+2+(3*(4+5)+6*7)");
    }
}
