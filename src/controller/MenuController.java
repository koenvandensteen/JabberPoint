package controller;
import java.awt.MenuBar;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JOptionPane;
import model.Presentation;
import model.Accessor;
import model.XMLAccessor;
import view.AboutBox;
import view.SlideViewer;

/** <p>De controller voor het menu</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */
public class MenuController extends MenuBar {
	
	private Frame parent; // het frame, alleen gebruikt als ouder voor de Dialogs
	private Presentation presentation; // Er worden commando's gegeven aan de presentatie
	private SlideViewer slideViewer;
	
	private static final long serialVersionUID = 227L;
	
	protected static final String ABOUT = "About";
	protected static final String FILE = "File";
	protected static final String EXIT = "Exit";
	protected static final String GOTO = "Go to";
	protected static final String HELP = "Help";
	protected static final String NEW = "New";
	protected static final String NEXT = "Next slide";
	protected static final String OPEN = "Open";
	protected static final String PAGENR = "Page number?";
	protected static final String PREV = "Prev slide";
	protected static final String SAVE = "Save";
	protected static final String VIEW = "View";
	
	protected static final String TESTFILE = "test.xml";
	protected static final String SAVEFILE = "dump.xml";
	
	protected static final String IOEX = "IO Exception: ";
	protected static final String LOADERR = "Load Error";
	protected static final String SAVEERR = "Save Error";
	
	//expansion
	protected static final String NEXT_ITEM = "Next item";
	protected static final String PREV_ITEM = "Prev item";
	protected static final String ALL_ITEM = "All items";
	protected static final String TOGGLE = "Toggle item navigation";
	protected static final String NUM_ITEMS = "Display #items";
	
	//Commands
	Command nextSlideCommand;
	Command prevSlideCommand;
	Command nextItemCommand;
	Command prevItemCommand;
	Command showAllItemsCommand;
	Command exitCommand;	
	Command slideNumCommand;
	
	Command saveCommand;
	Command newCommand;
	Command showAboutBoxCommand;
	Command toggleAllItemsCommand;
	Command numItemsCommand;


	//public MenuController(Frame frame, Presentation pres) {
	public MenuController(Frame frame, SlideViewer slv, Presentation pres){
		parent = frame;
		presentation = pres;
		slideViewer = slv;
		
		//commands
		nextSlideCommand = new CommandNextSlide(slideViewer);
		prevSlideCommand = new CommandPreviousSlide(slideViewer);	
		nextItemCommand = new CommandNextItem(slideViewer);
		prevItemCommand = new CommandPreviousItem(slideViewer);
		showAllItemsCommand = new CommandShowAllItems(slideViewer);
		exitCommand = new CommandExit(slideViewer);	
		slideNumCommand = new CommandSlideByNumber(slideViewer);
		
		saveCommand = new CommandSave(slideViewer);
		newCommand = new CommandNew(slideViewer, parent);
		showAboutBoxCommand = new CommandShowAboutBox(slideViewer, parent);
		toggleAllItemsCommand = new CommandToggleAllItems(slideViewer);
		numItemsCommand = new CommandAmountItems(slideViewer);
		//
		
		MenuItem menuItem;
		
		//
		//FILE menu
		//
		Menu fileMenu = new Menu(FILE);
		fileMenu.add(menuItem = mkMenuItem(OPEN));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				//presentation.clear();
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
		} );
		// NEW
		fileMenu.add(menuItem = mkMenuItem(NEW));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Command c = newCommand;
				CommandInvoker.executeCommand(c);				
			}
		});
		// SAVE
		fileMenu.add(menuItem = mkMenuItem(SAVE));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//execute commando
				Command c = saveCommand;
				CommandInvoker.executeCommand(c);
				//oude code hieronder
				Accessor xmlAccessor = new XMLAccessor();
				try {
					xmlAccessor.saveFile(presentation, SAVEFILE);
				} catch (IOException exc) {
					JOptionPane.showMessageDialog(parent, IOEX + exc, 
							SAVEERR, JOptionPane.ERROR_MESSAGE);
				}
				//einde oude code
			}
		});
		//EXIT
		fileMenu.addSeparator();
		fileMenu.add(menuItem = mkMenuItem(EXIT));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Command c = exitCommand;
				CommandInvoker.executeCommand(c);
			}
		});
		add(fileMenu);
		
		//
		// VIEW menu
		//
		Menu viewMenu = new Menu(VIEW);
		//next slide
		viewMenu.add(menuItem = mkMenuItem(NEXT));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Command c = nextSlideCommand;
				CommandInvoker.executeCommand(c);
			}
		});
		//previous slide
		viewMenu.add(menuItem = mkMenuItem(PREV));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Command c = prevSlideCommand;
				CommandInvoker.executeCommand(c);
			}
		});
		//go to slide
		viewMenu.add(menuItem = mkMenuItem(GOTO));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Command c = slideNumCommand;
				CommandInvoker.executeCommand(c);
			}
		});
		//next slide
		viewMenu.add(menuItem = mkMenuItem(NEXT_ITEM));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Command c = nextItemCommand;
				CommandInvoker.executeCommand(c);
			}
		});
		//previous item
		viewMenu.add(menuItem = mkMenuItem(PREV_ITEM));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Command c = prevItemCommand;
				CommandInvoker.executeCommand(c);
			}
		});
		//show all items
		viewMenu.add(menuItem = mkMenuItem(ALL_ITEM));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Command c = showAllItemsCommand;
				CommandInvoker.executeCommand(c);
			}
		});
		//toggle all items
		viewMenu.add(menuItem = mkMenuItem(TOGGLE));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Command c = toggleAllItemsCommand;
				CommandInvoker.executeCommand(c);
			}
		});
		//show a number of items
		viewMenu.add(menuItem = mkMenuItem(NUM_ITEMS));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Command c = numItemsCommand;
				CommandInvoker.executeCommand(c);
			}
		});
		add(viewMenu);
		
		
		//
		// HELP menu
		//
		Menu helpMenu = new Menu(HELP);
		helpMenu.add(menuItem = mkMenuItem(ABOUT));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Command c = showAboutBoxCommand;
				CommandInvoker.executeCommand(c);
			}
		});
		setHelpMenu(helpMenu);		// nodig for portability (Motif, etc.).
	}
	
	

// een menu-item aanmaken
	public MenuItem mkMenuItem(String name) {
		return new MenuItem(name, new MenuShortcut(name.charAt(0)));
	}
}
