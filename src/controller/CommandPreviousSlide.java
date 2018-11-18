package controller;

import view.SlideViewer;

/**
 * CommandPreviousSlide
 * <p>
 * Command that shows the previous slide of the current presentation.
 * </p>
 */

public class CommandPreviousSlide implements Command {

	private SlideViewer slideViewer;

	public CommandPreviousSlide(SlideViewer slideViewer) {
		this.slideViewer = slideViewer;
	}

	@Override
	public void execute() {
		slideViewer.prevSlide();
	}

}