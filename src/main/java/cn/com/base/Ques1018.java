package cn.com.base;


public class Ques1018 {  
  
    public static void main(String[] args){  
        Obj obj01 = new Obj("18");  
        Obj obj02 = new Obj("19");  
        obj01.printAge(obj02);  
    }  
}  
  
class Obj{  
    private String age;   
  
    public Obj(String age){  
        this.age = age;  
    }  
  
    public void printAge(Obj obj){  
         age = obj.age;   
        System.out.println("年龄是：" + age);  
    }  
}