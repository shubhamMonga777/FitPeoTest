package com.test.fitpeotest.ui.list.adaptor

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.fitpeotest.domain.Album
import com.test.fitpeotest.ui.list.adaptor.viewHolder.DataViewHolder

class DataAdaptor(private val uiList: List<Album>, private val onSelect: (Album) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return DataViewHolder(parent)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {

            is DataViewHolder -> holder.bindData(data = uiList[position],onSelect)
        }
    }

    override fun getItemCount(): Int = uiList.size

}