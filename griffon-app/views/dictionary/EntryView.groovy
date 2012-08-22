package dictionary

cTabItem(tabGroup,text:model.name) {
	label(text:"Name:")
	text(text:model.name)
	label(text:"Translation:")
	text(text:model.translation)
	label(text:"Grammatical categories:")
	text(text:model.categories)
	label(text:"Notes:")
	text(text:model.notes)
}