package org.modelibra.swing.app;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import org.modelibra.swing.widget.ModelibraFrame;

@SuppressWarnings("serial")
public class MainFrame extends ModelibraFrame implements IConstants {

	private App app;

	private MainMenuBar mainMenuBar;

	public MainFrame(App app) {
		this.app = app;
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});
		setTitle(app.getNatLang().getText("product"));

		mainMenuBar = new MainMenuBar(this);
		setJMenuBar(mainMenuBar);

		pack();
	}

	public App getApp() {
		return app;
	}

	public void exit() {
		dispose();
		System.exit(0);
	}

}
