package dictionary

import griffon.transform.Threading

class DictionaryController {
    def view

    @Threading(Threading.Policy.SKIP)
    def copyText = {
        view.output.text = "[COPY] ${view.input.text}"
    }
}
