package it.unibo.design.robot.test;

import it.unibo.design.robot.components.api.CommandableRobotPart;
import it.unibo.design.robot.components.api.ComposableRobot;
import it.unibo.design.robot.components.api.RobotPart;
import it.unibo.design.robot.components.impl.AtomicBattery;
import it.unibo.design.robot.components.impl.BorderNavigator;
import it.unibo.design.robot.components.impl.RobotArm;
import it.unibo.design.robot.impl.BaseRobot;
import it.unibo.design.robot.components.impl.SimpleComposableRobot;

/**
 * Utility class for testing composable robots
 */
public final class TestComposableRobot {

    private static final int CYCLES = 200;

    private TestComposableRobot() { }

    public static void main(final String[] args) {
        final ComposableRobot r0 = new SimpleComposableRobot("Evangelion Unit 01");
        final RobotPart navi = new BorderNavigator();
        final RobotPart battery = new AtomicBattery();
        final CommandableRobotPart arm1 = new RobotArm();
        final CommandableRobotPart arm2 = new RobotArm();
        /*
         * Component connection
         */
        r0.attachComponent(navi);
        r0.attachComponent(battery);
        r0.attachComponent(arm1);
        r0.attachComponent(arm2);
        /*
         * Turn on components
         */
        navi.turnOn();
        arm1.turnOn();
        arm2.turnOn();
        /*
         * Run some cycles
         */
        for (int i = 0; i < CYCLES; i++) {
            if (r0.getBatteryLevel() < BaseRobot.BATTERY_FULL / 2) {
                battery.turnOn();
            } else {
                battery.turnOff();
            }
            arm1.sendCommand(arm1.availableCommands()[i % arm1.availableCommands().length]);
            arm2.sendCommand(arm2.availableCommands()[i % arm2.availableCommands().length]);
            r0.doCycle();
        }
        /*
         * Detach components
         */
        r0.detachComponent(arm1);
        r0.detachComponent(arm2);
        /*
         * Test if it runs anyway
         */
        r0.doCycle();
        r0.doCycle();
    }
}
