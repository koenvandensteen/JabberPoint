package controller;

/**
 * CommandPreviousItem
 * <p>
 * Command that shows the previous slide item of the current slide.
 * </p>
 */
public class CmdPreviousItem implements Command {

	private SlideViewer slideViewer;

	public CmdPreviousItem(SlideViewer slideViewer) {
		this.slideViewer = slideViewer;
	}

	@Override
	public void execute() {
		slideViewer.previousItem();
		slideViewer.updateView();
	}

}