package model;

import java.io.IOException;

/**
 * Reader
 * <p>
 * Abstract class used as base class for the different Reader Accessors.
 * </p>
 */

public abstract class Reader {
	public abstract Presentation Read(String fileName) throws IOException;
}
