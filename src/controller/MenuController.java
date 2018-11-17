package controller;
import java.awt.MenuBar;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import model.Presentation;
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
	
	//errors
//	protected static final String TESTFILE = "test.xml";
//	protected static final String SAVEFILE = "dump.xml";
//	protected static final String IOEX = "IO Exception: ";
//	protected static final String LOADERR = "Load Error";
//	protected static final String SAVEERR = "Save Error";
	
	//menu expansion
	protected static final String NEXT_ITEM = "Next item";
	protected static final String PREV_ITEM = "Prev item";
	protected static final String ALL_ITEM = "All items";
	protected static final String TOGGLE = "Toggle item navigation";
	protected static final String NUM_ITEMS = "Display #items";
	
	//Commands	
	private Command nextSlideCommand;
	private Command prevSlideCommand;
	private Command nextItemCommand;
	private Command prevItemCommand;
	private Command showAllItemsCommand;
	private Command exitCommand;	
	private Command slideNumCommand;
	
	private Command openCommand;
	private Command saveCommand;
	private Command newCommand;
	private Command showAboutBoxCommand;
	private Command toggleAllItemsCommand;
	private Command numItemsCommand;


	//public MenuController(Frame frame, Presentation pres) {
	public MenuController(Frame frame, SlideViewer slv, Presentation pres, CommandFactory comFac){
		
		//commands
		//nextSlideCommand = new CommandNextSlide(slideViewer);
		nextSlideCommand = comFac.createNextSlideCMD();
		prevSlideCommand = comFac.createPreviousSlideCMD();
		nextItemCommand = comFac.createNextItemCMD();
		prevItemCommand = comFac.createPreviousItemCMD();
		showAllItemsCommand = comFac.createShowAllCMD();
		exitCommand = comFac.createExitCMD();
		slideNumCommand = comFac.createSlideByNumberCMD();
		
		openCommand = comFac.createOpenCMD();
		saveCommand = comFac.createSaveCMD();
		newCommand = comFac.createNewCMD();
		showAboutBoxCommand = comFac.createShowAboutBoxCMD();
		toggleAllItemsCommand = comFac.createToggleItemsCMD();
		numItemsCommand = comFac.createAmountItemsCMD();
		//
		
		MenuItem menuItem;
		
		//
		//FILE menu
		//
		Menu fileMenu = new Menu(FILE);
		fileMenu.add(menuItem = mkMenuItem(OPEN));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Command c = openCommand;
				CommandInvoker.executeCommand(c);
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
				Command c = saveCommand;
				CommandInvoker.executeCommand(c);
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
