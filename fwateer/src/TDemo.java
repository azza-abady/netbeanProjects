

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author azza
 */
interface Min{}
class A{
public void blast()throws InterruptedException{
throw new InterruptedException();
}
}
class B extends A {
public void blast() throws NumberFormatException{
throw new NumberFormatException();
}
}
class C extends B{}

public class TDemo extends Thread {
 
  public synchronized void run(){
      System.out.println(Thread.currentThread().getName()+" ");
  }
    public static void main(String[] args) throws Exception{
        System.out.println(Thread.currentThread().getName()+" ");
        TDemo s=new TDemo();
        s.start();
//        NavigableMap<String,Integer> nav=new TreeMap<String,Integer>();
//        nav.put("one",1);
//        nav.put("two",2);
//        nav.put("three",3);
//        nav.put("four",4);
//        nav.put("five",5);
//        nav.put("six",6);
//    String []ob=new String[]{
//    nav.lowerKey("five"),
//    nav.higherKey("five"),
//    nav.ceilingKey("five"),
//    nav.floorKey("five"),
//    
//    };
//    for(int i=0;i<ob.length;i++){
//        System.out.println(ob[i].toString()+" ,");
//    }
//        A a=new A();
//        B b=new B();
//        C c=new C();
//        Min m=null;
//        b=(C)m;
//        m=(Min)b;
//        A a2=(A)m;
//        B b2=(B)a2;
//        Min m2=(C)b2;
//        C c2=(C)m2;
       // StringBuffer sb=new StringBuffer("Sun");
        //sb.insert(1, "ExamLab").append("SCJP").delete(1, 3).reverse();
        //System.out.println(sb);
//        rest(4,5,new int[]{1,2,3});
   //     rest(new int[]{1,2,3},4,5);
     //   System.out.printf("%02.2f%s%b",new Double(7),new StringBuffer("set"),"fALSE");
    //int i=1;
   // if(++i>1||++i<1);
 //   if(i-->Integer.MIN_VALUE||i--<Integer.MAX_VALUE);
//    if(i++<Integer.MAX_VALUE||i++>Integer.MIN_VALUE);
//        System.out.printf("i=%+d",i);
  /*  NavigableSet<Integer> items=new TreeSet<Integer>(Collections.reverseOrder());
    items.add(8);
    items.add(4);
    items.add(12);
    items.add(9);
    items.add(6);
    NavigableSet<Integer> dups=items.subSet(4, true, 9, true);
    for(Integer i:dups){
        System.out.println(i+" ");*/
//    }
       /*try{go1();}catch(Exception e){}finally{
           System.out.println("B");
       } */
    }
    /*public static void go1()throws ArrayIndexOutOfBoundsException {
    go2();    
    }
    public static void go2()throws ArithmeticException {
            
            go3();
        
    }
    public static void go3()throws InterruptedException{
    go4();    
    }
    public static void go4()throws NullPointerException {
        System.out.println("A");
        throw new ArrayIndexOutOfBoundsException();
    }
    public static void rest(int... i) {
        System.out.println("a");
    }
    public static void rest(Integer... I) {
        System.out.println("b");
    }*/
}
class store{
    Pattern pt1;Matcher mt1;String st1;
}
class UsePattern{
    static store st;
    public static void main(String[] args) {
        Pattern p = Pattern.compile("H[a-b][k-m]");
        
        Matcher m = p.matcher("Hello Hkllo");
        //boolean b = m.matches();
        //System.out.println(m.find());
       // System.out.println(m.group());
        //Boolean b=new Boolean("FRue");
        //System.out.println(b);
        //Object ob=
        donumber(new Integer[2]);
        donumber(new int []{1,2,3});
    }
    public static void donumber(Integer... dc){
        System.out.println("a"); 
    }
    public static void donumber(int... dc){
        System.out.println("b"); 
    }
    public String useFormate(Object ob,String ... s){
    
        if(ob instanceof  Pattern){
        
        }
        return null;
    }
}