package dictionary

tab = cTabItem(tabGroup,text:"  "+model.name+"  ",id:"tab") {
	composite {
		migLayout(layoutConstraints:"wrap 2",columnConstraints:"[]rel[grow]")
		label(text:"Name:")
		text(text:model.name,layoutData:"growx") {
			onEvent(type:'Modify') { evt -> 
				model.name=evt.widget.text
			 }
		}
		label(text:"Translation:")
		text(text:model.translation,layoutData:"growx") {
			onEvent(type:'Modify') { evt -> 
				model.translation=evt.widget.text
			 }
		}
		label(text:"Grammatical categories:")
		text(text:model.categories,layoutData:"growx") {
			onEvent(type:'Modify') { evt -> 
				model.categories=evt.widget.text
			 }
		}
		label(text:"Notes:",layoutData:"top, left")
		text(text:model.notes,style:"multi, border, wrap, v_scroll",layoutData:"growx, h 200") {
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