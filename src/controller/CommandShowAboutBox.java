package controller;

import java.awt.Frame;
import view.AboutBox;

public class CommandShowAboutBox implements Command {
	
	private Frame parent;

	public CommandShowAboutBox(Frame parent){
		this.parent = parent;
	}
	
	@Override
	public void execute() {
		AboutBox.show(parent);
	}

}