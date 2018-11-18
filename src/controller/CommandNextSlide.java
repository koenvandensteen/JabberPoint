package controller;

import view.SlideViewer;
/**
 * CommandNextSlide
 * <p>
 * Command that show the next slide of the presentation.
 * </p>
 */
public class CommandNextSlide implements Command {

	private SlideViewer slideViewer;

	public CommandNextSlide(SlideViewer slideViewer) {
		this.slideViewer = slideViewer;
	}

	@Override
	public void execute() {
		slideViewer.nextSlide();
	}

}
