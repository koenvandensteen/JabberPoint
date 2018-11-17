package controller;

import view.SlideViewer;

public class CommandNextSlide implements Command {
	
	private SlideViewer slideViewer;

	public CommandNextSlide(SlideViewer slideViewer){
		this.slideViewer = slideViewer;
	}
	
	@Override
	public void execute() {
		slideViewer.nextSlide();
	}

}
