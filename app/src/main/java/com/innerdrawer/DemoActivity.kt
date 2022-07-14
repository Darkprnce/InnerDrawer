package com.innerdrawer

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import androidx.core.content.ContextCompat
import com.innerdrawer.Model.NavMenuItem
import com.innerdrawer.Ui.InnerDrawer
import com.innerdrawer.databinding.ActivityDemoBinding
import com.innerdrawer.databinding.AppBarDashboardBinding
import com.innerdrawer.databinding.NavHeaderMainBinding

class DemoActivity : AppCompatActivity() {
    private var TAG = this.javaClass.simpleName

    private lateinit var dashboard_binding: ActivityDemoBinding
    private lateinit var binding: AppBarDashboardBinding
    private lateinit var header_binding: NavHeaderMainBinding
    private lateinit var mContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dashboard_binding = ActivityDemoBinding.inflate(layoutInflater)
        binding = dashboard_binding.llDashboard

        val view = dashboard_binding.root
        setContentView(view)
        mContext = this@DemoActivity

        initView()
    }

    private fun initView() {

        //set blur on main content when drawer is open
        dashboard_binding.navView.setBlurContentEnabled(true)

        //set default appbar
        dashboard_binding.navView.setAppBarEnabled(true)

        // set appbar color
       // dashboard_binding.navView.setNavIconColor(ContextCompat.getColor(mContext, R.color.black))

        //set appbar title
        dashboard_binding.navView.setAppbarTitle("Dragon Ball Z")

        // set appbar color
     //   dashboard_binding.navView.setAppbarColor(ContextCompat.getColor(mContext, R.color.white))

        //set appbar title color
      /*  dashboard_binding.navView.setAppbarTitleTextColor(
            ContextCompat.getColor(
                mContext,
                R.color.black
            )
        )
*/
        //set appbar title font
        val font_a = Typeface.createFromAsset(mContext.assets, "ZenDots-Regular.ttf")
        dashboard_binding.navView.setAppbarTitleTypeface(font_a)

        //if you want to close drawer on menu item click
        dashboard_binding.navView.setCloseDrawerOnMenuClick(true)

        //set footer view
        val footerview: View = LayoutInflater.from(mContext).inflate(R.layout.nav_footer_main, null)
        dashboard_binding.navView.setFooterView(footerview)

        //set header view
        val headerview: View = LayoutInflater.from(mContext).inflate(R.layout.nav_header_main, null)
        dashboard_binding.navView.setHeaderView(headerview)

        //set footer inside menu list
        dashboard_binding.navView.setFooterInside(false)

        //set header inside menu list
        dashboard_binding.navView.setHeaderInside(false)

        //set drawer background color
        //dashboard_binding.navView.setNavigationDrawerBackgroundColor(R.color.white)

        //set menu item text color
        dashboard_binding.navView.setMenuItemTextColor(
            ContextCompat.getColor(
                mContext,
                R.color.white
            )
        )

        //set menu item text size
        dashboard_binding.navView.setmenuItemTextSize(20f)

        //set menu item gravity
        dashboard_binding.navView.setMenuItemGravity(Gravity.TOP)

        // set font for menu items
        val font = Typeface.createFromAsset(mContext!!.assets, "ZenDots-Regular.ttf")
        dashboard_binding.navView.setmenuItemFont(font)


        //set status bar icon color
        dashboard_binding.navView.setstatusbarIconDark(true)

        //set main content shrink value
        dashboard_binding.navView.setshrinkValue(0.8f)

        // open drawer
        // dashboard_binding.navView.openDrawer()

        //close drawer
        //dashboard_binding.navView.closeDrawer()

        //set background image to drawer
        dashboard_binding.navView.setBackgroundItem(
            BitmapFactory.decodeResource(
                resources,
                R.drawable.nav_bg
            )
        )


        //create menu list
        val menuItems: ArrayList<NavMenuItem> = ArrayList()
        menuItems.add(NavMenuItem("Home", R.drawable.home_icon))
        menuItems.add(NavMenuItem("Settings", R.drawable.settings_icon))
        menuItems.add(NavMenuItem("Share", R.drawable.share_icon_small))


        // set menu at last
        dashboard_binding.navView.setMenuItemList(this, menuItems)

        //add menu item dynamically
        //dashboard_binding.navView.addMenuItem(NavMenuItem("Test",R.drawable.home_icon))

        //access different menu from title
        dashboard_binding.navView.setOnMenuItemClickListener(object :
            InnerDrawer.OnMenuItemClickListener {
            override fun onMenuItemClicked(title: String) {
                dashboard_binding.navView.setAppbarTitle(title)
                Log.e(TAG, "onMenuItemClicked: " + title)
            }
        })


        //get header view
        header_binding = NavHeaderMainBinding.bind(dashboard_binding.navView.getHeaderView()!!)
        header_binding.txtuserName.text = "Kakarot"
        header_binding.txtuserId.text = "Son Goku"

        //drawer listener
        dashboard_binding.navView.setOnDrawerListener(object : InnerDrawer.DrawerListener {
            override fun onDrawerOpening() {
                Log.d(TAG, "onDrawerOpening: ")
            }

            override fun onDrawerClosing() {
                Log.d(TAG, "onDrawerClosing: ")
            }

            override fun onDrawerOpened() {
                Log.d(TAG, "onDrawerOpened: ")
            }

            override fun onDrawerClosed() {
                Log.d(TAG, "onDrawerClosed: ")
            }

            override fun onDrawerStateChanged(newState: Int) {
                Log.d(TAG, "onDrawerStateChanged: ")
            }
        })

        //Nav Icon listener
        dashboard_binding.navView.setOnNavIconClickListener(object :
            InnerDrawer.OnNavIconClickListener {
            override fun onNavIconClicked() {
                Log.d(TAG, "onHamMenuClicked: ")
            }
        })

    }
}