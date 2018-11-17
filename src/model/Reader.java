package model;

import java.io.IOException;

public abstract class Reader {
	public abstract Presentation Read(String fileName) throws IOException;
}
