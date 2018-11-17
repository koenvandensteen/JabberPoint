package view;

import javax.swing.JOptionPane;

import model.Presentation;
import model.Slide;

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
		Slide workSlide = presentation.getCurrentSlide();
		//draw only all items if the flag isn't set
		if(workSlide.isDrawAllItems()){
			workSlide.SetitemsToDraw(workSlide.getSize());
		}
		else{
			workSlide.SetitemsToDraw(0);
		}		
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
	
	public void goToSlideNR(){
		String PAGENR = "Page number?";		
		String pageNumberStr = JOptionPane.showInputDialog((Object)PAGENR);
		
		if(pageNumberStr == null) // cancel is pressed
			return;
		
		try {			
		int pageNumber = Integer.parseInt(pageNumberStr);
		setSlideNumber(pageNumber - 1);
		}
		catch (NumberFormatException exc){
			System.out.println("only numeric input");
		}
		

	}
	
	// Verwijder de presentatie, om klaar te zijn voor de volgende
	public void clear() {
		presentation.clear();
	}
	
	// Geeft alle items in één keer weer
	public void showAllOrNext(){
		Slide workSlide = presentation.getCurrentSlide();
		if(workSlide.GetNumberOfItemsToDraw() < workSlide.getSize() - 1){
			showAll();
		}
		else{
			nextSlide();
		}
	}
	
	// togglet het weergeven in één keer (per slide)
	public void toggleShowAll(){
		presentation.getCurrentSlide().ToggleDrawAllitems();
	}
	
	// Geeft het volgende element weer (of de volgende slide indien alle elementen reeds weergegeven zijn)
	public void nextItem(){
		Slide workSlide = presentation.getCurrentSlide();
		if(workSlide.GetNumberOfItemsToDraw() < workSlide.getSize()){
			workSlide.IncrementItemsToDraw();
		}
		else{
			nextSlide();
		}
	}
	
	// Geeft het vorige item weer (of de vorige slide indien er geen elementen meer zijn)
	public void previousItem(){
		Slide workSlide = presentation.getCurrentSlide();
		if(workSlide.GetNumberOfItemsToDraw() > 0 && !workSlide.isDrawAllItems()){
			workSlide.DecrementItemsToDraw();
		}
		else{
			prevSlide();
			showAll();
		}
	}
	
	public void clearItemsOrBack(){
		if(presentation.getCurrentSlide().GetNumberOfItemsToDraw() > 0){
			clearSlide();
		}
		else{
			prevSlide();
			showAll();
		}
	}
	
	private void clearSlide(){
		presentation.getCurrentSlide().SetitemsToDraw(0);
	}
	
	private void showAll(){
		int itemCount = presentation.getCurrentSlide().getSize();
		presentation.getCurrentSlide().SetitemsToDraw(itemCount);
	}
		
	//exit
	public void exit(int n) {
		System.exit(n);
	}

}
