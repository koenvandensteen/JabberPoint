package controller;

import view.SlideViewer;

/**
 * CommandToggleAllItems
 * <p>
 * Command that shows all the items of the current slide.
 * </p>
 */

public class CommandToggleAllItems implements Command {

	private SlideViewer slideViewer;

	public CommandToggleAllItems(SlideViewer slideViewer) {
		this.slideViewer = slideViewer;
	}

	@Override
	public void execute() {
		slideViewer.toggleShowAll();
		slideViewer.updateView();
	}

}