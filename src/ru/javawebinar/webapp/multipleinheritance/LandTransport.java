package ru.javawebinar.webapp.multipleinheritance;

/**
 * Created by vench on 04.04.16.
 */
public class LandTransport extends Transport implements ILandTransport {
    @Override
    public void ride() {
        System.out.println("Ride as " + this.getClass().getName());
    }
}
