package model;

public class BitmapItemFactory extends SlideItemFactory {

	@Override
	public SlideItem CreateSlideItem(int level, String content) {
		return new BitmapItem(level, content);
	}

}
