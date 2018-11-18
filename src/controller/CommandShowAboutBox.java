package controller;

import java.awt.Frame;
import view.AboutBox;

/**
 * CommandShowAboutBox
 * <p>
 * Command that shows the about box of the jabber point program.
 * </p>
 */

public class CommandShowAboutBox implements Command {

	private Frame parent;

	public CommandShowAboutBox(Frame parent) {
		this.parent = parent;
	}

	@Override
	public void execute() {
		AboutBox.show(parent);
	}

}