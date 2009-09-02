package education.swing.app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.modelibra.swing.ModelibraFrame;
import org.modelibra.util.NatLang;
import org.modelibra.util.PathLocator;

import education.data.ModelibraData;

@SuppressWarnings("serial")
public class MainFrame extends ModelibraFrame {

	public static final Color MAIN_COLOR = Color.LIGHT_GRAY;

	private NatLang natLang;
	private MainMenuBar mainMenuBar;

	private JPanel northPanel = new JPanel();
	private JPanel centerPanel = new JPanel();
	private JPanel southPanel = new JPanel();
	private JPanel imagePanel = new JPanel();
	private JLabel imageLabel;

	public MainFrame(NatLang natLang, String imageRelativePath) {
		this.natLang = natLang;

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});
		setTitle(natLang.getText("product"));

		mainMenuBar = new MainMenuBar(this);
		setJMenuBar(mainMenuBar);
		mainMenuBar.setSession(ModelibraData.get().getModel().getSession());

		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(northPanel, BorderLayout.NORTH);
		cp.add(southPanel, BorderLayout.SOUTH);
		cp.add(centerPanel, BorderLayout.CENTER);
		centerPanel.add(imagePanel);
		imagePanel.setBackground(MAIN_COLOR);
		PathLocator pathLocator = new PathLocator();
		ImageIcon imageIcon = pathLocator.getImageIcon(AboutDialog.class,
				imageRelativePath);
		imageLabel = new JLabel(imageIcon);
		imagePanel.add(imageLabel);

		pack();
	}

	public NatLang getNatLang() {
		return natLang;
	}

	public void exit() {
		ModelibraData.get().close();
		dispose();
		if (!Start.isApplet) {
			System.exit(0);
		}
	}

}
