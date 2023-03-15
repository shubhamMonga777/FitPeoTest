package com.test.fitpeotest.ui.detail

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import com.squareup.picasso.Picasso
import com.test.fitpeotest.R
import com.test.fitpeotest.base.BaseFragment
import com.test.fitpeotest.databinding.FragmentDetailBinding
import com.test.fitpeotest.domain.Album
import com.test.fitpeotest.util.Constants


class DetailFragment : BaseFragment<FragmentDetailBinding>(FragmentDetailBinding::inflate) {

    private var album: Album? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            album = it.getParcelable(Constants.ALBUM)
        }
    }

    override fun initView() {

    }

    override fun initData() {
        with(binding) {
            toolbar.setNavigationOnClickListener { findNavController().popBackStack() }
            tvTitle.text = album?.title
            Picasso.get().load(album?.url).placeholder(R.color.black10).into(ivImg)
        }
    }


}