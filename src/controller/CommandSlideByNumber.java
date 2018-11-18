package controller;

import view.SlideViewer;

/**
 * CommandOpen
 * <p>
 * Command that shows a specific slide with a specific number.
 * </p>
 */

public class CommandSlideByNumber implements Command {

	private SlideViewer slideViewer;

	public CommandSlideByNumber(SlideViewer slideViewer) {
		this.slideViewer = slideViewer;
	}

	@Override
	public void execute() {
		slideViewer.goToSlideNR();
	}

}
