package other.template.vp

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.fragmentToLayout
import com.android.tools.idea.wizard.template.impl.activities.common.addAllKotlinDependencies
import other.template.utils.activityName2Fragment
import other.template.utils.activityName2ViewPagerAdapterName
import other.template.utils.getModuleDir
import other.template.utils.save
import other.template.vp.activity.*


fun RecipeExecutor.hhzActivityTemplateSetup(
    moduleData: ModuleTemplateData,
    activityName: String,
    activityLayoutName: String
){
    addAllKotlinDependencies(moduleData)
    val packageName = moduleData.packageName
    val folderPath = "$packageName"
    val moduleDir = getModuleDir(moduleData)

    val activityViewModelName = "${activityName}ViewModel"
    val viewPagerAdapterName = activityName2ViewPagerAdapterName(activityName)
    val fragmentName = activityName2Fragment(activityName)
    val fragmentViewModelName = "${fragmentName}ViewModel"
    val fragmentLayoutName = fragmentToLayout(fragmentName)

    val directorySrc = moduleDir.first ?: return
    val directoryRes = moduleDir.second ?: return


    //create and save file
    HhzVPActivity(packageName, activityLayoutName, activityName, "${activityName}ViewModel",viewPagerAdapterName)
        .save(directorySrc, folderPath, "${activityName}.kt")
    HhzVPActivityViewModel(packageName, activityName)
        .save(directorySrc, folderPath, "${activityName}ViewModel.kt")
    HhzVPAdapter(packageName,viewPagerAdapterName,fragmentName)
        .save(directorySrc, folderPath, "$viewPagerAdapterName.kt")
    HhzVPActivityLayout().save(directoryRes, "layout", "${activityLayoutName}.xml")
    HhzVPFragment(packageName,fragmentLayoutName,fragmentName,activityName,fragmentViewModelName)
        .save(directorySrc, folderPath, "$fragmentName.kt")
    HhzVPFragmentViewModel(packageName,fragmentViewModelName)
        .save(directorySrc, folderPath, "$fragmentViewModelName.kt")
    HhzVPFragmentLayout().save(directoryRes, "layout", "$fragmentLayoutName.xml")
}