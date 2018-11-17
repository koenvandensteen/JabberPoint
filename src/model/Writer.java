package model;

import java.io.IOException;

public abstract class Writer {
	public abstract void Write(Presentation presentation, String filename) throws IOException;
}
