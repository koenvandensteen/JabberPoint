package controller;

import view.SlideViewer;

/**
 * CommandAllOrNext
 * <p>
 * The command that will show the next slide and if the current slide was not
 * completely drawn will show the remaining items first.
 * </p>
 */

public class CommandAllOrNext implements Command {

	private SlideViewer slideViewer;

	public CommandAllOrNext(SlideViewer slideViewer) {
		this.slideViewer = slideViewer;
	}

	@Override
	public void execute() {
		slideViewer.showAllOrNext();
		slideViewer.updateView();
	}

}