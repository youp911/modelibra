package medical.wicket.app.home;

import medical.Medical;
import medical.records.Records;
import medical.records.patient.Patients;
import medical.wicket.app.MedicalApp;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;
import org.modelibra.wicket.concept.EntityPropertyDisplayListPanel;
import org.modelibra.wicket.view.View;
import org.modelibra.wicket.view.ViewModel;

import chapter01.Index;
import chapter02.Hello;
import chapter02.HelloSun;
import chapter04.section02.WicketModel;
import chapter04.section03.DetachableModel;
import chapter04.section04.NestedModel;

/**
 * Application home page.
 * 
 * @author Dzenan Ridjanovic
 * @version 2009-09-17
 */
public class HomePage extends WebPage {

	public HomePage() {
		MedicalApp medicalApp = (MedicalApp) getApplication();
		Medical medicalDomain = medicalApp.getMedical();
		Records recordsDomainModel = medicalDomain.getRecords();

		// Menu
		add(new HomeMenu("homeMenu"));

		// Patient emails
		ViewModel patientsEmailViewModel = new ViewModel();
		patientsEmailViewModel.setModel(recordsDomainModel);
		Patients patients = recordsDomainModel.getPatients();
		patientsEmailViewModel.setEntities(patients);
		patientsEmailViewModel.setPropertyCode("email");

		View patientsEmailView = new View();
		patientsEmailView.setWicketId("patientEmailList");

		EntityPropertyDisplayListPanel patientEmailList = new EntityPropertyDisplayListPanel(
				patientsEmailViewModel, patientsEmailView);
		add(patientEmailList);

		// Links to Wicket examples

		// Chapter 01
		Link chapter01Link = new Link("chapter01Link") {
			public void onClick() {
				setResponsePage(new Index());
			}
		};
		add(chapter01Link);

		// Chapter 02
		Link chapter02Link01 = new Link("chapter02Link01") {
			public void onClick() {
				setResponsePage(new Hello());
			}
		};
		add(chapter02Link01);
		Link chapter02Link02 = new Link("chapter02Link02") {
			public void onClick() {
				setResponsePage(new HelloSun());
			}
		};
		add(chapter02Link02);

		// Chapter 03: See WicketInActionWithModelibra

		// Chapter 04 Section 02
		Link chapter04Link01 = new Link("chapter04Link01") {
			public void onClick() {
				setResponsePage(new WicketModel());
			}
		};
		add(chapter04Link01);

		// Chapter 04 Section 03
		Link chapter04Link02 = new Link("chapter04Link02") {
			public void onClick() {
				setResponsePage(new DetachableModel());
			}
		};
		add(chapter04Link02);

		// Chapter 04 Section 04
		Link chapter04Link03 = new Link("chapter04Link03") {
			public void onClick() {
				setResponsePage(new NestedModel());
			}
		};
		add(chapter04Link03);
	}

}
