package education.data;

import java.util.ArrayList;
import java.util.List;

import org.modelibra.IDomain;
import org.modelibra.IDomainModel;
import org.modelibra.config.DomainConfig;

import education.Education;
import education.EducationConfig;
import education.PersistentEducation;
import education.library.Library;

public class ModelibraData {

	private static ModelibraData modelibraData;

	private EducationConfig educationConfig;

	private Education education;

	private PersistentEducation persistentEducation;

	private List<IDomain> domains = new ArrayList<IDomain>();

	private ModelibraData() {
		educationConfig = new EducationConfig();
		DomainConfig domainConfig = educationConfig.getDomainConfig();
		education = new Education(domainConfig);
		persistentEducation = new PersistentEducation(education);
		domains.add(education);
	}

	public EducationConfig getConfig() {
		return educationConfig;
	}

	public static ModelibraData get() {
		if (modelibraData == null) {
			modelibraData = new ModelibraData();
		}
		return modelibraData;
	}

	public IDomain getDomain(String domainCode) {
		for (IDomain domain : domains) {
			if (domain.getDomainConfig().getCode().equals(domainCode)) {
				return domain;
			}
		}
		return null;
	}

	public Education getDomain() {
		return education;
	}

	public IDomainModel getModel(String domainCode, String modelCode) {
		IDomain domain = getDomain(domainCode);
		if (domain != null) {
			return domain.getModel(modelCode);
		}
		return null;
	}

	public Library getModel() {
		return getDomain().getLibrary();
	}

}
