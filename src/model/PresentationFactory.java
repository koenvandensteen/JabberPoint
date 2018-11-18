package model;

import model.SlideFactory.SupportedSlideTypes;

public abstract class PresentationFactory {
	
	public enum SupportedPresentationTypes
	{
		REGULARPRESENTATION
	}
	
	public static PresentationFactory GetFactory(SupportedPresentationTypes presentationType)
	{
		switch(presentationType)
		{
		case REGULARPRESENTATION:
			return new RegularPresentationFactory();
		default:
			return new RegularPresentationFactory();			
		}
	}
	
	public abstract Presentation CreatePresentation();
}
