package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import model.BitmapItem;
import model.SlideItem;
import model.Style;
public class BitmapItemDrawer extends ItemDrawerBridge {

	@Override
	public void draw(int x, int y, float scale, Graphics g, ImageObserver observer, SlideItem item) {
		// TODO Auto-generated method stub

		Style myStyle = item.GetStyle();	
		
		int width = x + (int) (myStyle.getIndent() * scale);
		int height = y + (int) (myStyle.getLeading() * scale);
		
		BufferedImage bufferedImage = ((BitmapItem)item).GetBufferedImage();
		g.drawImage(bufferedImage, width, height,(int) (bufferedImage.getWidth(observer)*scale),
                (int) (bufferedImage.getHeight(observer)*scale), observer);
	}
	
}
