package com.example.kotlinyoutube_clone

import android.content.Intent
import android.icu.number.NumberFormatter.with
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
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


        holder.view.textView_channel_name.text = video.channel.name

        val thumbnailImageView = holder.view.imageView_video_thumb
        Picasso.get().load(video.imageUrl).into(thumbnailImageView)

        val channelProfileImage = holder.view.imageView_channel_thumb
        Picasso.get().load(video.channel.profileImageUrl).into(channelProfileImage)

        holder.video = video


    }
}

class CustomHolderView(val view: View, var video: Video? = null): RecyclerView.ViewHolder(view){

    companion object{
        val VIDEO_TITLE_KEY = "VIDEO TITLE"
        val VIDEO_ID_KEY = "VIDEO_ID"
    }

    init {
        view.setOnClickListener {
            val intent = Intent(view.context, CourseDetailActivity::class.java)

            intent.putExtra(VIDEO_TITLE_KEY, video?.name)
            intent.putExtra(VIDEO_ID_KEY, video?.id)

            view.context.startActivity(intent)
        }
    }
}