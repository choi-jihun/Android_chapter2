package com.example.chapter3_12.playerList

import com.example.chapter3_12.VideoEntity

data class PlayerVideo(
    override val id: String,
    val title: String,
    val videoUrl: String,
    val channelName: String,
    val viewCount: String,
    val dateText: String,
    val channelThumb: String,
    val videoThumb: String
) : PlayerVideoModel

fun VideoEntity.transform(): PlayerVideo {
    return PlayerVideo(
        id = id,
        title = title,
        videoUrl = videoUrl,
        channelName = channelName,
        viewCount = viewCount,
        dateText = dateText,
        channelThumb = channelThumb,
        videoThumb = videoThumb
    )
}