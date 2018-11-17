package controller;

import view.SlideViewer;

public class CommandToggleAllItems implements Command {
	
	private SlideViewer slideViewer;

	public CommandToggleAllItems(SlideViewer slideViewer){
		this.slideViewer = slideViewer;
	}
	
	@Override
	public void execute() {
		slideViewer.toggleShowAll();
		slideViewer.updateView();
	}

}