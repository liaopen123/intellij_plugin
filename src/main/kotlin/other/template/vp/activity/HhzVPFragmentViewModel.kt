package other.template.vp.activity

import com.android.tools.idea.wizard.template.*

fun HhzVPFragmentViewModel(
    packageName: String,
    fragmentViewModelName: String,
) ="""package $packageName

    
import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.hzhu.m.ui.viewModel.BaseAndroidViewModel


class $fragmentViewModelName(application: Application) : BaseAndroidViewModel(application) {

     val dataList = MutableLiveData<List<String>>()

    fun getWikiList(page: Int) {
        dataList.value = listOf<String>("1","2","3","4","5","6","7","8","9","1","2","3","4","5","6","7","8","9","1","2","3","4","5","6","7","8","9")
    }


}"""