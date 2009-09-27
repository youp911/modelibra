package education.swing.app;

import java.util.Properties;

import org.modelibra.swing.app.IAppConstants;
import org.modelibra.swing.app.MainFrame;
import org.modelibra.util.NatLang;
import org.modelibra.util.PropertiesLoader;

import education.data.ModelibraData;

public class Start implements IAppConstants {

	private MainFrame mainFrame;

	public Start() {
		Properties configurator = PropertiesLoader.load(Start.class,
				APP_CONFIG_LOCAL_PATH);
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
