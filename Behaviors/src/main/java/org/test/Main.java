package org.test;

import org.dominio.Car;
import org.dominio.interfacer.CarPredicate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private final static List<Car> cars = List.of(new Car(2000, "green"), new Car(1999, "red"), new Car(1998, "yellow"));

    public static void main(String[] args) {
        List<Car> carsResult = filter(cars, new CarPredicate() {
            @Override
            public boolean param(Car car) {
                return car.getColor().equals("green");
            }
        });

        List<Car> newCars = filter(cars, new CarPredicate() {
            @Override
            public boolean param(Car car) {
                return car.getYear() > 1998;
            }
        });

        System.out.println(carsResult);
        System.out.println(newCars);
    }

    private static List<Car> filter(List<Car> cars, CarPredicate carPredicate) {
        List<Car> carSelector = new ArrayList<>();

        for (Car car: cars) {
            if (carPredicate.param(car)) {
                carSelector.add(car);
            }
        }
        return carSelector;
    }

}
