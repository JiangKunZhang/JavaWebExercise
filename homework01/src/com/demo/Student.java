package com.demo;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/4/19 23:25
 */

public class Student {
    private String sno;
    private String name;
    public Student(String sno, String name) {
        // TODO Auto-generated constructor stub
        this.sno=sno;
        this.name=name;
    }
    public String getSno() {
        return sno;
    }
    public void setSno(String sno) {
        this.sno = sno;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}