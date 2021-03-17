package hiber;

import hiber.config.AppConfig;
import hiber.model.User;
import hiber.model.Car;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class  MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru", "lada", 2106));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", "audi", 100));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", "zil", 130));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru", "peugeot", 4007));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("Model = " + user.getModel());
         System.out.println("Series = " + user.getSeries());
         System.out.println();
      }

      User user = userService.getUser("zil", 130);
      System.out.println("Id = " + user.getId());
      System.out.println("First Name = " + user.getFirstName());
      System.out.println("Last Name = " + user.getLastName());
      System.out.println("Email = " + user.getEmail());

      context.close();
   }
}
