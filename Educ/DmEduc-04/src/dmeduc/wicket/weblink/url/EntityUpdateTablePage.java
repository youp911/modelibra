package dmeduc.wicket.weblink.url;

import org.modelibra.wicket.view.View;
import org.modelibra.wicket.view.ViewModel;

import dmeduc.weblink.url.Urls;

/**
 * Entity update table page.
 * 
 * @author Dzenan Ridjanovic
 * @version 2007-11-09
 */
public class EntityUpdateTablePage extends
		org.modelibra.wicket.concept.EntityUpdateTablePage {

	private static final long serialVersionUID = 10102010L;

	/**
	 * Constructs an entity update table page.
	 * 
	 * @param viewModel
	 *            model context
	 * @param view
	 *            view context
	 */
	public EntityUpdateTablePage(final ViewModel viewModel, final View view) {
		super(getNewViewModel(viewModel), view);
	}

	/**
	 * Gets a new view model.
	 * 
	 * @param viewModel
	 *            view model
	 * @return new view model
	 */
	private static ViewModel getNewViewModel(final ViewModel viewModel) {
		ViewModel newViewModel = new ViewModel();
		newViewModel.copyPropertiesFrom(viewModel);
		Urls urls = (Urls) viewModel.getEntities();
		urls = urls.getUrlsOrderedByName();
		newViewModel.setEntities(urls);
		return newViewModel;
	}

}
