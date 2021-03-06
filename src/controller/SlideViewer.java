package controller;

import javax.swing.JOptionPane;
import model.Presentation;
import model.Slide;
import view.SlideViewerComponent;

/**
 * SlideViewer
 * <p>
 * The slide viewer holds a slideViewComponent and the current presentation. It
 * it is the receiver from our command pattern.
 * </p>
 */

public class SlideViewer {

	private SlideViewerComponent slideViewComponent;
	private Presentation presentation;

	public SlideViewer(Presentation presentation) {
		clear();
		this.presentation = presentation;
	}
	
	public void SetPresentation(Presentation presentation) {
		this.presentation = presentation;
		slideViewComponent.SetPresentation(presentation);
	}

	public Presentation GetPresentation() {
		return presentation;
	}


	public void setShowView(SlideViewerComponent slideViewerComponent) {
		this.slideViewComponent = slideViewerComponent;
		updateView();
	}

	// ga naar de vorige slide tenzij je aan het begin van de presentatie bent
	public void prevSlide() {
		if (presentation.getSlideNumber() > 0) {
			setSlideNumber(presentation.getSlideNumber() - 1);
		}
	}

	// Ga naar de volgende slide tenzij je aan het einde van de presentatie bent.
	public void nextSlide() {
		if (presentation.getSlideNumber() < (presentation.getSize() - 1)) {
			setSlideNumber(presentation.getSlideNumber() + 1);
		}
	}

	// go to given slide
	public void goToSlideNR() {
		String PAGENR = "Page number?";
		int pageNumber = getIntegerField(PAGENR);
		setSlideNumber(pageNumber - 1);
	}

	// Verwijder de presentatie, om klaar te zijn voor de volgende
	public void clear() {
		if (presentation != null) {
			presentation.clear();
			setSlideNumber(0);
		}

	}

	// togglet het weergeven in ��n keer (per slide)
	public void toggleShowAll() {
		presentation.getCurrentSlide().ToggleDrawAllitems();
	}

	// Geeft het volgende element weer (of de volgende slide indien alle elementen
	// reeds weergegeven zijn)
	public void nextItem() {
		Slide workSlide = presentation.getCurrentSlide();
		if (workSlide.GetNumberOfItemsToDraw() < workSlide.getSize()) {
			workSlide.IncrementItemsToDraw();
		} else {
			nextSlide();
		}
	}

	// Geeft het vorige item weer (of de vorige slide indien er geen elementen meer
	// zijn)
	public void previousItem() {
		Slide workSlide = presentation.getCurrentSlide();
		if (workSlide.GetNumberOfItemsToDraw() > 0 && !workSlide.isDrawAllItems()) {
			workSlide.DecrementItemsToDraw();
		} else {
			if (presentation.getSlideNumber() > 0) {
				prevSlide();
				showAll();
			} else {
				prevSlide();
			}
		}
	}

	// Geeft alle items in ��n keer weer, gaat naar de volgende slide indien alles
	// al zichtbaar is
	public void showAllOrNext() {
		Slide workSlide = presentation.getCurrentSlide();
		if (workSlide.GetNumberOfItemsToDraw() < workSlide.getSize() - 1) {
			showAll();
		} else {
			nextSlide();
		}
	}

	// gaat terug naar enkel de titel, of de vorige slide indien dat al het geval is
	public void clearItemsOrBack() {
		if (presentation.getCurrentSlide().GetNumberOfItemsToDraw() > 0) {
			clearSlide();
			// uitzondering: als de vlag drawAllItems staat kunnen we niet clearen!
			if (presentation.getCurrentSlide().isDrawAllItems()) {
				prevSlide();
			}
		} else {
			if (presentation.getSlideNumber() > 0) {
				prevSlide();
				showAll();
			} else {
				prevSlide();
			}
		}
	}

	// exit
	public void exit(int n) {
		System.exit(n);
	}

	// verander het huidige-slide-nummer en laat het aan het window weten.
	public void setSlideNumber(int number) {
		presentation.setSlideNumber(number);
		Slide workSlide = presentation.getCurrentSlide();

		if (workSlide == null)
			return;

		// draw only all items if the flag isn't set
		if (workSlide.isDrawAllItems()) {
			showAll();
		} else {
			clearSlide();
		}
		updateView();
	}

	// helper function, clears a slide
	private void clearSlide() {
		presentation.getCurrentSlide().SetitemsToDraw(0);
	}

	// helper function, shows all items
	private void showAll() {
		int itemCount = presentation.getCurrentSlide().getSize();
		presentation.getCurrentSlide().SetitemsToDraw(itemCount);
	}

	// helper function to request int input
	private int getIntegerField(String arg) {
		try {
			String questionStr = JOptionPane.showInputDialog((Object) arg);
			return Integer.parseInt(questionStr);
		} catch (NumberFormatException exc) {
			System.out.println("only numeric input");
			return -1;
		}
	}

	public void updateView() {
		if (slideViewComponent != null) {
			slideViewComponent.update(presentation.getTitle(), presentation.getCurrentSlide());
		}

	}

}
