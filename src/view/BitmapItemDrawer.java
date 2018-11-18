package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import model.BitmapItem;
import model.SlideItem;
import model.Style;

/**
 * BitmapItemDrawer
 * <p>
 * Concrete implementor of the ItemDrawBridge pattern which draw's BitMap items
 * </p>
 */

public class BitmapItemDrawer extends ItemDrawerBridge {

	@Override
	public void draw(int x, int y, float scale, Graphics g, ImageObserver observer, SlideItem item) {
		Style myStyle = item.GetStyle();

		int width = x + (int) (myStyle.getIndent() * scale);
		int height = y + (int) (myStyle.getLeading() * scale);

		BufferedImage bufferedImage = ((BitmapItem) item).GetBufferedImage();
		g.drawImage(bufferedImage, width, height, (int) (bufferedImage.getWidth(observer) * scale),
				(int) (bufferedImage.getHeight(observer) * scale), observer);
	}

}
