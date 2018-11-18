package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

import javax.swing.JComponent;
import javax.swing.JFrame;
import model.Slide;
import model.SlideItem;
import model.Presentation;

/**
 * <p>
 * SlideViewerComponent is a graphical component which can show slides.
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

public class SlideViewerComponent extends JComponent {

	private Slide slide; // de huidige slide
	private Font labelFont = null; // het font voor labels
	private Presentation presentation = null; // de presentatie
	private JFrame frame = null;

	private static final long serialVersionUID = 227L;

	private static final Color BGCOLOR = Color.white;
	private static final Color COLOR = Color.black;
	private static final String FONTNAME = "Dialog";
	private static final int FONTSTYLE = Font.BOLD;
	private static final int FONTHEIGHT = 10;
	private static final int XPOS = 1100;
	private static final int YPOS = 20;

	// changed VB
	ItemDrawerBridge itemDrawer;

	public SlideViewerComponent(JFrame frame, Presentation pres) {
		setBackground(BGCOLOR);
		this.presentation = pres;
		labelFont = new Font(FONTNAME, FONTSTYLE, FONTHEIGHT);
		this.frame = frame;
	}

	public void SetPresentation(Presentation pres) {
		this.presentation = pres;
	}

	public Dimension getPreferredSize() {
		return new Dimension(Slide.WIDTH, Slide.HEIGHT);
	}

	public void update(String title, Slide data) {
		if (data == null) {
			repaint();
			return;
		}
		this.slide = data;
		repaint();
		frame.setTitle(title);
	}

// teken de slide
	public void paintComponent(Graphics g) {
		g.setColor(BGCOLOR);
		g.fillRect(0, 0, getSize().width, getSize().height);
		if (presentation.getSlideNumber() < 0 || slide == null) {
			return;
		}
		g.setFont(labelFont);
		g.setColor(COLOR);
		g.drawString("Slide " + (1 + presentation.getSlideNumber()) + " of " + presentation.getSize(), XPOS, YPOS);
		Rectangle area = new Rectangle(0, YPOS, getWidth(), (getHeight() - YPOS));

		draw(g, area, this);
	}

	public void draw(Graphics g, Rectangle area, ImageObserver view) {
		float scale = getScale(area);
		int y = area.y;

		SlideItem slideItem;
		// De titel hoeft niet meer apart behandeld te worden
		slideItem = slide.getTitle();
		slideItem.draw(area.x, area.y, scale, g, view);
		y += slideItem.getBoundingBox(g, view, scale).height;

		for (int number = 0; number < slide.GetNumberOfItemsToDraw(); number++) {
			slideItem = slide.getSlideItems().elementAt(number);
			slideItem.draw(0, y, scale, g, view);
			y += slideItem.getBoundingBox(g, view, scale).height;
			
			for(int subNumber =0; subNumber < slideItem.GetSubItems().size();subNumber++)
			{
				SlideItem subslideItem = slideItem.GetSubItems().get(subNumber);
				subslideItem.draw(0, y, scale, g, view);
				y += subslideItem.getBoundingBox(g, view, scale).height;
			}
		}
	}
	


	// geef de schaal om de slide te kunnen tekenen
	private float getScale(Rectangle area) {
		return Math.min(((float) area.width) / ((float) Slide.WIDTH), ((float) area.height) / ((float) Slide.HEIGHT));
	}

}
