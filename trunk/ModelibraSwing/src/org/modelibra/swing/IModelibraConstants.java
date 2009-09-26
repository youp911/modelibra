package org.modelibra.swing;

import java.awt.Color;
import java.awt.Dimension;

public interface IModelibraConstants {

	public static final String APP_CONFIG_LOCAL_PATH = "Start.properties";
	public static final int MAIN_FRAME_X = 0;
	public static final int MAIN_FRAME_Y = 0;

	public static final Color APP_COLOR = Color.LIGHT_GRAY;
	public static final String APP_IMAGE_RELATIVE_PATH = "modelibra.jpg";

	public static final double FRAME_DISPLAY_INCREMENT = 32;

	public static final int PANEL_WIDTH = 540;
	public static final int PANEL_HEIGHT = 270;
	public static final Dimension PANEL_SIZE = new Dimension(PANEL_WIDTH,
			PANEL_HEIGHT);

	public static final int FRAME_WIDTH = 560;
	public static final int FRAME_HEIGHT = 560;
	public static final Dimension FRAME_SIZE = new Dimension(FRAME_WIDTH,
			FRAME_HEIGHT);

	public static final int MIN_LONG_TEXT_LENGTH = 128;

}
