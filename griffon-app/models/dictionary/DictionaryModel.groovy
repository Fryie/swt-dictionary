package dictionary

import groovy.beans.Bindable
import org.eclipse.core.databinding.observable.list.WritableList

@Bindable
class DictionaryModel {
	WritableList entries = new WritableList([],Entry.class)
}