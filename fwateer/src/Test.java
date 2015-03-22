/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author azza
 */
public class Test {
    public static void main(String[] args) {
        int x=10,y=15;
        if((++x>10)&&(++y<15)){
        x++;
        }
        else{
        ++y;
        }
        System.out.println(x);
        System.out.println(y);
    }
}
