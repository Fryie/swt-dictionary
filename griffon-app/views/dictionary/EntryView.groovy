package dictionary

cTabItem(tabGroup,text:"  "+model.name+"  ",id:"tab") {
	composite {
		migLayout(layoutConstraints:"wrap 2")
		label(text:"Name:")
		text(text:model.name) {
			onEvent(type:'Modify') { evt -> 
				model.name=evt.widget.text
			 }
		}
		label(text:"Translation:")
		text(text:model.translation) {
			onEvent(type:'Modify') { evt -> 
				model.translation=evt.widget.text
			 }
		}
		label(text:"Grammatical categories:")
		text(text:model.categories) {
			onEvent(type:'Modify') { evt -> 
				model.categories=evt.widget.text
			 }
		}
		label(text:"Notes:")
		text(text:model.notes) {
			onEvent(type:'Modify') { evt -> 
				model.notes=evt.widget.text
			 }
		}
		button(text:"Save") {
			onEvent(type:'Selection') { controller.save() }
		}
		button(text:"Close") {
			onEvent(type:'Selection') { controller.close() }
		}
	}
}