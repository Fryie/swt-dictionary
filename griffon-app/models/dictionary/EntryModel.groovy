package dictionary

import groovy.beans.Bindable

@Bindable
class EntryModel {
	String name
	String translation
	String categories
	String notes

	Entry entry

	EntryModel() {
		name=""
		translation=""
		categories=""
		notes=""
		entry=new Entry(name:"",translation:"",categories:"",notes:"")
	}

	static from(Entry entry) {
		return new EntryModel(name:entry.name,translation:entry.translation,
			categories:entry.categories,notes:entry.notes,entry:entry)
   	}
}