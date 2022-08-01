/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Daokh
 */
public class NewClass {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4};
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<a.length;i++){
            list.add(a[i]);
        }
        System.out.println(list.toString());
        for(int i=0;i<list.size();i++){
            if(i==2 || i==4){
                list.remove(i);
            }
        }
        System.out.println(list.toString());
    }
}
