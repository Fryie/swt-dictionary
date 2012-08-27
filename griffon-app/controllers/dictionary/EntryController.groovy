package dictionary

import griffon.transform.Threading

class EntryController {
	def model
    def view

    def save = {
        model.entry.name = model.name
        model.entry.translation = model.translation
        model.entry.categories = model.categories
        model.entry.notes = model.notes
        execInsideUISync {
            view.tab.text = model.name
            app.mvcGroupManager.groups.dictionary.model.entries.add(model.entry)
        }
    }

    def close = {
    	//TODO
    }
}
