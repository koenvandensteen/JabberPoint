package controller;

import java.awt.Frame;
import view.AboutBox;
import view.SlideViewer;

public class CommandShowAboutBox implements Command {
	
	SlideViewer slideViewer;
	Frame parent;

	public CommandShowAboutBox(SlideViewer slideViewer, Frame parent){
		this.slideViewer = slideViewer;
		this.parent = parent;
	}
	
	@Override
	public void execute() {
		AboutBox.show(parent);
	}

}