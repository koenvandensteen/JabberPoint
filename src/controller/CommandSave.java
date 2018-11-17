package controller;

import view.SlideViewer;

public class CommandSave implements Command {
	
	SlideViewer slideViewer;

	public CommandSave(SlideViewer slideViewer){
		this.slideViewer = slideViewer;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("TODO: save command");
	}

}