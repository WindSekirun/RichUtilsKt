package pyxis.uzuki.live.richutilskt.demo

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_index_item.view.*
import kotlinx.android.synthetic.main.activity_main.*
import pyxis.uzuki.live.richutilskt.demo.item.CategoryItem
import pyxis.uzuki.live.richutilskt.demo.item.ExecuteItem
import pyxis.uzuki.live.richutilskt.demo.set.getAlertSet
import pyxis.uzuki.live.richutilskt.utils.inflate

/**
 * RichUtilsKt
 * Class: IndexActivity
 * Created by Pyxis on 2017-11-06.
 *
 * Description:
 */
class IndexActivity : AppCompatActivity() {
    private val itemList = ArrayList<ExecuteItem>()
    private val adapter = ListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_index)

        val category = intent.getSerializableExtra("index") as CategoryItem
        itemList.addAll(getItemSet(category))

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    inner class ListAdapter : RecyclerView.Adapter<ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder =
                ViewHolder(this@IndexActivity, inflate(R.layout.activity_index_item, parent))

        override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
            holder?.bindData(itemList[position])
        }

        override fun getItemCount(): Int = itemList.size
    }

    inner class ViewHolder(private val context: Context, itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindData(item: ExecuteItem) {
            itemView.txtTitle.text = item.title
            itemView.txtSummary.text = item.message

            itemView.btnExecute.setOnClickListener {
                item.execute?.invoke(context)
            }

            val show = itemView.imgExpand.isSelected
            if (show) {
                itemView.containerMore.visibility = View.VISIBLE
                itemView.divider.visibility = View.VISIBLE
            } else {
                itemView.containerMore.visibility = View.GONE
                itemView.divider.visibility = View.GONE
            }

            val javaSample = itemView.btnSampleSwitch.isChecked
            if (javaSample) {
                itemView.txtSample.text = item.javaSample
            } else {
                itemView.txtSample.text = item.kotlinSample
            }

            itemView.imgExpand.setOnClickListener {
                itemView.imgExpand.isSelected = !show
                adapter.notifyDataSetChanged()
            }

            itemView.containerTitle.setOnClickListener {
                itemView.imgExpand.isSelected = !show
                adapter.notifyDataSetChanged()
            }

            itemView.btnSampleSwitch.setOnCheckedChangeListener { _, _ ->
                adapter.notifyDataSetChanged()
            }
        }
    }

    fun getItemSet(categoryItem: CategoryItem): ArrayList<ExecuteItem> {
        return when (categoryItem) {
            CategoryItem.ALERT -> getAlertSet()
        }
    }
}