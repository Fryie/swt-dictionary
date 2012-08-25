package dictionary

import griffon.transform.Threading

class DictionaryController {
    def view
    def model

    def openEntry = { entryModel ->
    	execInsideUISync {
    		String mvcId = entryModel.name + System.currentTimeMillis()
    		def mvc = buildMVCGroup('entry',mvcId,[model:entryModel,
    			tabGroup:view.entryTabs,mvcId:mvcId])
    		view.entryTabs.selection = mvc.view.tab
    	}
    }
}
