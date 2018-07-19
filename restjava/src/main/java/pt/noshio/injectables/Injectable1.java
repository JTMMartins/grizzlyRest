package pt.noshio.injectables;

import javax.inject.Named;

/**
 * This simple pojo can be injected.
 * there is no need to use any annotations
 * for simple injection.
 */
@Named
public class Injectable1 {
	
	private String justAString;

	public String getJustAString() {
		return justAString;
	}

	public void setJustAString(String justAString) {
		this.justAString = justAString;
	}

}
