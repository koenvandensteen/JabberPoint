package controller;

/**
 * NullCommand
 * <p>
 * A null command that we execture when we got no key bound to the currentle
 * pressed key.
 * </p>
 */
public class NullCommand implements Command {

	@Override
	public void execute() {
		// No actions!
	}

}
