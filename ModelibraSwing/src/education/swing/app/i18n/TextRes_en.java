package education.swing.app.i18n;

import java.io.IOException;
import java.util.PropertyResourceBundle;

public class TextRes_en extends PropertyResourceBundle {

	TextRes_en() throws IOException {
		super(TextRes_en.class.getResourceAsStream("TextRes_en.properties"));
	}

}