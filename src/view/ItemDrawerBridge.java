package view;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import model.SlideItem;

public abstract class ItemDrawerBridge {
	// teken het item
		public abstract void draw(int x, int y, float scale, Graphics g, ImageObserver observer, SlideItem item);
		
}
