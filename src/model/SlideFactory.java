package model;

public abstract class SlideFactory {
	
	public enum SupportedSlideTypes
	{
		ITEMSLIDE
	}
	
	public static SlideFactory GetFactory(SupportedSlideTypes slideType)
	{
		switch(slideType)
		{
		case ITEMSLIDE:
			return new ItemSlideFactory();
		default:
			return new ItemSlideFactory();			
		}
	}
	
	public abstract Slide CreateSLide();
}
