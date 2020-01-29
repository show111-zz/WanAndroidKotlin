package com.example.wanandroidkotlin.detail.view.knowledge

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wanandroidkotlin.R
import com.example.wanandroidkotlin.base.BaseFragment
import com.example.wanandroidkotlin.detail.usecase.KnowledgeUseCaseImpl
import com.example.wanandroidkotlin.detail.viewmodel.KnowledgeVM
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.fragment_knowledge.*

/**
 *  Created by hannah on 2020-01-28
 */
class KnowledgeFragment : BaseFragment(){

    private lateinit var knowledgeAdapter: KnowledgeAdapter

    private lateinit var knowledgeVM: KnowledgeVM

    override var layoutId: Int = R.layout.fragment_knowledge

    override fun initData() {
        knowledgeAdapter = KnowledgeAdapter()
        knowledgeRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = knowledgeAdapter
        }

        knowledgeVM = KnowledgeVM(KnowledgeUseCaseImpl())

        knowledgeVM.knowledge.subscribeBy {
            knowledgeAdapter.setData(it)
            knowledgeAdapter.notifyDataSetChanged()
        }

    }
}
