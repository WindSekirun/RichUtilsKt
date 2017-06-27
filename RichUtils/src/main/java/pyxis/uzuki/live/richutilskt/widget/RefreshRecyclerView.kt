package pyxis.uzuki.live.richutilskt.widget

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.widget.AbsListView

class RefreshRecyclerView : RecyclerView {
    private var refreshCallback: OnRefreshListener? = null

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init()
    }

    internal var isBottom = false
    internal var firstVisibleItem: Int = 0
    internal var visibleItemCount: Int = 0
    internal var totalItemCount: Int = 0

    private fun init() {
        itemAnimator = null
        animation = null

        addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE && isBottom) {
                    refreshCallback?.onRefresh()
                }
            }

            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                isBottom = false
                if (dy > 0) {
                    if (layoutManager !is LinearLayoutManager) {
                        return
                    }

                    visibleItemCount = childCount
                    totalItemCount = layoutManager.itemCount
                    firstVisibleItem = (layoutManager as LinearLayoutManager).findFirstCompletelyVisibleItemPosition()

                    isBottom = totalItemCount > 0 && firstVisibleItem + visibleItemCount >= totalItemCount

                }
            }
        })
    }


    fun setOnRefreshListener(callback: () -> Unit) {
       refreshCallback = object : OnRefreshListener {
           override fun onRefresh() {
               callback.invoke()

           }
       }
    }

    interface OnRefreshListener {
        fun onRefresh()
    }

}
