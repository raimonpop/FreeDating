package cat.smartcoding.mendez.freedating

import android.os.Bundle
import android.transition.Visibility
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import cat.smartcoding.mendez.freedating.databinding.ActivityMainBinding
import cat.smartcoding.mendez.freedating.ui.home.HomeFragment
import cat.smartcoding.mendez.freedating.ui.home.LikeFragment
import cat.smartcoding.mendez.freedating.ui.home.VisitFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

/*
*
* Application Features:
Matches
Hot or Not
Profile Guests
Profile Likes
Gifts
Profile Photo/Cover
Profile Information
People Nearby
Search users
Friends System
Upgrades (Ghost Mode | Verified Badge | Off Ads)
In-app purchases
Credits – Virtual currency
Simple Gallery
Blocked List
Direct Messages with images/photos (Real time)
Submitting tickets to support from application
Abuse reports to photos and users
Facebook login|sign up|connect|disconnect
Support Emoji in photos comments, gifts comments and messages.
Profile photo and cover
Push notifications about profile likes, gifts, messages, friend requests and accept friend request
Personalize your notifications
AdMob banner
Rewarded video Ads
And much more …
*
* */
class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        binding.appBarMain.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home,
                R.id.nav_gallery,
                R.id.nav_slideshow,
                R.id.nav_settings,
                R.id.nav_profiles
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        // Bottom navigation setup
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation_view)
        bottomNavigationView.setupWithNavController(navController)
        val fragments = arrayListOf<Fragment>(HomeFragment(), LikeFragment(), VisitFragment())
        // Viewpager2
        val adapter = object :  FragmentStateAdapter(this) {
            override fun getItemCount(): Int = 3
            override fun createFragment(position: Int): Fragment = fragments[position]
        }

        val viewPager2: ViewPager2 = binding.appBarMain.viewPager
        viewPager2.adapter = adapter // Error use navgtion in adapter
        val tabs: TabLayout = binding.appBarMain.tabs
        TabLayoutMediator(tabs, viewPager2) { tab, position ->
            tab.text = "OBJECT ${(position + 1)}"
        }.attach()
        enableTabs()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        navController.navigateUp()
//        navController.navigate()
        return super.onOptionsItemSelected(item)
//        when(item.itemId) {
//        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    fun enableTabs() {
        binding.appBarMain.tabs.visibility = View.VISIBLE
    }

    fun disableTabs() {
        binding.appBarMain.tabs.visibility = View.GONE
    }
}