package test;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author whl
 */
public class Test {

    void Test() {
    }

    void Test1(int n) {//輸出菱形
        for (int i = 0; i < n; i++) {
            for (int z = 0; z < Math.abs(((n - 1) / 2) - i); z++) {
                System.out.print(" ");
            }            
            for (int j = 0; j < n - Math.abs((n - 1 - 2 * i)); j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    void waterFlower(int n) {
        System.out.println(n + "以内的水仙花数");
        for (int i = 100; i < n; i++) {
            int a = i / 100;
            int b = i / 10 % 10;
            int c = i % 10;
            double d = (double) i;
            if (Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3) == d) {
                System.out.println(i);
            }
        }
    }

    void nineNine() {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + "*" + j + "=" + i * j + "   ");
            }
            System.out.println("");
        }
    }

    void sort(int n) {
        int arr[] = new int[n];
        int temp;
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (random.nextInt(n * 10));
        }
        System.out.println("排序前：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "   ");
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        System.out.println("");
        System.out.println("排序後：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "   ");
        }
    }

    int whoLive(int n) {//n個人（帶號碼）輪流報數1，2，3 報到3的退出，最後剩下幾號
        int dead = 0;//剔除人數
        int shut = 0;//叫號
        int i = 0;
        int[] arr = new int[n];
        System.out.println("現有" + n + "個人報數，(報數報到3的人槍斃)");
        for (; i < n; i++) {
            arr[i] = i + 1;
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
        i = 0;
        while (dead < (n - 1)) {
            shut++;
            if (shut % 3 == 0) {
                System.out.print(arr[i % n] + " 號報數報到3，拖出去槍斃，剩下來的編號為: ");
                arr[i % n] = 0;
                dead++;
                for (int a : arr) {
                    if (a != 0) {
                        System.out.print(a + "    ");
                    }
                }
                System.out.println("");
            }
            i++;
            while (arr[i % n] == 0) {//跳過out的人
                i++;
            }
        }
        for (int a : arr) {
            if (a != 0) {
                return a;
            }
        }
        return 0;
    }

    int rabbit(int month) {//一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月有多少對兔子？         
        if (month <= 2) {
//            System.out.print("1"+"  ");
            return 1;
        } else {
//            System.out.print(rabbit(month - 2) + rabbit(month - 1)+"  ");
            return rabbit(month - 2) + rabbit(month - 1);
        }
    }

    int rabbit2(int month) {
        if (month > 2) {
            List<Integer> list = new <Integer>ArrayList();
            list.add(1);
            list.add(1);
            for (int i = 2; i < month; i++) {
                list.add(list.get(i - 2) + list.get(i - 1));
            }
            for(int a:list){
                System.out.print(a+"  ");
            }
            return list.get(list.size() - 1);
        } else {
            return 1;
        }             
    }
    
    int countComma(String str){
        int count = 0;        
        String lv_str []  = str.split(",");
        count = lv_str.length;
        return count;
    }


    public static void main(String[] args) {
        Test test = new Test();
        ArrayList al = new ArrayList();
        System.out.println(al.size());
//        System.out.println(test.countComma(""));
//        System.out.println(test.countComma("0266000006,0266000013,0266000015,0266000005,0266000004,0266000007,0266000008,0266000009,0266000010,0266000011,0266000012,0266000014,0266000041,0266000016,0266000017"));
    }
}
