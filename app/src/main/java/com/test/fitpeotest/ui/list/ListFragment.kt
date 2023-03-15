package com.test.fitpeotest.ui.list

import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.test.fitpeotest.R
import com.test.fitpeotest.base.BaseFragment
import com.test.fitpeotest.databinding.FragmentListBinding
import com.test.fitpeotest.domain.Album
import com.test.fitpeotest.ui.list.adaptor.DataAdaptor
import com.test.fitpeotest.ui.list.vm.DataViewModel
import com.test.fitpeotest.util.Constants
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalCoroutinesApi::class)
@AndroidEntryPoint
class ListFragment : BaseFragment<FragmentListBinding>(FragmentListBinding::inflate) {

    private val viewModel: DataViewModel by viewModels()
    private val dataList: ArrayList<Album> by lazy {
        arrayListOf()
    }

    override fun initView() {

    }

    override fun initData() {
        observeData()
        if (dataList.isEmpty())
            viewModel.fetchApiData()
        else setAdaptor(dataList)
    }

    private fun observeData() {
        with(viewModel) {
            albumData.observe(viewLifecycleOwner) {
                if (it.isNotEmpty()) {
                    dataList.addAll(it)
                    setAdaptor(dataList)
                }
            }

            errorLD.observe(viewLifecycleOwner) {
                Snackbar.make(binding.root, it, Snackbar.LENGTH_INDEFINITE)
                    .setAction(R.string.retry) {
                        viewModel.onRetryButtonClick()
                    }.show()
            }

            isProgressVisible.observe(viewLifecycleOwner) {
                binding.progressCircular.visibility = if (it) View.VISIBLE else View.GONE
            }

        }
    }

    private fun setAdaptor(uiData: List<Album>) {

        binding.rvUi.adapter = DataAdaptor(uiData) {
            val bundle = bundleOf(
                Constants.ALBUM to it
            )
            findNavController().navigate(R.id.action_listFragment_to_detailFragment, bundle)
        }
    }

}