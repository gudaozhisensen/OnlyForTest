/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author whl
 */
public class MapSetTest {

    public static void main(String[] args) {
        Map map = new HashMap();
        Set set = new TreeSet();
        for (int i = 0; i < 50; i++) {
            map.put(i, i);
            set.add(i);
        }
        for (Object o : map.entrySet()) {
            System.out.print(" o : " + o);
        }
        System.out.println("");
        System.out.println("---------------------------");
        for (Object o : map.keySet()) {
            System.out.print(" o : " + o);
        }
//        set = map.keySet();
        System.out.println("");
        System.out.println("---------------------------");
        for (Object o : set) {
            System.out.print(" o : " + o);
        }
    }
}
