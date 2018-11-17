package model;

import java.io.IOException;

public class DemoWriter extends Writer {

	@Override
	public void Write(Presentation presentation, String filename) throws IOException {
		System.err.println("Unable to save the demo presentation");
	}

}
