package web.service;

import web.models.Car;

import java.util.List;

public class CarServiceImp {
    public static int sumCars(List<Car> cars) { return cars.size(); }
}
