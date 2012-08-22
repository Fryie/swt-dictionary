package dictionary

import groovy.beans.Bindable

@Bindable
class DictionaryModel {
	List<EntryModel> entries = [new EntryModel(name:"test",translation:"test",
		categories:"test",notes:"test")]
}