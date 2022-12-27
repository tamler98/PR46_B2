package xmlbasedconfiguration.main;

import javabasedonconfiguaration.BeanConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.AccountService;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("annotationbasedconfiguration/beans.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);

        System.out.println("Before money  transfer");
        System.out.println("Account 1 balance: "+accountService.getAccount(1).getBalance());
        System.out.println("Account 2 balance: "+accountService.getAccount(2).getBalance());

        accountService.transferMoney(1, 2, 5.0);
        System.out.println("After money transfer");
        System.out.println("Account 1 balance: " +accountService.getAccount(1).getBalance()); //5
        System.out.println("Account 2 balance: " +accountService.getAccount(2).getBalance());//7
    }
}