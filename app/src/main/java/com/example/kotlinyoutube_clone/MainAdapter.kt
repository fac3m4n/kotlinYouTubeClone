package com.example.kotlinyoutube_clone

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.video_row.view.*

class MainAdapter: RecyclerView.Adapter<CustomHolderView>(){

    val videoTitles = listOf(
        "My first Kotlin App", "RecyclerView Demo", "Intro to Kotlin"
    )
    //number of Items
    override fun getItemCount(): Int {
        return videoTitles.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomHolderView {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.video_row, parent, false)
        return CustomHolderView(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomHolderView, position: Int) {
        val videoTitle = videoTitles.get(position)
        holder.view.textView_video_title.text = videoTitle

    }
}

class CustomHolderView(val view: View): RecyclerView.ViewHolder(view){

}