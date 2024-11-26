package it.unibo.design.robot.impl;

/**
 * Models a robotic arm
 *
 */
public class BaseArm {

    private static final double ENERGY_REQUIRED_TO_MOVE = 0.2;
    private static final double ENERGY_REQUIRED_TO_GRAB = 0.1;
    private boolean grabbing;
    private final String name;

    public BaseArm(final String name) {
        this.name = name;
    }

    public boolean isGrabbing() {
        return grabbing;
    }

    public void pickUp() {
        grabbing = true;
    }

    public void dropDown() {
        grabbing = false;
    }

    public double getConsuptionForPickUp() {
        return ENERGY_REQUIRED_TO_MOVE + ENERGY_REQUIRED_TO_GRAB;
    }

    public double getConsuptionForDropDown() {
        return ENERGY_REQUIRED_TO_MOVE;
    }

    public String toString() {
        return name;
    }
}
