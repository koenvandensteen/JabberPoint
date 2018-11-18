package controller;

import view.SlideViewer;

/**
 * CommandAmountItems
 * <p>
 * Show a specfic ammount of items on the current slide.
 * </p>
 */

public class CommandAmountItems implements Command {

	private SlideViewer slideViewer;

	public CommandAmountItems(SlideViewer slideViewer) {
		this.slideViewer = slideViewer;
	}

	@Override
	public void execute() {
		slideViewer.goToItemNR();
	}

}
