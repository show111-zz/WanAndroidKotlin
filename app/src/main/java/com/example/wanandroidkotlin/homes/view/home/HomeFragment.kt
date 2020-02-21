package com.example.wanandroidkotlin.homes.view.home

import android.content.Intent
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wanandroidkotlin.R
import com.example.wanandroidkotlin.base.BaseFragment
import com.example.wanandroidkotlin.homes.paging.HomeDataSourceFactory
import com.example.wanandroidkotlin.homes.paging.HomeRepository
import com.example.wanandroidkotlin.homes.viewmodel.HomeViewModel
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*

/**
 *  Created by hannah on 2020-01-28
 */
class HomeFragment : BaseFragment(){

    private lateinit var articleAdapter: HomeAdapter
    private lateinit var homeRepository: HomeRepository
    private lateinit var homeDataSourceFactory: HomeDataSourceFactory
    private val compositeDisposable = CompositeDisposable()

    private lateinit var viewModel: HomeViewModel

    override var layoutId = R.layout.activity_main


    override fun initData() {

        homeDataSourceFactory = HomeDataSourceFactory(compositeDisposable)
        homeRepository = HomeRepository()
        viewModel = getViewModel()

        articleRecyclerView.apply {
            articleAdapter = HomeAdapter()
            articleRecyclerView.layoutManager = LinearLayoutManager(activity)
            articleRecyclerView.addItemDecoration(DividerItemDecoration(activity, LinearLayout.VERTICAL))
            articleRecyclerView.setHasFixedSize(true)
            articleRecyclerView.adapter = articleAdapter
        }

        articleAdapter.onItemClick = {
            startActivity(Intent(activity, WebActivity::class.java).putExtra("link", it.link))
        }

        viewModel.articleList.observe(
            this,
            Observer {
                articleAdapter.submitList(it)
            })
    }

    private fun getViewModel(): HomeViewModel {
        return ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return HomeViewModel(homeRepository) as T
            }
        })[HomeViewModel::class.java]
    }

}
