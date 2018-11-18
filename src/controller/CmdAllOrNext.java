package controller;

/**
 * CommandAllOrNext
 * <p>
 * The command that will show the next slide and if the current slide was not
 * completely drawn will show the remaining items first.
 * </p>
 */

public class CmdAllOrNext implements Command {

	private SlideViewer slideViewer;

	public CmdAllOrNext(SlideViewer slideViewer) {
		this.slideViewer = slideViewer;
	}

	@Override
	public void execute() {
		slideViewer.showAllOrNext();
		slideViewer.updateView();
	}

}