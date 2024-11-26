package it.unibo.design.robot.api;

import it.unibo.design.robot.impl.BaseArm;

/**
 * Models a generic robot with two {@link BaseArm}
 */
public interface RobotWithArms extends Robot {

    boolean pickUp();

    boolean dropDown();

    int getCarriedItemsCount();

}
