package controller;

import java.awt.Frame;

import view.SlideViewer;

public class CommandClearOrBack implements Command {

	private SlideViewer slideViewer;
	private Frame parent;
	
	public CommandClearOrBack(SlideViewer slideViewer, Frame parent){
		this.slideViewer = slideViewer;
		this.parent = parent;
	}
	
	@Override
	public void execute() {
		slideViewer.clearItemsOrBack();
		parent.repaint();
	}

}
