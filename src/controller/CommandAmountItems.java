package controller;

import view.SlideViewer;

public class CommandAmountItems implements Command {

	private SlideViewer slideViewer;

	public CommandAmountItems(SlideViewer slideViewer){
		this.slideViewer = slideViewer;
	}
	
	@Override
	public void execute() {
		slideViewer.goToItemNR();
	}

}
