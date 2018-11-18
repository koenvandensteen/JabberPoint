package model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

public class TextItemFactory extends SlideItemFactory {

	@Override
	public SlideItem CreateSlideItem(int level, String content) {
		return new TextItem(level,content);
	}

}
