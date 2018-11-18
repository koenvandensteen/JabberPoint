package controller;

import java.awt.Frame;

import view.SlideViewer;

public class CommandFactory {
	
	private SlideViewer slideViewer;
	private Frame parent;
	
	public CommandFactory(Frame parent,SlideViewer slideViewer){
		this.parent = parent;
		this.slideViewer = slideViewer;
	}
	
	public Command createNextSlideCMD(){
		return new CommandNextSlide(slideViewer);
	}
	
	public Command createPreviousSlideCMD(){
		return new CommandPreviousSlide(slideViewer);
	}
	
	public Command createNextItemCMD(){
		return new CommandNextItem(slideViewer);
	}
	
	public Command createPreviousItemCMD(){
		return new CommandPreviousItem(slideViewer);
	}
	
	public Command createShowAllCMD(){
		return new CommandAllOrNext(slideViewer);
	}
	
	public Command createClearItemsCMD(){
		return new CommandClearOrBack(slideViewer);
	}
	
	public Command createExitCMD(){
		return new CommandExit(slideViewer);	
	}
	
	public Command createSlideByNumberCMD(){
		return new CommandSlideByNumber(slideViewer);
	}

	public Command createOpenCMD(){
		return new CommandOpen(slideViewer, parent);
	}
	
	public Command createSaveCMD(){
		return new CommandSave(parent, slideViewer.GetPresentation());
	}
	
	public Command createNewCMD(){
		return new CommandNew(slideViewer);
	}
	
	public Command createShowAboutBoxCMD(){
		return new  CommandShowAboutBox(parent);
	}
	
	public Command createToggleItemsCMD(){
		return new CommandToggleAllItems(slideViewer);
	}
	
	public Command createAmountItemsCMD(){
		return new CommandAmountItems(slideViewer);
	}

}
