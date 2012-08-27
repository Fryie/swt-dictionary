package dictionary

import groovy.beans.Bindable

@Bindable
class EntryModel {
	String name
	String translation
	String categories
	String notes

	Entry entry

	static from(Entry entry) {
		return new EntryModel(name:entry.name,translation:entry.translation,
			categories:entry.categories,notes:entry.notes,entry:entry)
   	}
}