package controller;

import view.SlideViewer;

public class CommandNew implements Command {
	
	private SlideViewer slideViewer;

	public CommandNew(SlideViewer slideViewer){
		this.slideViewer = slideViewer;
	}
	
	@Override
	public void execute() {
		slideViewer.clear();
		slideViewer.updateView();
	}

}