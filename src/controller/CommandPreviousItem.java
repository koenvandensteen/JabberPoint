package controller;

import view.SlideViewer;

/**
 * CommandPreviousItem
 * <p>
 * Command that shows the previous slide item of the current slide.
 * </p>
 */
public class CommandPreviousItem implements Command {

	private SlideViewer slideViewer;

	public CommandPreviousItem(SlideViewer slideViewer) {
		this.slideViewer = slideViewer;
	}

	@Override
	public void execute() {
		slideViewer.previousItem();
		slideViewer.updateView();
	}

}