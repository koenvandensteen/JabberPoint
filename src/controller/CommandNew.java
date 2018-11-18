package controller;

import view.SlideViewer;

/**
 * CommandNew
 * <p>
 * Command for creating a new presentation.
 * </p>
 */

public class CommandNew implements Command {

	private SlideViewer slideViewer;

	public CommandNew(SlideViewer slideViewer) {
		this.slideViewer = slideViewer;
	}

	@Override
	public void execute() {
		slideViewer.clear();
		slideViewer.updateView();
	}

}