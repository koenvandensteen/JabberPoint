package controller;

import view.SlideViewer;

public class CommandShowAllItems implements Command {
	
	SlideViewer slideViewer;

	public CommandShowAllItems(SlideViewer slideViewer){
		this.slideViewer = slideViewer;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		slideViewer.showAll();
	}

}