package dictionary

import org.eclipse.jface.viewers.IDoubleClickListener
import org.eclipse.jface.viewers.DoubleClickEvent
import org.eclipse.jface.viewers.ISelectionChangedListener
import org.eclipse.jface.viewers.SelectionChangedEvent

application(text: 'dictionary', location:[100, 100], id:"mainShell") {
    fillLayout()
    menu(style:"bar") {
        menuItem(text:"&File",style:"cascade") {
            menu(style:"drop_down") {
                menuItem(style:"push", text:"Open dictionary") {
                    onEvent(type:"Selection") { println 'o.d.'}
                }
            }
        }
    }
    sf = sashForm {
        migLayout(layoutConstraints:"fill")
        composite {
            migLayout()
            list(style:"multi",layoutData:"grow,wrap,h 80%") {
    	       lv = listViewer(input: bind(model:model.entries,modelProperty:'name'))
               lv.addDoubleClickListener(new IDoubleClickListener(){
    		        void doubleClick(DoubleClickEvent evt) {
    				    openEntry(evt.selection.getFirstElement())
    			    }
    		    })
                lv.addSelectionChangedListener(new ISelectionChangedListener(){
                    void selectionChanged(SelectionChangedEvent evt) {
                        println evt.selection
                        //setSelection(evt.selection)
                    }
                })
            }
            button(text:"New Entry",layoutData:"growx,wrap") {
                onEvent(type:"Selection") { controller.newEntry() }
            }
            button(text:"Delete selected",layoutData:"growx") {
                onEvent(type:"Selection") { evt -> println evt.widget }
            }
        }
        cTabFolder(id:'entryTabs',simple:false)
    }
    sf.weights=[20,80]
}

def openEntry(entryModel) {
    controller.openEntry(entryModel)
}
