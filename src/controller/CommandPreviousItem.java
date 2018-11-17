package controller;

import java.awt.Frame;

import view.SlideViewer;

public class CommandPreviousItem implements Command {
	
	private SlideViewer slideViewer;
	private Frame parent;

	public CommandPreviousItem(SlideViewer slideViewer, Frame parent){
		this.slideViewer = slideViewer;
		this.parent = parent;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("TODO: Previous Item command (repaint)");
		slideViewer.previousItem();
		parent.repaint();
	}

}