package model;

import java.util.Vector;

/**
 * <p>
 * Slide holds all the needed information to draw Slides.
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

public class Slide {
	public final static int WIDTH = 1200;
	public final static int HEIGHT = 800;
	/* Geen String meer maar een TextItem */
	protected TextItem title; // de titel wordt apart bewaard
	protected Vector<SlideItem> items; // de slide-items worden in een Vector bewaard

	private int numberofItemsToDraw = 0;
	private boolean drawAllItem = false;

	public boolean isDrawAllItems() {
		return drawAllItem;
	}

	public int GetNumberOfItemsToDraw() {
		return drawAllItem ? items.size() : numberofItemsToDraw;
	}

	public void IncrementItemsToDraw() {
		++numberofItemsToDraw;
	}

	public void DecrementItemsToDraw() {
		--numberofItemsToDraw;
	}

	public void SetitemsToDraw(int nritems) {
		numberofItemsToDraw = nritems <= items.size() ? nritems : items.size();
	}

	public void ToggleDrawAllitems() {
		drawAllItem = !drawAllItem;
	}

	public Slide() {
		items = new Vector<SlideItem>();
	}

	// Voeg een SlideItem toe
	public void append(SlideItem anItem) {
		items.addElement(anItem);
	}

//	// geef de titel van de slide
//	public String getTitle() {
//		/* Geef nu de tekst van het TextItem terug */
//		return title.getText();
//	}
	public TextItem getTitle() {
		return title;
	}

	// verander de titel van de slide
	public void setTitle(String newTitle) {
		/* Creëer nu een TextItem op basis van de nieuwe titel */
		title = new TextItem(0, newTitle);
	}

	// Maak een TextItem van String, en voeg het TextItem toe
	public void append(int level, String message) {
		append(SlideItemFactory.GetSlideItemFactory("text").CreateSlideItem(level, message));
	}

	// geef het betreffende SlideItem
	public SlideItem getSlideItem(int number) {
		return (SlideItem) items.elementAt(number);
	}

	// geef alle SlideItems in een Vector
	public Vector<SlideItem> getSlideItems() {
		return items;
	}

	// geef de afmeting van de Slide
	public int getSize() {
		return items.size();
	}
}
