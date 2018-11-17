package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.TextItem;
import model.SlideItem;
import model.Style;

public class TextItemDrawer extends ItemDrawerBridge {

	@Override
	// teken het item
		public void draw(int x, int y, float scale, Graphics g, ImageObserver o, SlideItem text)
	{
		TextItem itemToDraw = (TextItem) text;	
	
		Style myStyle = text.GetStyle();
				
			if (itemToDraw == null || itemToDraw.getText().length() == 0) {
				return;
			}
			
			List<TextLayout> layouts =  itemToDraw.getLayouts(g,scale);
			
			Point pen = new Point(x + (int)(myStyle.getIndent() * scale), 
					y + (int) (myStyle.getLeading() * scale));
			
			Graphics2D g2d = (Graphics2D)g;
			
			g2d.setColor(myStyle.getColor());
			
			Iterator<TextLayout> it = layouts.iterator();
			
			while (it.hasNext()) {
				TextLayout layout = it.next();
				pen.y += layout.getAscent();
				layout.draw(g2d, pen.x, pen.y);
				pen.y += layout.getDescent();
			}
	}
	
		// geef de bounding box van het item
	@Override
		public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, SlideItem text) {
			
			TextItem itemToDraw = (TextItem) text;	
			
			Style myStyle = text.GetStyle();
			
			List<TextLayout> layouts = itemToDraw.getLayouts(g, scale);
			int xsize = 0, ysize = (int) (myStyle.getLeading() * scale);
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
			
			return new Rectangle((int) (myStyle.getIndent()*scale), 0, xsize, ysize );
		}
		
}
