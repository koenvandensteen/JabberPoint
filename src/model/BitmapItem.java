package model;

import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import javax.imageio.ImageIO;
import view.BitmapItemDrawer;
import java.io.IOException;

/**
 * <p>
 * BitmapItemClass
 * </p>
 * <p>
 * Bitmap item holds all the needed data used for drawing a specific bitmap item. 
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

public class BitmapItem extends SlideItem {
	private BufferedImage bufferedImage;
	private String imageName;

	protected static final String FILE = "Bestand ";
	protected static final String NOTFOUND = " niet gevonden";

// level staat voor het item-level; name voor de naam van het bestand met de afbeelding
	public BitmapItem(int level, String name) {
		super(level);
		imageName = name;
		try {
			bufferedImage = ImageIO.read(new File(imageName));
		} catch (IOException e) {
			System.err.println(FILE + imageName + NOTFOUND);
		}
		itemDrawer = new BitmapItemDrawer();
		styleStrategy = new StyleDefault();
	}

// Een leeg bitmap-item
	public BitmapItem() {
		this(0, null);
	}

// geef de bestandsnaam van de afbeelding
	public String getName() {
		return imageName;
	}

// geef de bounding box van de afbeelding
	public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale) {

		return new Rectangle((int) (itemStyle.indent * scale), 0, (int) (bufferedImage.getWidth(observer) * scale),
				((int) (itemStyle.leading * scale)) + (int) (bufferedImage.getHeight(observer) * scale));
	}

	public String toString() {
		return "BitmapItem[" + getLevel() + "," + imageName + "]";
	}

	public BufferedImage GetBufferedImage() {
		return bufferedImage;
	}
}
