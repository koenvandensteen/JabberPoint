package controller;

import java.awt.Frame;
import java.io.IOException;

import javax.swing.JOptionPane;

import model.AccessorFactory;
import model.Presentation;
import model.Writer;

public class CommandSave implements Command {
	
	protected static final String SAVEFILE = "dump.xml";	
	protected static final String IOEX = "IO Exception: ";
	protected static final String SAVEERR = "Save Error";

	private Frame parent;
	private Presentation presentation;

	public CommandSave(Frame parent, Presentation presentation){
		this.parent = parent;
		this.presentation = presentation;
	}
	
	@Override
	public void execute() {
		//we just hard code the XML factory here but could additional logic that just checks the file extension name and select a factory based on that.
		Writer writer = AccessorFactory.GetFactory(".xml").CreateWriter();
		try {
			writer.Write(presentation, SAVEFILE);
		} catch (IOException exc) {
			JOptionPane.showMessageDialog(parent, IOEX + exc, 
					SAVEERR, JOptionPane.ERROR_MESSAGE);
		}
	}

}