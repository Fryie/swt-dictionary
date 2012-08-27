package dictionary

import griffon.transform.Threading

class DictionaryController {
    def view
    def model

    def openEntry = { entry ->
        String mvcId = "entry"+System.currentTimeMillis()
        EntryModel model = EntryModel.from(entry)
    	execInsideUISync {
    		def mvc = buildMVCGroup('entry',mvcId,
                [model:model,tabGroup:view.entryTabs])
    		view.entryTabs.selection = mvc.view.tab
    	}
    }

    def newEntry = {
        String mvcId = "entry"+System.currentTimeMillis()
        execInsideUISync {
            def mvc = buildMVCGroup('entry', mvcId,[tabGroup:view.entryTabs])
            mvc.view.tab.text = "  New Entry "
            view.entryTabs.selection = mvc.view.tab
        }
    }
}
