package web.Service;

import web.Dao.CarDao;
import web.Models.Car;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarServiceImpl implements CarService {

    private final CarDao carDao;

    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    public List<Car> getLimitCars(int count) {
        return carDao.getLimitCars(count);
    }

    @Override
    public void addCar(Car car) {
        carDao.addCar(car);
    }
}
