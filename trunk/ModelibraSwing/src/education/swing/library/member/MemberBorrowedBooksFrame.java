package education.swing.library.member;

import java.awt.BorderLayout;

import org.modelibra.swing.ModelibraFrame;
import org.modelibra.swing.domain.model.concept.entity.EntityEssentialPropertiesDisplayPanel;
import org.modelibra.util.NatLang;

import education.data.ModelibraData;
import education.library.member.Member;
import education.library.member.Members;

@SuppressWarnings("serial")
public class MemberBorrowedBooksFrame extends ModelibraFrame {

	public MemberBorrowedBooksFrame(Member member, NatLang natLang) {
		setLayout(new BorderLayout());
		Members members = ModelibraData.get().getModel().getMembers();
		add(new EntityEssentialPropertiesDisplayPanel(this, members, member,
				natLang), BorderLayout.NORTH);
		add(new MemberBorrowedBooksPanel(this, member, natLang),
				BorderLayout.CENTER);
		pack();
	}

}
