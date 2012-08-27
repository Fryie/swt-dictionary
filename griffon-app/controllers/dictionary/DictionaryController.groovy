package dictionary

import griffon.transform.Threading

class DictionaryController {
    def view
    def model

    def openEntry = { entry ->
    	execInsideUISync {
    		String mvcId = entry.name + System.currentTimeMillis()
    		def mvc = buildMVCGroup('entry',mvcId,[model:EntryModel.from(entry),
    			tabGroup:view.entryTabs,mvcId:mvcId])
    		view.entryTabs.selection = mvc.view.tab
    	}
    }
}
