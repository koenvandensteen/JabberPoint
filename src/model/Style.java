package model;

import java.awt.Color;
import java.awt.Font;

/**
 * Style
 * <p>
 * Style is the base class for a container used to store the style of a specific
 * Slide Item.
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

public class Style {

	private static final String FONTNAME = "Helvetica";
	int indent;
	Color color;
	Font font;
	int fontSize;
	int leading;

	public Style(int indent, Color color, int points, int leading) {
		this.indent = indent;
		this.color = color;
		font = new Font(FONTNAME, Font.BOLD, fontSize = points);
		this.leading = leading;
	}

	public String toString() {
		return "[" + indent + "," + color + "; " + fontSize + " on " + leading + "]";
	}

	public Font getFont(float scale) {
		return font.deriveFont(fontSize * scale);
	}

	public int getIndent() {
		return indent;
	}

	public Color getColor() {
		return color;
	}

	public int getLeading() {
		return leading;
	}
}
