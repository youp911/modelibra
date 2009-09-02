package education.swing.library.book;

import org.modelibra.swing.ModelibraFrame;
import org.modelibra.util.NatLang;

import education.data.ModelibraData;
import education.library.book.Book;
import education.library.book.Books;

@SuppressWarnings("serial")
public class BookEssentialPropertiesRandomDisplayFrame extends ModelibraFrame {

	public BookEssentialPropertiesRandomDisplayFrame(NatLang natLang) {
		Books books = ModelibraData.get().getModel().getBooks();
		Book book = books.random();
		add(new BookEssentialPropertiesRandomDisplayPanel(this, book, natLang));
		//add(new BookEssentialPropertiesGRandomDisplayPanel(this, book, natLang));
		pack();
	}
}
