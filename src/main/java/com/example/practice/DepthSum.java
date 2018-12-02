package com.example.practice;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.List;
import java.util.Stack;

public class DepthSum {

    static int stringToInt(String s) {
        char[] input = s.toCharArray();
        int result = 0, pow = input.length -1;
        for (Character ch : input) {
            /*result += (ch-48)* (Math.pow(10, pow));
            pow--;*/
            result = result * 10 + (ch -48);
        }

        return result;
    }

    public int depthSum (List<NestedInteger> input)
    {
        if (input == null || input.isEmpty()) {
            return 0;
        } else {
            return depthSumHelper(input, 1);
        }
    }

    private int depthSumHelper (List<NestedInteger> input, int depth)
    {
        int mySum = 0;
        for (NestedInteger item : input) {
            if (item.isInteger()) {
                mySum += depthSumHelper(item.getList(), depth);
                depth++;
            } else {
                mySum += item.getInteger() * depth;
            }
        }
        return mySum;
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(stringToInt("1"));
    }

    public static int evalRPN(String[] tokens) {
        int a,b;
        Stack<Integer> S = new Stack<Integer>();
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine se = manager.getEngineByName("JavaScript");
        for (String s : tokens) {
            s.toCharArray();
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                b = S.pop();
                a = S.pop();
                try {
                    Object result = se.eval(a + s + b);
                    S.push((int)result);
                } catch (ScriptException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }else {
                S.add(Integer.parseInt(s));
            }
        }
        return (int)S.pop();
    }

     interface NestedInteger {
         boolean isInteger();

         Integer getInteger();

         List<NestedInteger> getList();
     }
}
