package other

import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider
import other.template.LphTemplate

//需要在plugin.xml中声明
class WizardTemplateProviderImpl :WizardTemplateProvider() {
    override fun getTemplates(): List<Template> {
        return listOf(LphTemplate)
    }

}