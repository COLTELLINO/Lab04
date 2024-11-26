package it.unibo.design.robot.components.impl;

import it.unibo.design.robot.components.api.CommandableRobotPart;

import java.util.Arrays;

/**
 *
 */
public abstract class AbstractPartWithCommands extends AbstractPart implements CommandableRobotPart {

    protected static final String NULL_CMD = "No command";

    private final String[] commands;
    private String selectedCommand = NULL_CMD;

    protected AbstractPartWithCommands(final String description, final double consumption, final String... commands) {
        super(description, consumption);
        this.commands = Arrays.copyOf(commands, commands.length);
    }

    public String[] availableCommands() {
        return Arrays.copyOf(commands, commands.length);
    }

    public boolean doOperation() {
        if (isPlugged() && isOn() && !selectedCommand.equals(NULL_CMD)) {
            return doOperation(selectedCommand);
        }
        return false;
    }

    protected abstract boolean doOperation(String command);

    public void sendCommand(final String command) {
        for (final String selected: commands) {
            if (selected.equals(command)) {
                selectedCommand = selected;
            }
        }
    }

}
