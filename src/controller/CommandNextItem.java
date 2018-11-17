package controller;

import view.SlideViewer;

public class CommandNextItem implements Command {
	
	SlideViewer slideViewer;

	public CommandNextItem(SlideViewer slideViewer){
		this.slideViewer = slideViewer;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("TODO: Show next Item command");
	}

}