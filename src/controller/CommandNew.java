package controller;

import java.awt.Frame;

import view.SlideViewer;

public class CommandNew implements Command {
	
	private SlideViewer slideViewer;
	private Frame parent;

	public CommandNew(SlideViewer slideViewer, Frame parent){
		this.slideViewer = slideViewer;
		this.parent = parent;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("TODO: new command");
		slideViewer.clear();
		parent.repaint();
	}

}