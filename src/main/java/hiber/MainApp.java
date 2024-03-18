package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);


      User u1 = new User("name1", "lastname1", "mail1");
      User u2 = new User("name2", "lastname2", "mail2");
      User u3 = new User("name3", "lastname3", "mail3");

      Car c1 = new Car("BMW", 1);
      Car c2 = new Car("BMW", 2);
      Car c3 = new Car("BMW", 3);

      userService.add(u1.setCar(c1).setUser(u1));
      userService.add(u2.setCar(c2).setUser(u2));
      userService.add(u3.setCar(c3).setUser(u3));

      System.out.println(userService.getUserByCar("BMW", 2));

      context.close();
   }
}
