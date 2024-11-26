package it.unibo.design.robot.components.api;

import it.unibo.design.robot.api.Robot;

/**
 * Models a generic robot part.
 */
public interface RobotPart {

    boolean doOperation();

    double getEnergyRequired();

    String getName();

    boolean isOn();

    boolean isPlugged();

    boolean isPluggedTo(Robot cr);

    void plug(ComposableRobot cr);

    void turnOff();

    void turnOn();

    void unplug();

}
