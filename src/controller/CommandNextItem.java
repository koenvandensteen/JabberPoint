package controller;

import view.SlideViewer;
/**
 * CommandNextItem
 * <p>
 * Command for showing the next item of the current slide.
 * </p>
 */
public class CommandNextItem implements Command {

	private SlideViewer slideViewer;

	public CommandNextItem(SlideViewer slideViewer) {
		this.slideViewer = slideViewer;
	}

	@Override
	public void execute() {
		slideViewer.nextItem();
		slideViewer.updateView();
	}

}