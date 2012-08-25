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
    }

    def close = {
    	//TODO
    }
}
