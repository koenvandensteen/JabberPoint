package controller;

/**
 * CommandNextSlide
 * <p>
 * Command that show the next slide of the presentation.
 * </p>
 */
public class CmdNextSlide implements Command {

	private SlideViewer slideViewer;

	public CmdNextSlide(SlideViewer slideViewer) {
		this.slideViewer = slideViewer;
	}

	@Override
	public void execute() {
		slideViewer.nextSlide();
	}

}
