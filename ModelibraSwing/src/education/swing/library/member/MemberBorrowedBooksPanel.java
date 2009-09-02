package education.swing.library.member;

import java.util.ArrayList;
import java.util.List;

import org.modelibra.config.NeighborConfig;
import org.modelibra.config.PropertyConfig;
import org.modelibra.swing.ModelibraFrame;
import org.modelibra.swing.ModelibraPanel;
import org.modelibra.swing.domain.model.concept.entity.EntityTablePanel;
import org.modelibra.util.NatLang;

import education.library.bookitem.BookItems;
import education.library.member.Member;

@SuppressWarnings("serial")
public class MemberBorrowedBooksPanel extends ModelibraPanel {

	public MemberBorrowedBooksPanel(ModelibraFrame contentFrame, Member member,
			NatLang natLang) {
		BookItems bookItems = member.getBookItems();
		List<PropertyConfig> propertyConfigList = bookItems.getConceptConfig()
				.getPropertiesConfig().getEssentialPropertyConfigList();
		List<NeighborConfig> neighborConfigList = new ArrayList<NeighborConfig>();
		add(new EntityTablePanel(false, contentFrame, true, null, bookItems,
				propertyConfigList, neighborConfigList, natLang));
	}

}
