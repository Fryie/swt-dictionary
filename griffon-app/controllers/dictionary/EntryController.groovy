package dictionary

import griffon.transform.Threading

class EntryController {
	def model
    def view

    def save = {
    	println "Name: ${model.name}"
    	println "Translation: ${model.translation}"
    	println "Categories: ${model.categories}"
    	println "Notes: ${model.notes}"

        model.entry.name = model.name
        model.entry.translation = model.translation
        model.entry.categories = model.categories
        model.entry.notes = model.notes
    }

    def close = {
    	//TODO
    }
}
