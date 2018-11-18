package controller;

import view.SlideViewer;

/**
 * CommandNew
 * <p>
 * Command for creating a new presentation.
 * </p>
 */

public class CmdNew implements Command {

	private SlideViewer slideViewer;

	public CmdNew(SlideViewer slideViewer) {
		this.slideViewer = slideViewer;
	}

	@Override
	public void execute() {
		slideViewer.clear();
		slideViewer.updateView();
	}

}