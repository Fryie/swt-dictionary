package dictionary

import groovy.beans.Bindable

class DictionaryModel {
	List<EntryModel> entries = [new EntryModel(name:"test"),new EntryModel(name:"test2")]
}