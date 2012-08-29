/*
 * This script is executed inside the UI thread, so be sure to  call
 * long running code in another thread.
 *
 * You have the following options
 * - execOutsideUI { // your code }
 * - execFuture { // your code }
 * - Thread.start { // your code }
 *
 * You have the following options to run code again inside the UI thread
 * - execInsideUIAsync { // your code }
 * - execInsideUISync { // your code }
 */
import groovy.json.JsonSlurper
import org.eclipse.core.databinding.observable.list.WritableList
import dictionary.Entry

def file = new File(app.mvcGroupManager.groups.dictionary.model.prefs.get("SAVE_FILE",""))
if (file.exists()) {
	def entries = app.mvcGroupManager.groups.dictionary.model.entries 
	def readEntries = new JsonSlurper().parseText(file.text)
	readEntries.each {
		entries.add(new Entry(name:it.name,translation:it.translation,
			categories:it.categories,notes:it.notes))

	}
}