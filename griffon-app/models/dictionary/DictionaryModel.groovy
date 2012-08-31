package dictionary

import groovy.beans.Bindable
import org.eclipse.core.databinding.observable.list.WritableList
import java.util.prefs.Preferences

@Bindable
class DictionaryModel {
	WritableList entries = new WritableList([],Entry.class)
	Map openEntries = [:] // Entry -> Entry MVC group
	List selectedEntries = []

	Preferences prefs = Preferences.userNodeForPackage(this.class)
}