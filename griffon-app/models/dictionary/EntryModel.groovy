package dictionary

import groovy.beans.Bindable

@Bindable
class EntryModel {
	String name = ""
	String translation = ""
	String categories = ""
	String notes = ""

	String mvcId = ""

	Entry entry

	boolean isNew = false

	EntryModel() {
		entry=new Entry(name:"",translation:"",categories:"",notes:"")
	}

	static from(Entry entry) {
		return new EntryModel(name:entry.name,translation:entry.translation,
			categories:entry.categories,notes:entry.notes,entry:entry)
   	}
}