package model;

import java.io.IOException;

public class DemoReader extends Reader {

	@Override
	public Presentation Read(String fileName) throws IOException {
		Presentation presentation = new Presentation();
		
		presentation.setTitle("Demo Presentation");
		Slide slide;
		slide = new Slide();
		slide.setTitle("JabberPoint");
		slide.append(1, "Het Java Presentatie Tool");
		slide.append(2, "Copyright (c) 1996-2000: Ian Darwin");
		slide.append(2, "Copyright (c) 2000-now:");
		slide.append(2, "Gert Florijn en Sylvia Stuurman");
		//slide.append(4, "Aangepast door V. Boerjan en K. van den Steen");
		slide.append(4, "JabberPoint aanroepen zonder bestandsnaam");
		slide.append(4, "laat deze presentatie zien");
		slide.append(1, "Navigeren:");
		slide.append(4, "Volgende item*: down-arrow");
		slide.append(4, "Alle items*: right-arrow");
	    slide.append(4, "Vorige item**: up-arrow");
	    slide.append(4, "Clear slide**: left-arrow");
	    slide.append(4, "Volgende slide: PgDn of Enter");
	    slide.append(4, "Vorige slide: PgUp of back-space");
		slide.append(4, "Toggle item-per-item laden: t of T");
	    slide.append(4, "Stoppen: escape, q of Q");
		slide.append(4, "* als alle items weergegeven zijn zal de volgende slide geladen worden");
		slide.append(4, "** als er geen items zijn zal de vorige slide geladen worden");
		presentation.append(slide);

		slide = new Slide();
		slide.setTitle("Demonstratie van levels en stijlen");
		slide.append(1, "Level 1");
		slide.append(2, "Level 2");
		slide.append(1, "Nogmaals level 1");
		slide.append(1, "Level 1 heeft stijl nummer 1");
		slide.append(2, "Level 2 heeft stijl nummer 2");
		slide.append(3, "Zo ziet level 3 er uit");
		slide.append(4, "En dit is level 4");
		presentation.append(slide);

		slide = new Slide();
		slide.setTitle("De derde slide");
		slide.append(1, "Om een nieuwe presentatie te openen,");
		slide.append(2, "gebruik File->Open uit het menu.");
		slide.append(1, " ");
		slide.append(1, "Dit is het einde van de presentatie.");
		slide.append(new BitmapItem(1, "JabberPoint.jpg"));
		presentation.append(slide);
		
		return presentation;
	}

}
