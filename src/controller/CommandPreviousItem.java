package controller;

import view.SlideViewer;

public class CommandPreviousItem implements Command {
	
	SlideViewer slideViewer;

	public CommandPreviousItem(SlideViewer slideViewer){
		this.slideViewer = slideViewer;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("TODO: Previous Item command");
	}

}