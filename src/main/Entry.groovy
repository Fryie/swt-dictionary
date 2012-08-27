package dictionary

import groovy.beans.Bindable

@Bindable
class Entry {
	String name
   	String translation
   	String categories
   	String notes
}