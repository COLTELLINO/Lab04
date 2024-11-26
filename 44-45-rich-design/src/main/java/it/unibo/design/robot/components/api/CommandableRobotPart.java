package it.unibo.design.robot.components.api;

public interface CommandableRobotPart extends RobotPart {

    void sendCommand(String command);

    String[] availableCommands();

}
