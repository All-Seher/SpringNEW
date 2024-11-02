package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Objects;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        CarService carService = context.getBean(CarService.class);

        Car car1 = Car.builder().model("Car1").series(1L).build();
        Car car2 = Car.builder().model("Car2").series(2L).build();
        Car car3 = Car.builder().model("Car3").series(3L).build();
        Car car4 = Car.builder().model("Car4").series(4L).build();

        carService.add(car1);
        carService.add(car2);
        carService.add(car3);
        carService.add(car4);

        User user1 = User.builder().firstName("User1").lastName("Lastname1").email("user1@mail.ru").build();
        user1.setCar(car1);
        User user2 = User.builder().firstName("User2").lastName("Lastname2").email("user2@mail.ru").build();
        user2.setCar(car2);
        User user3 = User.builder().firstName("User3").lastName("Lastname3").email("user3@mail.ru").build();
        user3.setCar(car3);
        User user4 = User.builder().firstName("User4").lastName("Lastname4").email("user4@mail.ru").build();
        user4.setCar(car4);

        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar());
            System.out.println();
        }

        System.out.println("Получение пользователя: " + Objects.toString(userService.getUserByCar("Car4", 3L),
                "Пользователь не найден"));
        System.out.println("Получение пользователя: " + Objects.toString(userService.getUserByCar("Car2", 2L),
                "Пользователь не найден"));
        System.out.println("Получение пользователя: " + Objects.toString(userService.getUserByCar("Car1", 1L),
                "Пользователь не найден: "));
        System.out.println("Получение пользователя: " + Objects.toString(userService.getUserByCar("Car3", 3L),
                "Пользователь не найден: "));

        context.close();
    }
}