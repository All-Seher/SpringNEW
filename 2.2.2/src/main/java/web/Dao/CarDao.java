package web.Dao;

import web.Models.Car;

import java.util.List;

public interface CarDao {

    void addCar(Car car);
    List<Car> getLimitCars(int limit);
}
