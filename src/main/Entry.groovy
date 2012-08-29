package dictionary

import groovy.beans.Bindable

class Entry {
	@Bindable String name
   	String translation
   	String categories
   	String notes
}