package org.modelibra.swing;

import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public abstract class ModelibraButton extends JButton implements
		IModelibraConstants {

	public ModelibraButton() {
		super();
	}

	/**
	 * Displays a child frame down and right of this button.
	 * 
	 * @param child
	 *            frame
	 */
	public void displayDownRight(JFrame child) {
		Point locationOnScreen = getLocationOnScreen();
		double parentX = locationOnScreen.getX();
		double parentY = locationOnScreen.getY();

		double childX = parentX + FRAME_DISPLAY_INCREMENT;
		double childY = parentY + FRAME_DISPLAY_INCREMENT;

		Point childLocation = new Point();
		childLocation.setLocation(childX, childY);
		child.setLocation(childLocation);
		child.setVisible(true);
	}

}
