package com.example.jordanponce

import android.os.Bundle
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.content_photo_details.*

class PhotoDetailsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_details)
        activateToolbar(true)

        val photo = intent.extras?.getParcelable<Photo>(PHOTO_TRANSFER) as Photo

        photo.let {
            photo_title.text = it.title
            photo_author.text = it.author
            photo_tags.text = it.tags
        }

        Picasso.with(this).load(photo.link)
            .error(R.drawable.placeholder)
            .placeholder(R.drawable.placeholder)
            .into(photo_image)
    }

}
