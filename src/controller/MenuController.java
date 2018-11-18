package controller;

import java.awt.MenuBar;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * <p>
 * The menu Controller
 * </p>
 * 
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

	// menu expansion
	protected static final String NEXT_ITEM = "Next item";
	protected static final String PREV_ITEM = "Prev item";
	protected static final String ALL_ITEM = "All items/Next slide";
	protected static final String CLR_ITEM = "Clear items/Prev slide";
	protected static final String TOGGLE = "Toggle item navigation";
	protected static final String NUM_ITEMS = "Display #items";
	
	private CommandFactory commandFactory;
	
	public MenuController(Frame frame, SlideViewer slv, CommandFactory comFac) {

		this.commandFactory = comFac;
		MenuItem menuItem;

		//
		// FILE menu
		//
		Menu fileMenu = new Menu(FILE);
		fileMenu.add(menuItem = mkMenuItem(OPEN));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				CommandInvoker.executeCommand(commandFactory.createOpenCMD());
			}
		});
		// NEW
		fileMenu.add(menuItem = mkMenuItem(NEW));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				CommandInvoker.executeCommand(commandFactory.createNewCMD());
			}
		});
		// SAVE
		fileMenu.add(menuItem = mkMenuItem(SAVE));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CommandInvoker.executeCommand(commandFactory.createSaveCMD());
			}
		});
		// EXIT
		fileMenu.addSeparator();
		fileMenu.add(menuItem = mkMenuItem(EXIT));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				CommandInvoker.executeCommand(commandFactory.createExitCMD());
			}
		});
		add(fileMenu);

		//
		// VIEW menu
		//
		Menu viewMenu = new Menu(VIEW);
		// next slide
		viewMenu.add(menuItem = mkMenuItem(NEXT));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				CommandInvoker.executeCommand(commandFactory.createNextSlideCMD());
			}
		});
		// previous slide
		viewMenu.add(menuItem = mkMenuItem(PREV));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				CommandInvoker.executeCommand(commandFactory.createPreviousSlideCMD());
			}
		});
		// go to slide
		viewMenu.add(menuItem = mkMenuItem(GOTO));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				CommandInvoker.executeCommand(commandFactory.createSlideByNumberCMD());
			}
		});
		// next slide
		viewMenu.add(menuItem = mkMenuItem(NEXT_ITEM));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				CommandInvoker.executeCommand(commandFactory.createNextItemCMD());
			}
		});
		// previous item
		viewMenu.add(menuItem = mkMenuItem(PREV_ITEM));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				CommandInvoker.executeCommand(commandFactory.createPreviousItemCMD());
			}
		});
		// show all items
		viewMenu.add(menuItem = mkMenuItem(ALL_ITEM));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				CommandInvoker.executeCommand(commandFactory.createShowAllOrNextCMD());
			}
		});
		// show all items
		viewMenu.add(menuItem = mkMenuItem(CLR_ITEM));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				CommandInvoker.executeCommand(commandFactory.createClearItemsOrBackCMD());
			}
		});
		// toggle all items
		viewMenu.add(menuItem = mkMenuItem(TOGGLE));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				CommandInvoker.executeCommand(commandFactory.createToggleItemsCMD());
			}
		});
		// show a number of items
		viewMenu.add(menuItem = mkMenuItem(NUM_ITEMS));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				CommandInvoker.executeCommand(commandFactory.createAmountItemsCMD());
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
				CommandInvoker.executeCommand(commandFactory.createShowAboutBoxCMD());
			}
		});
		setHelpMenu(helpMenu); // nodig for portability (Motif, etc.).
	}

// een menu-item aanmaken
	public MenuItem mkMenuItem(String name) {
		return new MenuItem(name, new MenuShortcut(name.charAt(0)));
	}
}
