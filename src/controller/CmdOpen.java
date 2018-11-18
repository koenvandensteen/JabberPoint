package controller;

import java.awt.Frame;
import java.io.IOException;

import javax.swing.JOptionPane;

import model.AccessorFactory;
import model.Reader;
import view.SlideViewer;

/**
 * CommandOpen
 * <p>
 * Command that opens a new slide.
 * </p>
 */
public class CmdOpen implements Command {

	protected static final String TESTFILE = "test.xml";
	protected static final String IOEX = "IO Exception: ";
	protected static final String LOADERR = "Load Error";

	private SlideViewer slideViewer;
	private Frame parent;

	public CmdOpen(SlideViewer slideViewer, Frame parent) {
		this.slideViewer = slideViewer;
		this.parent = parent;
	}

	@Override
	public void execute() {
		slideViewer.clear();
		Reader reader = AccessorFactory.GetFactory(TESTFILE).CreateReader();
		try {
			slideViewer.SetPresentation(reader.Read(TESTFILE));
			slideViewer.setSlideNumber(0);
		} catch (IOException exc) {
			JOptionPane.showMessageDialog(parent, IOEX + exc, LOADERR, JOptionPane.ERROR_MESSAGE);
		}
		parent.repaint();
	}

}
