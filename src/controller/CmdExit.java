package controller;

/**
 * CommandExit
 * <p>
 * Exits the program.
 * </p>
 */
public class CmdExit implements Command {

	private SlideViewer slideViewer;

	public CmdExit(SlideViewer slideViewer) {
		this.slideViewer = slideViewer;
	}

	@Override
	public void execute() {
		slideViewer.exit(0);
	}

}