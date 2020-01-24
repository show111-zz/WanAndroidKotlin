package com.example.wanandroidkotlin.homes.view

import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.wanandroidkotlin.R
import com.example.wanandroidkotlin.base.BaseActivity
import com.example.wanandroidkotlin.homes.model.HomesModelImpl
import com.example.wanandroidkotlin.homes.viewmodel.HomeVM
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_main.*

/**
 *  Created by hannah on 2020-01-21
 */
class HomeActivity : BaseActivity() {

    lateinit var articleAdapter : ArticleAdapter

    private val homeVM = HomeVM(HomesModelImpl())


    override var layoutId = R.layout.activity_main



    override fun initData() {

        articleAdapter = ArticleAdapter()

        articleRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = articleAdapter
        }

        loadBannerImage()
        loadArticles()
    }

    override fun subscribeUi() {

    }

    /**   load banner image   */
    private fun loadBannerImage(){
        homeVM.homes.subscribeBy(
            onError = { error -> error.printStackTrace()},
            onNext = { model ->
                Glide.with(this)
                    .load(model.data.get(0).imagePath)
                    .into(imgBanner)
            }
        ).disposeOnClear()
    }


    private fun loadArticles(){

        homeVM.articles.subscribeBy (
            onError = { error->error.printStackTrace()},
            onNext = { article ->
                articleAdapter.updateList(article.data.datas)
                articleAdapter.notifyDataSetChanged()
            }
        ).disposeOnClear()

    }



}
