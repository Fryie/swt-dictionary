package dictionary

import griffon.transform.Threading
import org.eclipse.swt.widgets.FileDialog
import org.eclipse.swt.SWT
import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import org.eclipse.core.databinding.observable.list.WritableList

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

    def deleteEntries = { entries ->
        entries.each { entry ->
            execInsideUISync {
                // if already open, call close action
                if (model.openEntries.containsKey(entry)) {
                    model.openEntries[entry].controller.close()
                }
                model.entries.remove(entry)
            }
        }
        saveToFile()
    }

    def saveToFile = {
        def entries = model.entries
        def file = model.prefs.get("SAVE_FILE","")
        if (file=="") {
            file = selectFile(SWT.SAVE)
            if (file==null) {
                return
            }
            model.prefs.put("SAVE_FILE",file)
        }

        execInsideUISync {
            new File(file).withWriter { out ->
                out.write(JsonOutput.toJson(entries.wrappedList))
            }
        }
    }

    def newDictionary = {
        execInsideUISync {
            model.openEntries.each { k, v ->
                v.controller.close()
            }
            model.openEntries.clear()
            model.entries.clear()
        }
        model.prefs.remove("SAVE_FILE")
    }

    def openFile = {
        def file = selectFile(SWT.OPEN)
        if (file!=null) {
            model.prefs.put("SAVE_FILE",file)
            load(new File(file))
        }
    }

    def loadDefault = {
        def file = new File(model.prefs.get("SAVE_FILE",""))
        load(file)
    }

    void load(file) {
        if (file.exists()) {
            def readEntries = new JsonSlurper().parseText(file.text)
            execInsideUISync {
                model.entries.clear()
                readEntries.each {
                    model.entries.add(new Entry(name:it.name,translation:it.translation,
                        categories:it.categories,notes:it.notes))
                }
            }
        }
    }

    String selectFile(mode) {
        def file
        execInsideUISync {
            def dialog = new FileDialog(view.mainShell, mode)
            file = dialog.open()
        }
        return file
    }
}