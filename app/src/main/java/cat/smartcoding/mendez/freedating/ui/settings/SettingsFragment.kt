package cat.smartcoding.mendez.freedating.ui.settings

import android.content.Context
import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import cat.smartcoding.mendez.freedating.MainActivity
import cat.smartcoding.mendez.freedating.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as MainActivity).disableTabs()
    }
}