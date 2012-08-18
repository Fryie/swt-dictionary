package dictionary

import groovy.beans.Bindable

class DictionaryModel {
	String name
	List<EntryModel> entries = [new EntryModel(name:"test"),new EntryModel(name:"test2")]
}