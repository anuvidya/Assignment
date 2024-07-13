package com.example.myassignment

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myassignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var viewPagerAdapter: viewPagerAdapter
    private lateinit var adapterList: AdapterList
    private val images = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val imagesCarousel  = generateimagesCarousel(100)
        viewPagerAdapter = viewPagerAdapter(this, imagesCarousel)
        activityMainBinding.vpCarousal.adapter = viewPagerAdapter
        viewPagerAdapter.notifyDataSetChanged()

        activityMainBinding.rvList.layoutManager = LinearLayoutManager(this)
        activityMainBinding.rvList.addItemDecoration(SpaceList(16))
        val items = generateItems(100)
        adapterList = AdapterList(items)
        activityMainBinding.rvList.adapter = adapterList

        activityMainBinding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapterList.filter.filter(newText)
                return true
            }
        })


    }

    private fun generateItems(count: Int): List<Item> {
        val itemList = mutableListOf<Item>()
        val imageFruit = arrayOf(R.drawable.apple, R.drawable.orange, R.drawable.banana,R.drawable.watermelon)
        val titleFruit = arrayOf("Apple", "Orange", "Banana", "Watermelon")

        for (i in 0 until count) {
            val image = imageFruit[i % imageFruit.size]
            val title = titleFruit[i % titleFruit.size]
            itemList.add(Item(image, title, "List item subtitle"))
        }
        return itemList
    }

    private fun generateimagesCarousel(count: Int): List<Int> {

        val bg = arrayOf(R.drawable.image2, R.drawable.image1, R.drawable.citytwo)

        for (i in 0 until count) {

            val image = bg[i % bg.size]
            images.add((image))
        }
        return images
    }


}