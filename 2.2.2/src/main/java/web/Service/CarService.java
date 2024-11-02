package web.Service;

import web.Models.Car;

import java.util.List;

public interface CarService {
    void addCar(Car car);
    List<Car> getLimitCars(int count);
}
