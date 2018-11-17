package controller;

import view.SlideViewer;

public class CommandExit implements Command {
	
	private SlideViewer slideViewer;

	public CommandExit(SlideViewer slideViewer){
		this.slideViewer = slideViewer;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		slideViewer.exit(0);
	}

}