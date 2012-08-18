package dictionary

import org.eclipse.swt.layout.GridData

application(text: 'dictionary', location:[100, 100], size:[320, 240]) {
    migLayout()
    list() {
    	listViewer(input: bind(model:model.entries,modelProperty:'name'))
    }
    label('Blah')
}
