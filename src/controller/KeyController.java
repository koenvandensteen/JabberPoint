package controller;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import view.SlideViewer;


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
	//private Presentation presentation; // Er worden commando's gegeven aan de presentatie
	private SlideViewer slideViewer;
	//private Command command;
	
//	public KeyController(Presentation p) {
//		presentation = p;
//	}
	
	Command nextSlideCommand = new CommandNextSlide(slideViewer);
	Command prevSlideCommand = new CommandPreviousSlide(slideViewer);
	//not used with KeyController
	//Command slideNumCommand = new CommandSlideByNumber(slideViewer);
	Command nextItemCommand = new CommandNextItem(slideViewer);
	Command prevItemCommand = new CommandPreviousItem(slideViewer);
	Command allItemsCommand = new CommandShowAllItems(slideViewer);
	Command exitCommand = new CommandExit(slideViewer);	
	
	public KeyController(SlideViewer slideViewer){
		this.slideViewer = slideViewer;
	}

	public void keyPressed(KeyEvent keyEvent) {
		
		Command selectedCommand = null;
		
		switch(keyEvent.getKeyCode()) {
			case KeyEvent.VK_PAGE_DOWN:
			case KeyEvent.VK_DOWN:
			case KeyEvent.VK_ENTER:
			case '+':
				//next item / next slide (if all items shown)
				selectedCommand = nextItemCommand;
				break;
			case KeyEvent.VK_PAGE_UP:
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
				selectedCommand = nextSlideCommand;
				break;
			case KeyEvent.VK_LEFT:
				//previous slide, all items
				selectedCommand = prevSlideCommand;
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
