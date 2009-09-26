package education.swing.app;

import java.util.Properties;

import org.modelibra.swing.main.MainFrame;
import org.modelibra.util.NatLang;
import org.modelibra.util.PropertiesLoader;

import education.data.ModelibraData;

@SuppressWarnings("serial")
public class Start {

	public static final String APP_CONFIG_LOCAL_PATH = "Start.properties";
	public static final int MAIN_FRAME_X = 0;
	public static final int MAIN_FRAME_Y = 0;

	private MainFrame mainFrame;

	public Start() {
		Properties configurator = PropertiesLoader.load(Start.class,
				Start.APP_CONFIG_LOCAL_PATH);
		String language = configurator.getProperty("lang");
		String textResources = configurator.getProperty("textResources");
		NatLang natLang = new NatLang();
		natLang.setNaturalLanguage(language, textResources);
		mainFrame = new MainFrame(ModelibraData.get().getModel(), natLang);
		mainFrame.setLocation(MAIN_FRAME_X, MAIN_FRAME_Y);
		mainFrame.setVisible(true);
	}

	/**
	 * Application entry (start) point.
	 * 
	 * @param args
	 *            args not used
	 */
	public static void main(String[] args) {
		new Start();
	}

}
