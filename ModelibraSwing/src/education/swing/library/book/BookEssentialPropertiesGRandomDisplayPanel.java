package education.swing.library.book;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.modelibra.swing.ModelibraFrame;
import org.modelibra.swing.ModelibraPanel;
import org.modelibra.swing.domain.model.concept.entity.EntityEssentialPropertiesDisplayPanel;
import org.modelibra.util.NatLang;

import education.data.ModelibraData;
import education.library.book.Book;
import education.library.book.Books;

@SuppressWarnings("serial")
public class BookEssentialPropertiesGRandomDisplayPanel extends
		ModelibraPanel {

	public BookEssentialPropertiesGRandomDisplayPanel(
			ModelibraFrame contentFrame, Book book, final NatLang natLang) {
		setLayout(new BorderLayout());
		Books books = ModelibraData.get().getModel().getBooks();
		add(new EntityEssentialPropertiesDisplayPanel(contentFrame, books,
				book, natLang), BorderLayout.CENTER);
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
