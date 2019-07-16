package cn.com.base;

public class Lilvjs {

  public static  String js(Double lilv,Integer qs) {
    // 分期手续费率/(分期数+1)*24 = 单期手续费率*分期数/(分期数+1)*24
    //12期分期的年化利率：0.054*12/13*24=1.1963=11.96%
    double x=lilv*qs/(qs+1)*24;
    System.out.println(x);
    return x*10+"%";
  }
  public static void main(String[] args) {
    System.out.println(Lilvjs.js(0.06, 36));
  }
}
