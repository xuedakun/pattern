package cn.com.pattern.prototype.exercise;

/**
 * @author xuekun
 * @create 2019-07-16 18:30
 **/
public class CustomerClient {

    public static void main(String[] args) {
        Customer customer=new Customer();
        customer.setName("大炮");
        customer.setAge(11);
        customer.setSex(1);
        Address address=new Address();
        address.setStreet("嘉怡路一号");
        customer.setAddress(address);

        Customer customerNew=customer.deepClone();
        System.out.println(customer==customerNew);
        System.out.println(customer.getSex()==customerNew.getSex());
        System.out.println(customer.getName()==customerNew.getName());
        System.out.println(customer.getAddress()==customerNew.getAddress());
    }
}
