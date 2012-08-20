package dictionary

import org.eclipse.swt.layout.GridData
import org.eclipse.jface.viewers.IDoubleClickListener
import org.eclipse.jface.viewers.DoubleClickEvent

application(text: 'dictionary', location:[100, 100]) {
    migLayout()
    list(layoutData:'west') {
    	listViewer(input: bind(model:model.entries,modelProperty:'name')) {
            //onEvent(type:"DoubleClick",closure:{ println it })
        }
    }
    cTabFolder(id:'tabFolder',layoutData:'east') {
    	cTabItem(text:"test") {
    		label("blubb")
    	}
    	cTabItem(text:"testItem") {
    		label("blibb")
    	}
    }
}
