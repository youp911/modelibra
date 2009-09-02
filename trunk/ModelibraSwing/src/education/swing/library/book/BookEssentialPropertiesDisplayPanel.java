package education.swing.library.book;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;

import org.modelibra.config.PropertyConfig;
import org.modelibra.swing.ModelibraFrame;
import org.modelibra.swing.ModelibraPanel;
import org.modelibra.swing.domain.model.concept.entity.EntityPropertiesPanel;
import org.modelibra.util.NatLang;

import education.data.ModelibraData;
import education.library.book.Book;
import education.library.book.Books;

@SuppressWarnings("serial")
public class BookEssentialPropertiesDisplayPanel extends ModelibraPanel {

	public BookEssentialPropertiesDisplayPanel(ModelibraFrame contentFrame,
			Book book, NatLang natLang) {
		Books books = ModelibraData.get().getModel().getBooks();
		JPanel bookPropertiesPanel;
		if (books.size() > 0) {
			List<PropertyConfig> essentialPropertyConfigList = books
					.getConceptConfig().getPropertiesConfig()
					.getEssentialPropertyConfigList();
			bookPropertiesPanel = new EntityPropertiesPanel(contentFrame, true,
					false, null, books, book, essentialPropertyConfigList,
					natLang);
		} else {
			bookPropertiesPanel = new JPanel();
		}
		setLayout(new BorderLayout());
		add(bookPropertiesPanel, BorderLayout.CENTER);
	}
}
