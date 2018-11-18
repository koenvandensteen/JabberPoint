package controller;

/**
 * CommandClearOrBack
 * <p>
 * Clear the current slide if already cleared we go to the previous slide.
 * </p>
 */
public class CmdClearOrBack implements Command {

	private SlideViewer slideViewer;

	public CmdClearOrBack(SlideViewer slideViewer) {
		this.slideViewer = slideViewer;
	}

	@Override
	public void execute() {
		slideViewer.clearItemsOrBack();
		slideViewer.updateView();
	}

}
