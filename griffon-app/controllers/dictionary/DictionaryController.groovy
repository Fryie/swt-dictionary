package dictionary

import griffon.transform.Threading

class DictionaryController {
    def view
    def model

    def openEntry = { entryModel ->
    	execInsideUISync {
    		String mvcId = entryModel.name + System.currentTimeMillis()
    		createMVCGroup('entry',mvcId,[model:entryModel,
    			tabGroup:view.entryTabs])
    	}
    }
}
