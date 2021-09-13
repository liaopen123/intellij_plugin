package other.template.vp.activity

import com.android.tools.idea.wizard.template.*

fun HhzVPFragment(
    packageName: String,
    layoutName: String,
    fragmentName: String,
    activityName: String,
    fragmentViewModelName: String
) ="""package $packageName

    
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.hzhu.adapter.ViewBindingItemProvider
import com.hzhu.adapter.loadmore.MultiLoadMoreAdapter
import com.hzhu.adapter.loadmore.MultiLoadMoreAdapterProvider
import com.hzhu.adapter.loadmore.MultiLoadMoreDelegate
import com.hzhu.m.base.BaseFragment
import com.hzhu.m.base.FooterItemViewBindingItemProvider
import com.hzhu.m.databinding.*
import com.hzhu.m.ui.brand.PARAMS_ID
import com.hzhu.m.utils.withArgs
import com.hzhu.m.widget.transition.TranslateInRightAnimator


class ${fragmentName} : BaseFragment<${underscoreToCamelCase(classToResource(layoutName))}Binding>() {

    private var page = 1
    private var justRefresh = true
    private var currentFragmentPosition: Int? = null
    private val viewModel by lazy {
        ViewModelProvider(this).get($fragmentViewModelName::class.java)
    }
    private val ${underscoreToCamelCase(activityName)}ViewModel by activityViewModels<${activityName}ViewModel>()

    private val mAdapter: MultiLoadMoreAdapter<Any> by lazy {
        MultiLoadMoreAdapter(
            provider = MultiLoadMoreAdapterProvider(
                itemProvider = ViewBindingItemProvider { viewGroup, _ ->
                    ItemConversationHeadBinding.inflate(LayoutInflater.from(activity), viewGroup, false)
                },
                headerProvider = null,
                footerProvider = FooterItemViewBindingItemProvider()
            ),
            loadMoreDelegate = object : MultiLoadMoreDelegate() {
                override fun onLoadMore() {
                    justRefresh = false
                    page++
                    initData()
                }
            },
            init = { viewBinding, entity, i ->
                viewBinding as ItemConversationHeadBinding
                entity as String
                viewBinding.tvStatusTitle.text = entity

            },
            footInit = { viewBinding, commonFooterBean, i -> },
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        currentFragmentPosition = arguments?.getInt(PARAMS_ID )
        initViews()
        initData()
        bindViewModel()
    }

    private fun initViews() {
        viewBinding.rv.apply {
            itemAnimator = TranslateInRightAnimator()
            layoutManager = LinearLayoutManager(context)
            adapter = mAdapter
        }
    }

    private fun initData() {
        if (!justRefresh) {
            viewBinding.loadingView.showLoadingFullScreen()
        }
        viewModel.getWikiList(page)
    }

    private fun bindViewModel() {
        ${underscoreToCamelCase(activityName)}ViewModel.refreshPosition.observe(viewLifecycleOwner){
            if (it==currentFragmentPosition){
                justRefresh =true
                page=1
                initData()
            }
        }
        viewModel.dataList.observe(viewLifecycleOwner) {
            viewBinding.loadingView.loadingCompleteFullScreen()
            if (page == 1) {
                ${underscoreToCamelCase(activityName)}ViewModel.refreshPosition.value= $activityName.REFRESH_SUCCESS
                mAdapter.setData(it)
            } else {
                mAdapter.addHisData(it)
                mAdapter.finishLoadMore()
            }
//            if (value.isOver == AskMerchantViewModel.FLAG_IS_OVER) {
//                adapter.noMore()
//            }
        }

    }


    companion object {
        fun newInstance(position: Int) = $fragmentName().withArgs {
            putInt(PARAMS_ID, position)
        }
    }


}"""