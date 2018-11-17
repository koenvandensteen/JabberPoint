package controller;

import java.awt.Frame;

import model.Presentation;
import view.SlideViewer;

public class CommandFactory {
	
	private SlideViewer slideViewer;
	private Frame parent;
	private Presentation presentation;
	
	public CommandFactory(Frame parent,SlideViewer slideViewer, Presentation presentation){
		this.parent = parent;
		this.slideViewer = slideViewer;
		this.presentation = presentation;
		System.out.println("presentation weghalen? (ComFac)");
	}
	
	public Command createNextSlideCMD(){
		return new CommandNextSlide(slideViewer);
	}
	
	public Command createPreviousSlideCMD(){
		return new CommandPreviousSlide(slideViewer);
	}
	
	public Command createNextItemCMD(){
		return new CommandNextItem(slideViewer, parent);
	}
	
	public Command createPreviousItemCMD(){
		return new CommandPreviousItem(slideViewer, parent);
	}
	
	public Command createShowAllCMD(){
		return new CommandAllOrNext(slideViewer, parent);
	}
	
	public Command createClearItemsCMD(){
		return new CommandClearOrBack(slideViewer, parent);
	}
	
	public Command createExitCMD(){
		return new CommandExit(slideViewer);	
	}
	
	public Command createSlideByNumberCMD(){
		return new CommandSlideByNumber(slideViewer);
	}

	public Command createOpenCMD(){
		return new CommandOpen(slideViewer, parent, presentation);
	}
	
	public Command createSaveCMD(){
		return new CommandSave(parent, presentation);
	}
	
	public Command createNewCMD(){
		return new CommandNew(slideViewer, parent);
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
