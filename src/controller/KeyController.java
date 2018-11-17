package controller;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;


/** <p>This is the KeyController (KeyListener)</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
*/

public class KeyController extends KeyAdapter {

	private Command nextSlideCommand;
	private Command prevSlideCommand;
	private Command nextItemCommand;
	private Command prevItemCommand;
	private Command allItemsCommand;
	private Command clearItemsCommand;
	private Command exitCommand;	

	
	public KeyController(CommandFactory comFac){
		nextSlideCommand = comFac.createNextSlideCMD();
		prevSlideCommand = comFac.createPreviousSlideCMD();
		nextItemCommand = comFac.createNextItemCMD();
		prevItemCommand = comFac.createPreviousItemCMD();
		allItemsCommand = comFac.createShowAllCMD();
		clearItemsCommand = comFac.createClearItemsCMD();
		exitCommand = comFac.createExitCMD();
	}

	public void keyPressed(KeyEvent keyEvent) {
		
		Command selectedCommand = null;
		
		switch(keyEvent.getKeyCode()) {
			case KeyEvent.VK_PAGE_DOWN:
			case KeyEvent.VK_ENTER:
				//unconditional next slide
				selectedCommand = nextSlideCommand;
				break;				
			case KeyEvent.VK_DOWN:
			case '+':
				//next item / next slide (if all items shown)
				selectedCommand = nextItemCommand;
				break;
			case KeyEvent.VK_PAGE_UP:
			case KeyEvent.VK_BACK_SPACE:
				//unconditional previous slide
				selectedCommand = prevSlideCommand;
				break;
			case KeyEvent.VK_UP:
			case '-':
				//previous item / previous slide (if no items shown)
				selectedCommand = prevItemCommand;
				break;
			case 'q':
			case 'Q':
				//exit the application
				selectedCommand = exitCommand;
				break;
			case KeyEvent.VK_RIGHT:
				//next slide, all items
				selectedCommand = allItemsCommand;
				break;
			case KeyEvent.VK_LEFT:
				//previous slide, all items
				selectedCommand = clearItemsCommand;
				break;
			case KeyEvent.VK_A:
				//show all
				selectedCommand = allItemsCommand;
				break; // wordt nooit bereikt als het goed is
			default:
				//indien toch bereikt gaan we voor een propere exit
				selectedCommand = exitCommand;
				break;
		}
		
		CommandInvoker.executeCommand(selectedCommand);
		
	}
}
