package pyxis.uzuki.live.richutilssample

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_refresh_recycler.*
import kotlinx.android.synthetic.main.activity_refresh_recycler_item.view.*
import pyxis.uzuki.live.richutilskt.inflate
import pyxis.uzuki.live.richutilskt.toast

class RefreshRecyclerActivity : AppCompatActivity() {
    private var itemSet: ArrayList<String> = ArrayList()
    private var finalLoaded = 0
    private var adapter: ListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_refresh_recycler)

        recyclerView.setOnRefreshListener {
            for (i in finalLoaded..finalLoaded + 9) {
                itemSet.add(i.toString())
            }
            finalLoaded += 9
            adapter?.notifyDataSetChanged()
        }

        adapter = ListAdapter { position: Int, text: String ->
            toast("clicked ${position}nd item with {$text}")
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        for (i in 0..20) {
            itemSet.add(i.toString())
        }

        (adapter as ListAdapter).notifyDataSetChanged()
    }

    private inner class ListAdapter(var itemClick: (Int, String) -> Unit) : RecyclerView.Adapter<ListHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHolder =
                ListHolder(parent.context.inflate(R.layout.activity_refresh_recycler_item, parent), itemClick = itemClick)

        override fun onBindViewHolder(holder: ListHolder, position: Int) = holder.bind()
        override fun getItemCount(): Int = itemSet.size
    }

    private inner class ListHolder(itemView: View, var itemClick: (Int, String) -> Unit) : RecyclerView.ViewHolder(itemView) {

        @SuppressLint("SetTextI18n")
        fun bind() {
            itemView.txtItem.text = "This is great code! -> $layoutPosition"
            itemView.setOnClickListener { itemClick(layoutPosition, itemView.txtItem.text.toString()) }
        }
    }
}