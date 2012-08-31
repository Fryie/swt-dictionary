package dictionary

import org.eclipse.jface.viewers.IDoubleClickListener
import org.eclipse.jface.viewers.DoubleClickEvent
import org.eclipse.swt.custom.CTabFolder2Adapter
import org.eclipse.swt.custom.CTabFolderEvent

application(text: 'dictionary', location:[100, 100], id:"mainShell") {
    fillLayout()
    sf = sashForm {
        migLayout(layoutConstraints:"fill")
        composite {
            migLayout(layoutConstraints:"fill")
            list(layoutData:"grow,wrap,h 90%") {
    	       listViewer(input: bind(model:model.entries,modelProperty:'name'))
                    .addDoubleClickListener(new IDoubleClickListener(){
    			         public void doubleClick(DoubleClickEvent event) {
    				        openEntry(event.selection.getFirstElement())
    			     }
    		      })
            }
            button(text:"New Entry",layoutData:"growx") {
                onEvent(type:"Selection") { controller.newEntry() }
            }
        }
        cTabFolder(id:'entryTabs',simple:false)
    }
    sf.weights=[20,80]
}

def openEntry(entryModel) {
    controller.openEntry(entryModel)
}
