package education.swing.app;

import java.util.Properties;

import javax.swing.JApplet;

import org.modelibra.util.NatLang;
import org.modelibra.util.PropertiesLoader;

@SuppressWarnings("serial")
public class Start extends JApplet {

	public static final String APP_CONFIG_LOCAL_PATH = "Start.properties";
	public static final int MAIN_FRAME_X = 0;
	public static final int MAIN_FRAME_Y = 0;

	public static boolean isApplet = false;

	private MainFrame mainFrame;

	public Start() {
		super();
	}

	public void init() {
		Properties configurator = PropertiesLoader.load(Start.class,
				Start.APP_CONFIG_LOCAL_PATH);
		String applet = configurator.getProperty("applet");
		if ((applet == null) || (applet.equals("yes"))) {
			isApplet = true;
		}
		String language = configurator.getProperty("lang");
		String imageRelativePath = configurator
				.getProperty("imageRelativePath");
		String textResources = configurator.getProperty("textResources");
		NatLang natLang = new NatLang();
		natLang.setNaturalLanguage(language, textResources);
		mainFrame = new MainFrame(natLang, imageRelativePath);
		mainFrame.setLocation(MAIN_FRAME_X, MAIN_FRAME_Y);
	}

	public void start() {
		mainFrame.setVisible(true);
	}

	public void stop() {
		mainFrame.setVisible(false);
	}

	public void destroy() {
		mainFrame.dispose();
	}

	/**
	 * Application (and not applet) entry point.
	 * 
	 * @param args
	 *            args not used
	 */
	public static void main(String[] args) {
		Start app = new Start();
		app.init();
		app.start();
	}

}
