/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Drink;

/**
 *
 * @author anderson
 */
public class Drink {

    //price元一瓶酒
    private int price;
    //cap个瓶盖换一瓶酒
    private int cap;
    //n个空瓶换一瓶酒
    private int n;
    //总共有money元
    private int money;
    //能喝多少酒？
    private int drink;

    Drink(int price, int cap, int n, int money) {
        this.price = price;
        this.cap = cap;
        this.n = n;
        this.money = money;
        init();
    }

    private void init() {
        int lv_cap = 0;
        int lv_n = 0;
        int lv_money = 0;
        int lv = 0;
        drink = money / price;
        lv_money = money - drink * price;
        lv_cap = drink;
        lv_n = drink;        
        System.out.println("用"+money+"元买了"+money/price+"瓶酒，总共饮了"+money/price+"瓶酒，剩"+lv_cap+"个盖子，"+lv_n+"个空瓶，剩"+lv_money+"元");
        while (true) {
            if(lv_cap/cap>0){//如果盖子够cap个，那来换lv_cap/cap瓶酒
                lv = lv_cap / cap;
                lv_cap -= lv*cap;  //瓶盖少了lv*cap个
                drink += lv;//换了lv瓶酒
                lv_n += lv;//增加了lv个瓶子
                lv_cap += lv;//增加lv个盖子
                System.out.println("用"+lv*cap+"个盖子换了"+lv+"瓶酒，总共饮了"+drink+"瓶酒，剩"+lv_cap+"个盖子，"+lv_n+"个空瓶");
            }
            
            if(lv_n / n > 0){
                lv = lv_n / n;//
                lv_n -= lv*n;//空瓶子少了lv*n个
                drink += lv;//酒多了lv瓶
                lv_cap += lv;//瓶盖多了lv个
                lv_n += lv;//增加lv个空瓶子
                System.out.println("用"+lv*n+"个瓶子换了"+lv+"瓶酒，总共饮了"+drink+"瓶酒，剩"+lv_cap+"个盖子，"+lv_n+"个空瓶");
            }
            
            if (lv_money / price < 1 && lv_cap < cap && lv_n < n) {//当钱不够买一瓶酒，盖子不够换一瓶酒，空瓶子不够换一瓶酒时，结束循环
                break;
            }
        }
    }
    
    public static void main(String[] args) {
        new Drink(2,4,2,10);
    }
}
