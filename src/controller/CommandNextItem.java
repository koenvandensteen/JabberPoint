package controller;

import java.awt.Frame;

import view.SlideViewer;

public class CommandNextItem implements Command {
	
	private SlideViewer slideViewer;
	private Frame parent;

	public CommandNextItem(SlideViewer slideViewer, Frame parent){
		this.slideViewer = slideViewer;
		this.parent = parent;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("TODO: Show next Item command (repaint)");
		slideViewer.nextItem();
		parent.repaint();
	}

}