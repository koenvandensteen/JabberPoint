package controller;

/**
 * CommandInvoker
 * <p>
 * Class that invokes a specific command.
 * </p>
 */
public class CommandInvoker {

	public static void executeCommand(Command command) {
		command.execute();
	}

}
