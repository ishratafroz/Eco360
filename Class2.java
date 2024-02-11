package com.example.myloginpagedemo;
import java.io.Serializable;
public class Class2 {
    public  String str1;
    public  String str2;
    public String str3;
    public String str4; //public String str5;
    public Class2() { }
    public Class2(String s1, String s2,String s3,String s4) {
        this.str1 = s1; this.str2=s2; this.str3=s3; this.str4=s4; }
    public  String getS2() {
        return str2; }
    public void setS2(String s2) {
        this.str2 = s2; }
    public  String getS1() {
        return str1; }
    public void setS1(String s1) {
        this.str1 = s1; }
    public String getS4() {
        return str4;}
    public void setS4(String s4) {
        this.str4 = s4; }
    public String getS3() {
        return str3; }
    public void setS3(String s3) {
        this.str3 = s3; }
}