package controller;

import view.SlideViewer;

public class CommandPreviousSlide implements Command {
	
	private SlideViewer slideViewer;

	public CommandPreviousSlide(SlideViewer slideViewer){
		this.slideViewer = slideViewer;
	}
	
	@Override
	public void execute() {
		slideViewer.prevSlide();
	}

}