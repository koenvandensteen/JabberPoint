package controller;

import view.SlideViewer;

/**
 * CommandPreviousSlide
 * <p>
 * Command that shows the previous slide of the current presentation.
 * </p>
 */

public class CmdPreviousSlide implements Command {

	private SlideViewer slideViewer;

	public CmdPreviousSlide(SlideViewer slideViewer) {
		this.slideViewer = slideViewer;
	}

	@Override
	public void execute() {
		slideViewer.prevSlide();
	}

}