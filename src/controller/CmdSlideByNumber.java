package controller;

/**
 * CommandOpen
 * <p>
 * Command that shows a specific slide with a specific number.
 * </p>
 */

public class CmdSlideByNumber implements Command {

	private SlideViewer slideViewer;

	public CmdSlideByNumber(SlideViewer slideViewer) {
		this.slideViewer = slideViewer;
	}

	@Override
	public void execute() {
		slideViewer.goToSlideNR();
	}

}
