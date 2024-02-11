package com.example.myloginpagedemo;
import java.io.Serializable;
public class Class1 implements Serializable {
    private String s1;
    private int icon;
    public Class1() {
    }
    public Class1(String s1, int icon) {
        this.s1 =s1;
        this.icon =icon; }
    public String getS1() {
        return s1;
    }
    public void setS1(String s1) {
        this.s1 = s1;
    }
    public int getIcon() {
        return icon;
    }
    public void setIcon(int icon) {
        this.icon = icon;
    }
}