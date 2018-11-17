package controller;

import view.SlideViewer;

public class CommandNextSlide implements Command {
	
	private SlideViewer slideViewer;

	public CommandNextSlide(SlideViewer slideViewer){
		this.slideViewer = slideViewer;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		slideViewer.nextSlide();
	}

}
