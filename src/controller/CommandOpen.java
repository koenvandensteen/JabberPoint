package controller;

import java.awt.Frame;
import java.io.IOException;

import javax.swing.JOptionPane;

import model.Accessor;
import model.Presentation;
import model.XMLAccessor;
import view.SlideViewer;

public class CommandOpen implements Command {
	
	protected static final String TESTFILE = "test.xml";
	protected static final String IOEX = "IO Exception: ";
	protected static final String LOADERR = "Load Error";
	
	private SlideViewer slideViewer;
	private Frame parent;
	private Presentation presentation;

	public CommandOpen(SlideViewer slideViewer, Frame parent, Presentation presentation) {
		this.slideViewer = slideViewer;
		this.parent = parent;
		this.presentation = presentation;
	}

	@Override
	public void execute() {
		slideViewer.clear();
		Accessor xmlAccessor = new XMLAccessor();
		try {
			xmlAccessor.loadFile(presentation, TESTFILE);
			slideViewer.setSlideNumber(0);
		} catch (IOException exc) {
			JOptionPane.showMessageDialog(parent, IOEX + exc, 
 			LOADERR, JOptionPane.ERROR_MESSAGE);
		}
		parent.repaint();
	}

}
