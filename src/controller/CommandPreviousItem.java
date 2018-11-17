package controller;

import view.SlideViewer;

public class CommandPreviousItem implements Command {
	
	private SlideViewer slideViewer;

	public CommandPreviousItem(SlideViewer slideViewer){
		this.slideViewer = slideViewer;
	}
	
	@Override
	public void execute() {
		slideViewer.previousItem();
		slideViewer.updateView();
	}

}