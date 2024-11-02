package web.Dao;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import web.Models.Car;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarDaoImpl implements CarDao {

    private List<Car> cars;

    @PostConstruct
    public CarDaoImpl init() {
        cars = new ArrayList<Car>();
        cars.add(
                Car.builder().id(1L).model("Lada").year(2000).build());
        cars.add(
                Car.builder().id(2L).model("BMW").year(2005).build());
        cars.add(
                Car.builder().id(3L).model("KIA").year(2010).build());
        cars.add(
                Car.builder().id(4L).model("Skoda").year(2015).build());
        cars.add(
                Car.builder().id(5L).model("Cherry").year(2020).build());

        return this;
    }

    @Override
    public void addCar(Car car) {
        cars.add(car);
    }

    @Override
    public List<Car> getLimitCars(int limit) {
        return cars.stream().limit(limit).toList();
    }
}