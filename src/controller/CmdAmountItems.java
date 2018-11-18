package controller;

/**
 * CommandAmountItems
 * <p>
 * Show a specfic ammount of items on the current slide.
 * </p>
 */

public class CmdAmountItems implements Command {

	private SlideViewer slideViewer;

	public CmdAmountItems(SlideViewer slideViewer) {
		this.slideViewer = slideViewer;
	}

	@Override
	public void execute() {
		slideViewer.goToItemNR();
	}

}
