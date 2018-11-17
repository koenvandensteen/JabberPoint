package controller;

import view.SlideViewer;

public class CommandSlideByNumber implements Command {

	private SlideViewer slideViewer;

	public CommandSlideByNumber(SlideViewer slideViewer){
		this.slideViewer = slideViewer;
	}
	
	@Override
	public void execute() {
		slideViewer.goToSlideNR();		
	}

}
