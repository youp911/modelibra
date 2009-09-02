package education.swing.library.book;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.modelibra.swing.ModelibraFrame;
import org.modelibra.util.NatLang;

import education.library.book.Book;

@SuppressWarnings("serial")
public class BookEssentialPropertiesRandomDisplayPanel extends
		BookEssentialPropertiesDisplayPanel {

	public BookEssentialPropertiesRandomDisplayPanel(
			ModelibraFrame contentFrame, Book book, final NatLang natLang) {
		super(contentFrame, book, natLang);
		JButton randomButton = new JButton(natLang.getText("random"));
		add(randomButton, BorderLayout.SOUTH);
		randomButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayDownRight(new BookEssentialPropertiesRandomDisplayFrame(
						natLang));
			}
		});
	}
}
