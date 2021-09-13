package other.template

import com.android.tools.idea.wizard.template.*
import other.template.activity.activityTemplateSetup
import other.template.utils.TemplateType
import other.template.vp.hhzActivityTemplateSetup

val HhzTemplate
    get() =template{
        name="生成含ViewPager的Activity"
        description="activity+fragment+viewModel+vpadater"
        category = Category.Activity //那个分类中能找到
        formFactor = FormFactor.Mobile
        screens = listOf(WizardUiContext.FragmentGallery,WizardUiContext.MenuEntry,WizardUiContext.NewProject,WizardUiContext.NewModule)




        val activityName = stringParameter {
            name="LPH activity Name"
            default="MainActivity"
            help="activity名称"
            constraints= listOf(Constraint.NONEMPTY)
        }


        val activityLayoutName = stringParameter {
            name = "LPH Layout Name"
            default ="activity_main"
            help = "Activity布局名称"
            constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
            suggest = { activityToLayout(activityName.value) }
        }

        widgets(
            TextFieldWidget(activityName),
            TextFieldWidget(activityLayoutName),
        )

        recipe={data:TemplateData->
            hhzActivityTemplateSetup(
                data as ModuleTemplateData,
                activityName.value,
                activityLayoutName.value)

        }



    }