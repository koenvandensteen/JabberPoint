package controller;

import java.awt.Frame;

import view.SlideViewer;

public class CommandShowAllItems implements Command {
	
	private SlideViewer slideViewer;
	private Frame parent;

	public CommandShowAllItems(SlideViewer slideViewer, Frame parent){
		this.slideViewer = slideViewer;
		this.parent = parent;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("TODO: Show all Items command");
	}

}