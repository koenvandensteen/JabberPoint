package controller;

import view.SlideViewer;

public class CommandNextItem implements Command {
	
	private SlideViewer slideViewer;

	public CommandNextItem(SlideViewer slideViewer){
		this.slideViewer = slideViewer;
	}
	
	@Override
	public void execute() {
		slideViewer.nextItem();
		slideViewer.updateView();
	}

}