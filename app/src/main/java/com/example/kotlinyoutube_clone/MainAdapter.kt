package com.example.kotlinyoutube_clone

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.video_row.view.*

class MainAdapter(val homeFeed: HomeFeed): RecyclerView.Adapter<CustomHolderView>(){

    val videoTitles = listOf(
        "My first Kotlin App", "RecyclerView Demo", "Intro to Kotlin"
    )
    //number of Items
    override fun getItemCount(): Int {
        return homeFeed.videos.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomHolderView {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.video_row, parent, false)
        return CustomHolderView(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomHolderView, position: Int) {
//        val videoTitle = videoTitles[position]
        val video = homeFeed.videos[position]
        holder.view.textView_video_title.text = video.name

    }
}

class CustomHolderView(val view: View): RecyclerView.ViewHolder(view){

}