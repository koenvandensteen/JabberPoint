package controller;

import view.SlideViewer;

/**
 * CommandExit
 * <p>
 * Exits the program.
 * </p>
 */
public class CommandExit implements Command {

	private SlideViewer slideViewer;

	public CommandExit(SlideViewer slideViewer) {
		this.slideViewer = slideViewer;
	}

	@Override
	public void execute() {
		slideViewer.exit(0);
	}

}