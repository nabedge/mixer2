package org.mixer2.xhtml;

import org.mixer2.Mixer2Engine;

public class Mixer2EngineSingleton {

	private Mixer2EngineSingleton() {
	}

	private static final Mixer2Engine m2e = new Mixer2Engine();

	public static Mixer2Engine getInstance() {
		return m2e;
	}

}
