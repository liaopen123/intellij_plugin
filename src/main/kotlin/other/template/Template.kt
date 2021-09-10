package other.template

import com.android.tools.idea.wizard.template.*
import other.template.activity.activityTemplateSetup
import other.template.utils.TemplateType

val LphTemplate
    get() =template{
        name="廖鹏辉的第一个template"
        description="这个是廖鹏辉的第一个 模板代码 感受一下"
        category = Category.Activity //那个分类中能找到
        formFactor = FormFactor.Mobile
        screens = listOf(WizardUiContext.FragmentGallery,WizardUiContext.MenuEntry,WizardUiContext.NewProject,WizardUiContext.NewModule)


        val templateType = enumParameter<TemplateType> {
            name = "LPH template Type"
            default = TemplateType.Activity
            help = "模板的类型"
        }
        val folderName  = stringParameter {
            name="LPH Folder Name"
            default="main"
            help="📂的名称"
            constraints = listOf(Constraint.NONEMPTY,Constraint.PACKAGE)
        }

        val activityName = stringParameter {
            name="LPH activity Name"
            default="MainActivity"
            help="activity名称"
            constraints= listOf(Constraint.NONEMPTY)
            suggest={ layoutToActivity(folderName.value)}
            visible={templateType.value==TemplateType.Activity}
        }


        val activityLayoutName = stringParameter {
            name = "LPH Layout Name"
            default = "activity_main"
            help = "Activity布局名称"
            constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
            suggest = { activityToLayout(folderName.value) }
            visible = { templateType.value == TemplateType.Activity }
        }

        widgets(
            EnumWidget(templateType),
            TextFieldWidget(folderName),
            TextFieldWidget(activityName),
            TextFieldWidget(activityLayoutName),
        )

        recipe={data:TemplateData->
            activityTemplateSetup(
                data as ModuleTemplateData,
                folderName.value,
                activityName.value,
                activityLayoutName.value
            )

        }



    }