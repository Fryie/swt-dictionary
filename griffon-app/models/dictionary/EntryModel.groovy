package dictionary

import groovy.beans.Bindable

@Bindable
class EntryModel {
   String name
   String translation
   String categories
   String notes
}