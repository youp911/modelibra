package org.modelibra.swing.app;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JPanel;

import org.modelibra.IDomainModel;
import org.modelibra.ModelSession;
import org.modelibra.swing.widget.ModelibraFrame;
import org.modelibra.util.NatLang;

@SuppressWarnings("serial")
public class MainFrame extends ModelibraFrame implements IConstants {

	private NatLang natLang;
	private MainMenuBar mainMenuBar;

	private JPanel northPanel = new JPanel();
	private JPanel centerPanel = new JPanel();
	private JPanel southPanel = new JPanel();

	private IDomainModel domainModel;
	private ModelSession modelSession;

	public MainFrame(IDomainModel domainModel, NatLang natLang) {
		this.domainModel = domainModel;
		this.natLang = natLang;

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});
		setTitle(natLang.getText("product"));

		mainMenuBar = new MainMenuBar(this);
		setJMenuBar(mainMenuBar);

		setModelSession(domainModel.getNewSession());

		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(northPanel, BorderLayout.NORTH);
		cp.add(southPanel, BorderLayout.SOUTH);
		cp.add(centerPanel, BorderLayout.CENTER);

		pack();
	}

	public IDomainModel getDomainModel() {
		return domainModel;
	}
	
	public void setModelSession(ModelSession modelSession) {
		this.modelSession = modelSession;
	}

	public ModelSession getModelSession() {
		return modelSession;
	}

	public NatLang getNatLang() {
		return natLang;
	}

	public void exit() {
		dispose();
		System.exit(0);
	}

}
