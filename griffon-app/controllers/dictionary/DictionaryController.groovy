package dictionary

import griffon.transform.Threading

class DictionaryController {
    def view
    def model

    def openEntry = { entry ->
        String mvcId = "entry"+System.currentTimeMillis()
        // if already opened, select
        if (model.openEntries.containsKey(entry)) {
            execInsideUISync {
                view.entryTabs.selection = model.openEntries[entry].view.tab
            }
            return
        }
        // else create new mvc group and open
        EntryModel entryModel = EntryModel.from(entry)
    	execInsideUISync {
    		def mvc = buildMVCGroup('entry',mvcId,
                [model:entryModel,tabGroup:view.entryTabs,mvcId:mvcId])
    		view.entryTabs.selection = mvc.view.tab
            model.openEntries[mvc.model.entry] = mvc
    	}
    }

    def newEntry = {
        String mvcId = "entry"+System.currentTimeMillis()
        execInsideUISync {
            def mvc = buildMVCGroup('entry', mvcId,[tabGroup:view.entryTabs])
            mvc.model.isNew = true
            mvc.view.tab.text = "New Entry"
            view.entryTabs.selection = mvc.view.tab
            model.openEntries[mvc.model.entry] = mvc
        }
    }
}