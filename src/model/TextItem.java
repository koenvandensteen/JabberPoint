package model;

import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.TextLayout;
import java.awt.font.TextAttribute;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.text.AttributedString;
import java.util.List;

import view.TextItemDrawer;

import java.util.Iterator;
import java.util.ArrayList;

/**
 * TextItem
 * <p>
 * Text item is a slide item which contains only text.
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

public class TextItem extends SlideItem {
	private String text;

	private static final String EMPTYTEXT = "No Text Given";

// een textitem van level level, met als tekst string
	public TextItem(int level, String string) {
		super(level);
		text = string;
		itemDrawer = new TextItemDrawer();
		styleStrategy = new StyleDefault();
	}

// een leeg textitem
	public TextItem() {
		this(0, EMPTYTEXT);
	}

// Geef de tekst
	public String getText() {
		return text == null ? "" : text;
	}

// geef de AttributedString voor het item
	public AttributedString getAttributedString(float scale) {
		AttributedString attrStr = new AttributedString(getText());
		attrStr.addAttribute(TextAttribute.FONT, itemStyle.getFont(scale), 0, text.length());
		return attrStr;
	}

// geef de bounding box van het item
	public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale) {

		List<TextLayout> layouts = getLayouts(g, scale);
		int xsize = 0, ysize = (int) (itemStyle.leading * scale);
		Iterator<TextLayout> iterator = layouts.iterator();

		while (iterator.hasNext()) {
			TextLayout layout = iterator.next();
			Rectangle2D bounds = layout.getBounds();
			if (bounds.getWidth() > xsize) {
				xsize = (int) bounds.getWidth();
			}
			if (bounds.getHeight() > 0) {
				ysize += bounds.getHeight();
			}
			ysize += layout.getLeading() + layout.getDescent();
		}

		return new Rectangle((int) (itemStyle.indent * scale), 0, xsize, ysize);
	}

	public List<TextLayout> getLayouts(Graphics g, float scale) {
		List<TextLayout> layouts = new ArrayList<TextLayout>();
		AttributedString attrStr = getAttributedString(scale);
		Graphics2D g2d = (Graphics2D) g;
		FontRenderContext frc = g2d.getFontRenderContext();
		LineBreakMeasurer measurer = new LineBreakMeasurer(attrStr.getIterator(), frc);
		float wrappingWidth = (Slide.WIDTH - itemStyle.indent) * scale;
		while (measurer.getPosition() < getText().length()) {
			TextLayout layout = measurer.nextLayout(wrappingWidth);
			layouts.add(layout);
		}
		return layouts;
	}

	public String toString() {
		return "TextItem[" + getLevel() + "," + getText() + "]";
	}
}
