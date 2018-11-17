package model;

public abstract class AccessorFactory {	
	public static AccessorFactory GetFactory(String fileNameExtension)
	{
		switch(fileNameExtension.toLowerCase())
		{
		case ".xml":
			return new XMLAccessorFactory();
		default:
			return  new DemoAccesorFactory();			
		}
	}
	
	public abstract Reader CreateReader();
	public abstract Writer CreateWriter();
	
}
