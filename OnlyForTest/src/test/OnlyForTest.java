/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author whl
 */
public class OnlyForTest {

    /**
     * @param args the command line arguments
     * 計算不消費、分期消費、不分期消費最後的金額（默認6個月）,第一個月沒有工資
     */
      void cal(double cap,double income,double month,double rate){
        System.out.println("本金:"+cap+" 工資收入:"+income+" 支付寶月收益:"+rate);
        System.out.println("消費金額：0");
        double old_cap;
        for(int i=0;i<month;i++){
            old_cap=cap;
            cap+=cap*rate;            
            System.out.println("第"+i+"個月剩餘"+cap+" 支付寶收益:"+(cap-old_cap));
            cap+=income;
        }
    }
    
       void cal(double cap,double income,double month,double rate,double bill,boolean flag){
           double old_cap;
           System.out.println("本金:"+cap+" 工資收入:"+income+" 支付寶月收益:"+rate);
          System.out.println("是否分期:"+flag+" 消費金額:"+bill);
          if(!flag){
          cap-=bill;
          for(int i=0;i<month;i++){
              old_cap=cap;
              cap+=cap*rate;
              System.out.println("第"+i+"個月剩餘"+cap+" 支付寶收益"+(cap-old_cap));
              cap+=income;
          }
          }else{
              for(int i=0;i<month;i++){
                   old_cap=cap;
                  if(i<1){                 
                    cap+=(cap)*rate; 
                  }else{
                      cap+=cap*rate;
                  }
              System.out.println("第"+i+"個月剩餘"+cap+" 支付寶收益"+(cap-old_cap));
              cap+=(income-bill/(month-1));
            }
      }
       }
   /* public static void main(String[] args) {
        // TODO code application logic here
        OnlyForTest o = new OnlyForTest();
        double cap=10000;//本金
        double rate = 0.00007081*30;//支付寶月利率
        double income=5000;//工資
        double bill=6000;//總花費
        double month=3+1;//分期月份
        double bill_rate = 0.005;//分期利息
        double all_bill=bill*month*bill_rate;
        o.cal(cap,income,month,rate);
        System.out.println("------------------------------------");
        o.cal(cap,income,month,rate*1.76,bill+all_bill,true);
        System.out.println("------------------------------------");
        o.cal(cap,income,month,rate,bill,false);
        //System.out.println(all_bill);
    }*/
  
}
