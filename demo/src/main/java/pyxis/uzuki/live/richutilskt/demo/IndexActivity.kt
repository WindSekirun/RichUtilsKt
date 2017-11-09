package pyxis.uzuki.live.richutilskt.demo

import android.Manifest
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_index.*
import kotlinx.android.synthetic.main.activity_index_item.view.*
import pyxis.uzuki.live.richutilskt.demo.item.CategoryItem
import pyxis.uzuki.live.richutilskt.demo.item.ExecuteItem
import pyxis.uzuki.live.richutilskt.demo.item.MainItem
import pyxis.uzuki.live.richutilskt.demo.set.*
import pyxis.uzuki.live.richutilskt.utils.RPermission
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

        val item = intent.getSerializableExtra("index") as MainItem
        itemList.addAll(getItemList(item.categoryItem))

        itemList.sortBy { it.title }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0 && fab.visibility == View.VISIBLE) {
                    fab.hide()
                } else if (dy < 0 && fab.visibility != View.VISIBLE) {
                    fab.show()
                }
            }
        })

        supportActionBar?.title = "${item.title} :: RichUtils"
        supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        adapter.notifyDataSetChanged()

        fab.setOnClickListener {
            browseToFile(item.link)
        }

        val permissionArray = when (item.categoryItem) {
            CategoryItem.DEVICEID -> arrayOf(Manifest.permission.READ_PHONE_STATE)
            else -> null
        }

        if (permissionArray != null) {
            RPermission.instance.checkPermission(this, permissionArray)
        }

    }

    inner class ListAdapter : RecyclerView.Adapter<ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder =
                ViewHolder(this@IndexActivity, inflate(R.layout.activity_index_item, parent))

        override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
            holder?.bindData(itemList[position])
        }

        override fun getItemCount(): Int = itemList.size
    }

    var extendedPosition = -1

    inner class ViewHolder(private val context: Context, itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindData(item: ExecuteItem) {
            val isShow = extendedPosition == adapterPosition

            itemView.imgExpand.isSelected = isShow
            itemView.txtTitle.text = item.title
            itemView.txtSummary.text = item.message

            itemView.btnExecute.visibility = if (item.execute == null) View.GONE else View.VISIBLE

            itemView.btnExecute.setOnClickListener {
                item.execute?.invoke(context)
            }

            if (isShow) {
                itemView.containerMore.visibility = View.VISIBLE
                itemView.divider.visibility = View.VISIBLE
            } else {
                itemView.containerMore.visibility = View.GONE
                itemView.divider.visibility = View.GONE
            }

            itemView.txtKotlinSample.text = item.kotlinSample
            itemView.txtJavaSample.text = item.javaSample

            itemView.containerTitle.setOnClickListener {
                extendedPosition = if (isShow) -1 else adapterPosition
                adapter.notifyDataSetChanged()
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}