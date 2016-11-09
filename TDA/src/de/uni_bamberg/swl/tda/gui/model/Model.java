package de.uni_bamberg.swl.tda.gui.model;

import java.util.Observable;

public class Model extends Observable {

	private void setChanges() {
		setChanged();
		notifyObservers();
	}

}
