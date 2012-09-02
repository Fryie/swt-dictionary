package dictionary

import griffon.transform.Threading

class EntryController {
	def model
    def view

    void mvcGroupInit(Map args) {
        model.mvcId = args.mvcId
    }

    def save = {
        model.entry.name = model.name
        model.entry.translation = model.translation
        model.entry.categories = model.categories
        model.entry.notes = model.notes

        execInsideUISync {
            view.tab.text = model.name
            if (model.isNew) {
                app.mvcGroupManager.groups.dictionary.model.entries.add(model.entry)
                model.isNew = false
            }
        }

        app.mvcGroupManager.groups.dictionary.controller.saveToFile()
    }

    def close = {
        execInsideUISync {
            // close tab
            view.tab.dispose()
            // destroy mvc group
            destroyMVCGroup(model.mvcId)
            // remove from 'open entries'
            app.mvcGroupManager.groups.dictionary.model.openEntries.remove(model.entry)
        }
    }
}
