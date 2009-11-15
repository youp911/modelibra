package org.ieducnews.view;

import java.util.List;

import org.apache.wicket.behavior.SimpleAttributeModifier;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PageableListView;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.ieducnews.model.concept.contribution.Submission;
import org.ieducnews.model.concept.contribution.Submissions;
import org.ieducnews.model.concept.contribution.WebLink;

public class HomePage extends BasePage {

	public static final int NUMBER_OF_SUBMISSIONS_ON_ONE_PAGE = 16;

	public HomePage() {
		Submissions submissions = getWebApp().getDomainModel().getSubmissions();
		Submissions orderedSubmissions = submissions.orderByName();
		SubmissionsListView listView = new SubmissionsListView("submissions",
				orderedSubmissions.getList());
		add(listView);
		PagingNavigator pagingNavigator = new PagingNavigator("navigator",
				listView);
		if (orderedSubmissions.size() <= NUMBER_OF_SUBMISSIONS_ON_ONE_PAGE) {
			pagingNavigator.setVisible(false);
		}
		add(pagingNavigator);
	}

	private class SubmissionsListView extends PageableListView<Submission> {

		private static final long serialVersionUID = 1;

		private SubmissionsListView(String wicketId,
				List<Submission> submissions) {
			super(wicketId, submissions, NUMBER_OF_SUBMISSIONS_ON_ONE_PAGE);
		}

		protected void populateItem(ListItem<Submission> listItem) {
			Submission submission = listItem.getModelObject();
			if (submission.isWebLink()) {
				WebLink webLink = (WebLink) submission;
				listItem.add(new ExternalLink("linkUrl", webLink.getLink()
						.toString(), submission.getName()));
				listItem.add(new Label("linkLabel", webLink.getLink()
						.toString()));
				listItem.add(new RemoveSubmission(submission));
			}
		}
	}

	private class RemoveSubmission extends Link<Submission> {

		private static final long serialVersionUID = 1;

		private Submission submission;

		private RemoveSubmission(Submission submission) {
			super("removeSubmission");
			this.submission = submission;
			add(new SimpleAttributeModifier("onclick",
					"return confirm('Are you sure you want to remove this submission?');"));
		}

		@Override
		public void onClick() {
			Submissions submissions = getWebApp().getDomainModel()
					.getSubmissions();
			if (submissions.contains(submission)) {
				submissions.remove(submission);
				getWebApp().getDomainModel().save();
			}
			setResponsePage(HomePage.class);
		}

		@Override
		public boolean isVisible() {
			if (getWebAppSession().isAuthenticated()) {
				return getWebAppSession().isAdmin();
			}
			return false;
		}
	}

}
