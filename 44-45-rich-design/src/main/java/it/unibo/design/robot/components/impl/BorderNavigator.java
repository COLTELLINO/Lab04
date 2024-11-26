/**
 * 
 */
package it.unibo.design.robot.components.impl;

import it.unibo.design.robot.impl.BaseRobot;

public class BorderNavigator extends AbstractPart {

    private static final int NORTH = 0;
    private static final int EAST = 1;
    private static final int SOUTH = 2;
    private static final int WEST = 3;
    private static final int AVAILABLE_DIRECTIONS = 4;
    private int curDir;

    public BorderNavigator() {
        super("Border Navigator", BaseRobot.MOVEMENT_DELTA_CONSUMPTION);
    }

    private boolean tryToMove() {
        switch (curDir % AVAILABLE_DIRECTIONS) {
        case NORTH:
            return getRobot().moveUp();
        case EAST:
            return getRobot().moveRight();
        case SOUTH:
            return getRobot().moveDown();
        case WEST:
            return getRobot().moveLeft();
        default:
            System.out.println("There is a bug in " + getClass());
            return false;
        }
    }

    @Override
    public boolean doOperation() {
        if (isOn() && isPlugged()) {
            while (!tryToMove()) {
                curDir++;
                if (curDir > AVAILABLE_DIRECTIONS) {
                    curDir = 0;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Border Navigator";
    }

}
