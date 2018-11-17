package view;

import model.Presentation;

public class SlideViewer {

private SlideViewerComponent slideViewComponent;
private Presentation presentation;
	
//	public SlideViewer(SlideViewerComponent slideViewComponent, Presentation presentation) {
//		this.slideViewComponent = slideViewComponent;
//		this.presentation = presentation;
//	
//		clear();
//	}
	
	public SlideViewer(Presentation presentation) {
		this.presentation = presentation;
	
		clear();
	}
	
	public void setShowView(SlideViewerComponent slideViewerComponent) {
		this.slideViewComponent = slideViewerComponent;
	}
	
	// verander het huidige-slide-nummer en laat het aan het window weten.
	public void setSlideNumber(int number) {
		presentation.setSlideNumber(number);
		if (slideViewComponent != null) {
			slideViewComponent.update(presentation.getTitle(), presentation.getCurrentSlide());
			//slideViewComponent.update(presentation, presentation.getCurrentSlide());
		}
	}
	
	// ga naar de vorige slide tenzij je aan het begin van de presentatie bent
	public void prevSlide() {
		if(presentation.getSlideNumber()>0){
			setSlideNumber(presentation.getSlideNumber()-1);
		}	
	}
	
	// Ga naar de volgende slide tenzij je aan het einde van de presentatie bent.
	public void nextSlide() {
		if (presentation.getSlideNumber()< (presentation.getSize()-1)) {
			setSlideNumber(presentation.getSlideNumber() + 1);
		}
	}
	
	// Verwijder de presentatie, om klaar te zijn voor de volgende
	public void clear() {
		presentation.clear();
	}
	
	//exit
	public void exit(int n) {
		System.exit(n);
	}

}
