package model;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.awt.image.ImageObserver;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.TextItem;
import model.Style;

public class TextItemDrawer extends ItemDrawerBridge {

	@Override
	// teken het item
		public void draw(int x, int y, float scale, Graphics g, ImageObserver o, SlideItem text)
	{
		TextItem itemToDraw = (TextItem) text;	
		Style myStyle = Style.getStyle(itemToDraw.getLevel());
				
			if (itemToDraw == null || itemToDraw.getText().length() == 0) {
				return;
			}
			List<TextLayout> layouts = getLayouts(g, myStyle, scale,itemToDraw.getText());
			Point pen = new Point(x + (int)(myStyle.indent * scale), 
					y + (int) (myStyle.leading * scale));
			Graphics2D g2d = (Graphics2D)g;
			g2d.setColor(myStyle.color);
			Iterator<TextLayout> it = layouts.iterator();
			while (it.hasNext()) {
				TextLayout layout = it.next();
				pen.y += layout.getAscent();
				layout.draw(g2d, pen.x, pen.y);
				pen.y += layout.getDescent();
			}
	}
	
	private List<TextLayout> getLayouts(Graphics g, Style s, float scale,String text) {
		List<TextLayout> layouts = new ArrayList<TextLayout>();
		AttributedString attrStr = getAttributedString(s, scale, text);
    	Graphics2D g2d = (Graphics2D) g;
    	FontRenderContext frc = g2d.getFontRenderContext();
    	LineBreakMeasurer measurer = new LineBreakMeasurer(attrStr.getIterator(), frc);
    	float wrappingWidth = (Slide.WIDTH - s.indent) * scale;
    	while (measurer.getPosition() < text.length()) {
    		TextLayout layout = measurer.nextLayout(wrappingWidth);
    		layouts.add(layout);
    	}
    	return layouts;
	}

	// geef de AttributedString voor het item
		public AttributedString getAttributedString(Style style, float scale, String text) {
			AttributedString attrStr = new AttributedString(text);
			attrStr.addAttribute(TextAttribute.FONT, style.getFont(scale), 0, text.length());
			return attrStr;
		}
}
