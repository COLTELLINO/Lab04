package it.unibo.design.robot.components.api;

import it.unibo.design.robot.api.Robot;

public interface ComposableRobot extends Robot {

    void attachComponent(RobotPart robotPart);

    void detachComponent(RobotPart robotPart);

    void doCycle();

}
