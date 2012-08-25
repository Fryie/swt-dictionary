package dictionary

import org.eclipse.jface.viewers.IDoubleClickListener
import org.eclipse.jface.viewers.DoubleClickEvent;

application(text: 'dictionary', location:[100, 100]) {
    fillLayout()
    sf = sashForm {
        migLayout(layoutConstraints:"fill")
        list(layoutData:"growy") {
    	   listViewer(input: bind(model:model.entries,modelProperty:'name'))
                .addDoubleClickListener(new IDoubleClickListener(){
    			     public void doubleClick(DoubleClickEvent event) {
    				    openEntry(event.selection.getFirstElement())
    			 }
    		  })
        }
        cTabFolder(id:'entryTabs')
    }
    sf.weights=[20,80]
}

def openEntry(entryModel) {
    controller.openEntry(entryModel)
}
