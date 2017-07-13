package pyxis.uzuki.live.richutilskt.module.slider

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity

import pyxis.uzuki.live.richutilskt.R
import java.io.File

@Suppress("UNCHECKED_CAST")
abstract class ImageSliderActivity : AppCompatActivity() {
    private var viewPager: ViewPager? = null
    private var imageList: ArrayList<File>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slider)
        viewPager = findViewById(R.id.viewPager) as ViewPager

        imageList = intent.getSerializableExtra(IMAGE_LIST) as ArrayList<File>?

        val pagerAdapter = DemoPagerAdapter(supportFragmentManager)
        viewPager?.adapter = pagerAdapter
    }

    private inner class DemoPagerAdapter internal constructor(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

        override fun getCount(): Int {
            return imageList?.size as Int
        }

        override fun getItem(position: Int): Fragment {
            return MockupFragment.newInstance(position, filenameLength, extension)
        }
    }

    @SuppressLint("ValidFragment")
    inner class SliderFragment() : Fragment() {


    }


    companion object {
        @JvmField val IMAGE_LIST = "imageList";
    }
}
