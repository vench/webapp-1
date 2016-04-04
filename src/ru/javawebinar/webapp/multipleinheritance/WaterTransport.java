package ru.javawebinar.webapp.multipleinheritance;

/**
 * Created by vench on 04.04.16.
 */
public class WaterTransport extends Transport implements  IWaterTransport{

    @Override
    public void swim() {
        System.out.println("Shim as " + this.getClass().getName());
    }
}
