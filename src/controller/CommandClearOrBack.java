package controller;

import view.SlideViewer;

/**
 * CommandClearOrBack
 * <p>
 * Clear the current slide if already cleared we go to the previous slide.
 * </p>
 */
public class CommandClearOrBack implements Command {

	private SlideViewer slideViewer;

	public CommandClearOrBack(SlideViewer slideViewer) {
		this.slideViewer = slideViewer;
	}

	@Override
	public void execute() {
		slideViewer.clearItemsOrBack();
		slideViewer.updateView();
	}

}
