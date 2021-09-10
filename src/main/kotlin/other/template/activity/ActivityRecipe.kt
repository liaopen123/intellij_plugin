package other.template.activity

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.addAllKotlinDependencies
import other.template.utils.getModuleDir
import other.template.utils.save


fun RecipeExecutor.activityTemplateSetup(
    moduleData: ModuleTemplateData,
    folderName: String,
    activityName: String,
    activityLayoutName: String
){
    addAllKotlinDependencies(moduleData)
    val packageName = moduleData.packageName
    val folderPath = "$packageName.ui.activities.$folderName"
    val moduleDir = getModuleDir(moduleData)

    val directorySrc = moduleDir.first ?: return
    val directoryRes = moduleDir.second ?: return

    //create and save file
    LphActivity(packageName, folderName, activityLayoutName, activityName, "viewmodelname")
        .save(directorySrc, folderPath, "${activityName}.kt")
//    MVVMActivityViewModel(packageName, folderName, activityViewModelName)
//        .save(directorySrc, folderPath, "${activityViewModelName}.kt")
    LphLayout(packageName, folderName, "23333")
        .save(directoryRes, "layout", "${activityLayoutName}.xml")
}