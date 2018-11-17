package controller;

import view.SlideViewer;

public class CommandAllOrNext implements Command {
	
	private SlideViewer slideViewer;

	public CommandAllOrNext(SlideViewer slideViewer){
		this.slideViewer = slideViewer;
	}
	
	@Override
	public void execute() {
		slideViewer.showAllOrNext();
		slideViewer.updateView();
	}

}