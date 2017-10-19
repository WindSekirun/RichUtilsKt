package pyxis.uzuki.live.richutilskt.utils

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import java.util.*

/**
 * RHintSpinner
 * Created by WindSekirun 2016-01-09.
 */

class RHintSpinner(private val context: Context) {
    lateinit var spinner: Spinner
    var dropdownList: ArrayList<String> = ArrayList()
    var hintText = ""

    private var onItemSelectedListener: OnItemSelectedListener? = null

    fun setDropdownList(vararg items: String) {
        Collections.addAll(dropdownList, *items)
    }

    fun setDropdownList(vararg items: Int) {
        for (string in items) {
            dropdownList.add(context.getString(string))
        }
    }

    @JvmOverloads fun setOnItemSelectedListener(selectedCallback: (Int) -> Unit, nothingCallback: () -> Unit = {}) {
        this.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(position: Int) {
                selectedCallback(position)
            }

            override fun onNothingSelected() {
                nothingCallback()
            }
        }
    }

    fun apply() {
        val adapter = ListAdapter()
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapter += dropdownList

        if (hintText.isNotEmpty())
            adapter.add(hintText)

        spinner.let {
            it.adapter = adapter
            it.setSelection(adapter.count)
            it.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    onItemSelectedListener?.onNothingSelected()
                }

                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    if (adapter.getItem(position) != hintText)
                        onItemSelectedListener?.onItemSelected(position)
                }
            }
        }
    }

    private inner class ListAdapter : ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item) {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val v = super.getView(position, convertView, parent)
            val textView = v.findViewById<TextView>(android.R.id.text1)

            if (position == count) {
                textView.text = ""
                textView.hint = getItem(count)
            }

            return v
        }

        override fun getCount(): Int {
            return super.getCount() - 1
        }
    }

    interface OnItemSelectedListener {
        fun onItemSelected(position: Int)
        fun onNothingSelected()
    }

}

private operator fun <T> ArrayAdapter<T>.plusAssign(dropdownList: ArrayList<T>) {
    for (elements in dropdownList) this.add(elements)
}
