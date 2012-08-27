package dictionary

import groovy.beans.Bindable
import org.eclipse.core.databinding.observable.list.WritableList

@Bindable
class DictionaryModel {
	WritableList entries = new WritableList([new Entry(name:"test",translation:"test",
		categories:"test",notes:"test")],Entry.class)
}