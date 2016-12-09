/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author whl
 */
public class LightTest {

    private HashMap hm;

    LightTest(HashMap hm) {
        this.hm = hm;
        this.hm = turnOn();
    }

    private void showLight() {
        int lightOn = 0;
        int lightOff = 0;
        for (int i = 1; i < hm.size() + 1; i++) {
            if ("ON".equals(hm.get(i))) {
                lightOn++;
            } else if ("OFF".equals(hm.get(i))) {
                lightOff++;
            }
            System.out.print(i + " : " + hm.get(i) + " ,");
            if (i % 20 == 0) {
                System.out.println("");
            }
        }
        System.out.println("");
        System.out.println("------------------------------------------------------有" + lightOn + "盏灯亮,有" + lightOff + "盏灯不亮");
    }

    

    private HashMap turnOn() {
        HashMap hm = new HashMap();
        for (int i = 1; i < 151; i++) {//有150盏灯亮
            hm.put(i, "ON");
        }
        return hm;
    }

    private void changeLight(int num) {
        for (int i = 1; i < hm.size() + 1; i++) {
            if (i % num == 0) {
                if ("ON".equals(hm.get(i))) {
                    hm.put(i, "OFF");//num倍数的灯，如果是开着的就关闭
                } else if ("OFF".equals(hm.get(i))) {
                    hm.put(i, "ON");//num倍数的灯，如果是关着的就打开
                }
            }
        }
    }
    
    public static void main(String[] args) {
        HashMap hm = null;
        LightTest lt = new LightTest(hm);
        lt.showLight();
        lt.changeLight(3);//拉3倍数灯
        lt.showLight();
        lt.changeLight(5);//拉5倍数灯
        lt.showLight();
    }
}
