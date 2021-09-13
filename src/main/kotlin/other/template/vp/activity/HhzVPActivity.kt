package other.template.vp.activity

import com.android.tools.idea.wizard.template.*

fun HhzVPActivity(
    packageName: String,
    layoutName: String,
    activityName: String,
    viewModelName: String,
    viewPagerAdapterName: String
) ="""package $packageName

    
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.alibaba.android.arouter.facade.annotation.Route
import com.hzhu.m.base.BaseLifyCycleActivity
import com.hzhu.m.base.binding
import com.hzhu.m.utils.Constant
import com.hzhu.m.widget.transition.TransUtils
import com.hzhu.m.databinding.${underscoreToCamelCase(classToResource(layoutName))}Binding


@Route(path = Constant.ROUTER_${camelCaseToUnderlines(activityName).toUpperCase()})
class ${activityName} : BaseLifyCycleActivity() {
   companion object{
       val REFRESH_SUCCESS = 8888
   }
    private var  currentFragmentPosition = 0
    val viewBinding: ${underscoreToCamelCase(classToResource(layoutName))}Binding by binding()
    private val viewModel: ${viewModelName} by lazy {
        ViewModelProvider(this).get(${viewModelName}::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        initView()
        initData()
        initObserver()
    }
    private fun initView() {
        TransUtils.setWhiteNotchScreen(this)
        TransUtils.setStateBarHeight(this, viewBinding.transView)
        viewBinding.swipeRefresh.setOnRefreshListener {
            viewModel.refreshPosition.value = currentFragmentPosition
        }
        viewBinding.titleBar.addAppbarOffsetChangeListener(viewBinding.appBar){
            viewBinding.swipeRefresh.isEnabled = it == 0
        }
        viewBinding.vp2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                currentFragmentPosition = position
            }
        })
    }

    private fun initData() {
        viewBinding.tabLayout.setupWithViewPager(viewBinding.vp2, listOf<String>("精选", "最新"))
        viewBinding.vp2.adapter = $viewPagerAdapterName(this,"")
    }
    private fun initObserver() {
        viewModel.refreshPosition.observe(this){
            if (it==REFRESH_SUCCESS) viewBinding.swipeRefresh.isRefreshing = false
        }

    }

}"""