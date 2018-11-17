package controller;

import java.awt.Frame;

import view.SlideViewer;

public class CommandAllOrNext implements Command {
	
	private SlideViewer slideViewer;
	private Frame parent;

	public CommandAllOrNext(SlideViewer slideViewer, Frame parent){
		this.slideViewer = slideViewer;
		this.parent = parent;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("TODO: Show all Items command");
		slideViewer.showAllOrNext();
		parent.repaint();
	}

}