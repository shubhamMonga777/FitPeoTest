package com.test.fitpeotest.ui.list.adaptor.viewHolder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.squareup.picasso.Picasso
import com.test.fitpeotest.R
import com.test.fitpeotest.domain.Album
import de.hdodenhof.circleimageview.CircleImageView

class DataViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

    constructor(parent: ViewGroup) : this(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_album, parent, false
        )
    )

    private val mImage: CircleImageView = itemView.findViewById(R.id.ivImg)
    private val mTitle: AppCompatTextView = itemView.findViewById(R.id.tvTitle)
    private val mParent: MaterialCardView = itemView.findViewById(R.id.parentPanel)

    fun bindData(data: Album, onSelect: (Album) -> Unit) {
        mParent.setOnClickListener { onSelect(data) }
        mTitle.text = data.title
        Picasso.get().load(data.thumbnailUrl).placeholder(R.color.black10).into(mImage)
    }


}