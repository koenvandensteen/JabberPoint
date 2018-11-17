package controller;

import view.SlideViewer;

public class CommandClearOrBack implements Command {

	private SlideViewer slideViewer;
	
	public CommandClearOrBack(SlideViewer slideViewer){
		this.slideViewer = slideViewer;
	}
	
	@Override
	public void execute() {
		slideViewer.clearItemsOrBack();
		slideViewer.updateView();
	}

}
