package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

/**
 * <p>
 * This is the KeyController (KeyListener)
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

public class KeyController extends KeyAdapter {
	
	private CommandFactory comFac;
	
	public KeyController(CommandFactory comFac) {
		this.comFac = comFac;
	}

	public void keyPressed(KeyEvent keyEvent) {

		Command selectedCommand;

		switch (keyEvent.getKeyCode()) {
		case KeyEvent.VK_PAGE_DOWN:
		case KeyEvent.VK_ENTER:
			// unconditional next slide
			selectedCommand = comFac.createNextSlideCMD();
			break;
		case KeyEvent.VK_DOWN:
		case '+':
			// next item / next slide (if all items shown)
			selectedCommand = comFac.createNextItemCMD();
			break;
		case KeyEvent.VK_PAGE_UP:
		case KeyEvent.VK_BACK_SPACE:
			// unconditional previous slide
			selectedCommand = comFac.createPreviousSlideCMD();
			break;
		case KeyEvent.VK_UP:
		case '-':
			// previous item / previous slide (if no items shown)
			selectedCommand = comFac.createPreviousItemCMD();
			break;
		case 'q':
		case 'Q':
		case KeyEvent.VK_ESCAPE:
			// exit the application
			selectedCommand = comFac.createExitCMD();
			break;
		case KeyEvent.VK_RIGHT:
			// next slide, all items
			selectedCommand = comFac.createShowAllOrNextCMD();
			break;
		case KeyEvent.VK_LEFT:
			// previous slide, all items
			selectedCommand = comFac.createClearItemsOrBackCMD();
			break;
		case 't':
		case 'T':
			// show all
			selectedCommand =  comFac.createToggleItemsCMD();
			break;
		default:
			// indien we een niet geregistreerde toets lezen voeren we een commando uit dat
			// niets doet
			selectedCommand = comFac.createNullCMD();
			break;
		}

		CommandInvoker.executeCommand(selectedCommand);
	}
}
