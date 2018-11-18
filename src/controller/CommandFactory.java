package controller;

import java.awt.Frame;

/**
 * CommandFactory
 * <p>
 * Factory to create all the different commands.
 * </p>
 */
public class CommandFactory {

	private SlideViewer slideViewer;
	private Frame parent;

	public CommandFactory(Frame parent, SlideViewer slideViewer) {
		this.parent = parent;
		this.slideViewer = slideViewer;
	}

	public Command createNextSlideCMD() {
		return new CmdNextSlide(slideViewer);
	}

	public Command createPreviousSlideCMD() {
		return new CmdPreviousSlide(slideViewer);
	}

	public Command createNextItemCMD() {
		return new CmdNextItem(slideViewer);
	}

	public Command createPreviousItemCMD() {
		return new CmdPreviousItem(slideViewer);
	}

	public Command createShowAllOrNextCMD() {
		return new CmdAllOrNext(slideViewer);
	}

	public Command createClearItemsOrBackCMD() {
		return new CmdClearOrBack(slideViewer);
	}

	public Command createExitCMD() {
		return new CmdExit(slideViewer);
	}

	public Command createSlideByNumberCMD() {
		return new CmdSlideByNumber(slideViewer);
	}

	public Command createOpenCMD() {
		return new CmdOpen(slideViewer, parent);
	}

	public Command createSaveCMD() {
		return new CmdSave(parent, slideViewer.GetPresentation());
	}

	public Command createNewCMD() {
		return new CmdNew(slideViewer);
	}

	public Command createShowAboutBoxCMD() {
		return new CmdShowAboutBox(parent);
	}

	public Command createToggleItemsCMD() {
		return new CmdToggleAllItems(slideViewer);
	}

	public Command createNullCMD() {
		return new NullCommand();
	}

}
