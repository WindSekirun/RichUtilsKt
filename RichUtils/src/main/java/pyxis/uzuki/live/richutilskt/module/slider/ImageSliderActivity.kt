package pyxis.uzuki.live.richutilskt.module.slider

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import pyxis.uzuki.live.richutilskt.R
import pyxis.uzuki.live.richutilskt.utils.getBitmap
import pyxis.uzuki.live.richutilskt.utils.inflate

@Suppress("UNCHECKED_CAST")
abstract class ImageSliderActivity : AppCompatActivity() {
    private var viewPager: ViewPager? = null
    private var imageList: ArrayList<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slider)
        viewPager = findViewById(R.id.viewPager) as ViewPager

        imageList = intent.getSerializableExtra(IMAGE_LIST) as ArrayList<String>?

        val pagerAdapter = DemoPagerAdapter(supportFragmentManager)
        viewPager?.adapter = pagerAdapter
    }

    private inner class DemoPagerAdapter internal constructor(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

        override fun getCount(): Int {
            return imageList?.size as Int
        }

        override fun getItem(position: Int): Fragment {
            val bundle = Bundle()
            bundle.putInt("pos", position)

            val fragment = SliderFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    @SuppressLint("ValidFragment")
    inner class SliderFragment() : Fragment() {
        override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            val v = inflate(R.layout.fragment_slider, container)
            val imgDemo = v.findViewById(R.id.imgDemo) as ImageView

            imgDemo.setImageBitmap(imageList?.get(arguments.getInt("pos"))?.getBitmap())
            return super.onCreateView(inflater, container, savedInstanceState)
        }
    }

    companion object {
        @JvmField val IMAGE_LIST = "imageList"
    }
}
