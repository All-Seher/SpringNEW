package hiber.service;

import hiber.dao.CarDao;
import hiber.model.Car;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final CarDao carDao;

    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }

    @Transactional
    @Override
    public List<Car> listUsers() {
        return carDao.listUsers();
    }

    @Transactional
    @Override
    public void add(Car car) {
        carDao.add(car);
    }
}
