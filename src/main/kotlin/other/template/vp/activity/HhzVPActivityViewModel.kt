package other.template.vp.activity

import com.android.tools.idea.wizard.template.*

fun HhzVPActivityViewModel(
    packageName: String,
    activityName: String,
) ="""package $packageName

    
import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.hzhu.m.ui.viewModel.BaseAndroidViewModel

class ${activityName}ViewModel(application: Application) : BaseAndroidViewModel(application) {
    val refreshPosition: MutableLiveData<Int> = MutableLiveData()
}"""