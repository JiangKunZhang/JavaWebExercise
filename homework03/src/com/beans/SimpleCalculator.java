package com.beans;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/11 23:08
 */
public class SimpleCalculator {

    private float first;
    private float second;
    private String  operator;
    private float result;

    public SimpleCalculator() {}

    public float getFirst() {
        return first;
    }

    public void setFirst(float first) {
        this.first = first;
    }

    public float getSecond() {
        return second;
    }

    public void setSecond(float second) {
        this.second = second;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
    public float calculate(float first,float second,String operator)
    {
        switch(operator)
        {
            case "+": result=first+second;break;
            case "-": result=first-second;break;
            case "*": result=first*second;break;
            case "/": result=first/second;break;
            default: ;break;
        }
        return result;
    }

}