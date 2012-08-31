package dictionary

import griffon.transform.Threading
import groovy.json.JsonOutput
import org.eclipse.swt.widgets.FileDialog
import org.eclipse.swt.SWT

class EntryController {
	def model
    def view

    void mvcGroupInit(Map args) {
        model.mvcId = args.mvcId
    }

    def save = {
        model.entry.name = model.name
        model.entry.translation = model.translation
        model.entry.categories = model.categories
        model.entry.notes = model.notes

        def dictionary = app.mvcGroupManager.groups.dictionary.model
        def entries = dictionary.entries
        def file = dictionary.prefs.get("SAVE_FILE","")
        if (file=="") {
            file = selectSaveFile()
            println file
            if (file==null) {
                return
            }
            dictionary.prefs.put("SAVE_FILE",file)
        }

        execInsideUISync {
            view.tab.text = model.name
            if (model.isNew) {
                entries.add(model.entry)
                model.isNew = false
            }
            new File(file).withWriter { out ->
                out.write(JsonOutput.toJson(entries.wrappedList))
            }
        }
    }

    def close = {
        execInsideUISync {
            view.tab.dispose()
            destroyMVCGroup(model.mvcId)
        }
    }

    String selectSaveFile() {
        def file
        execInsideUISync {
            def dialog = new FileDialog(app.mvcGroupManager.groups.dictionary.view.mainShell, 
                SWT.SAVE)
            file = dialog.open()
        }
        return file
    }
}
