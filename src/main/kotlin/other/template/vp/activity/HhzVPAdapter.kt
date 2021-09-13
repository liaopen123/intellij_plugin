package other.template.vp.activity


fun HhzVPAdapter(
    packageName: String,
    vpAdatperName: String,
    fragmentName: String,
) ="""package $packageName

    
import android.util.SparseArray
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class $vpAdatperName(fragmentActivity: FragmentActivity, params: String) : FragmentStateAdapter(fragmentActivity) {

    private val fragments = SparseArray<Fragment>()

    init {
        fragments.put(0, ${fragmentName}.newInstance(0))
        fragments.put(1, ${fragmentName}.newInstance(1))
    }

    override fun getItemCount(): Int = fragments.size()

    override fun createFragment(position: Int): Fragment {
        return fragments.get(position)
    }

}"""