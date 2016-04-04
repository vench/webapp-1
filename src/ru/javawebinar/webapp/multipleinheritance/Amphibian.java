package ru.javawebinar.webapp.multipleinheritance;

/**
 * Created by vench on 04.04.16.
 */
public class Amphibian extends Transport implements  IWaterTransport, ILandTransport {


    private Car car;

    private Ship ship;

    public Amphibian() {
        car = new Car();
        ship = new Ship();
    }

    @Override
    public void ride() {
        car.ride();
    }

    @Override
    public void swim() {
        ship.swim();
    }
}
