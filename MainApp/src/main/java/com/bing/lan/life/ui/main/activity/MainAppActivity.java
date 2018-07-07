package com.bing.lan.life.ui.main.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bing.lan.comm.view.MyToolbar;
import com.bing.lan.comm.view.NoScrollViewPager;
import com.bing.lan.life.R;
import com.bing.lan.mainLib.base.MainLibActivity;
import com.bing.lan.mainLib.base.MainLibFragment;
import com.bing.lan.mainLib.comm.service.UserService;
import com.luojilab.component.componentlib.router.Router;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author 蓝兵
 */
public class MainAppActivity extends MainLibActivity<IMainAppContract.IMainAppPresenter>
        implements IMainAppContract.IMainAppView, NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar)
    MyToolbar mToolbar;
    @BindView(R.id.view_pager_market)
    NoScrollViewPager mViewPager;
    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;

    private List<Fragment> fragments = new ArrayList<>();
    private List<String> titles = new ArrayList<>();

    private int[] icon = new int[]{
            R.drawable.tab_btn_home_selector,
            R.drawable.tab_btn_invest_selector,
            R.drawable.tab_btn_discover_selector,
            R.drawable.tab_btn_user_selector
    };

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main_app;
    }

    @Override
    protected IMainAppContract.IMainAppPresenter initPresenter() {
        MainAppPresenter presenter = new MainAppPresenter();
        presenter.setModule(new MainAppModule());
        presenter.onAttachView(this);
        return presenter;
    }

    @Override
    protected void initViewAndData(Intent intent) {
        setToolBar(mToolbar, "美妙生活  ", false, 0);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        initFragment();
    }

    @Override
    protected void readyStartPresenter() {

    }

    private void initFragment() {
        Router router = Router.getInstance();

        if (router.getService(UserService.class.getSimpleName()) != null) {
            UserService service = (UserService) router.getService(UserService.class.getSimpleName());
            MainLibFragment fragment = service.getGroupFragment();
            if (fragment != null) {
                fragments.add(fragment);
                titles.add(fragment.getTitle());
            }
            MainLibFragment fragment1 = service.getGroupFragment();
            if (fragment1 != null) {
                fragments.add(fragment1);
                titles.add(fragment1.getTitle());
            }
            MainLibFragment fragment2 = service.getGroupFragment();
            if (fragment2 != null) {
                fragments.add(fragment2);
                titles.add(fragment2.getTitle());
            }
        }

        mViewPager.setScanScroll(true);
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titles.get(position);
            }
        });
        mTabLayout.setupWithViewPager(mViewPager);

        // 设置图标 方式一
        //for (int i = 0; i < mTabLayout.getTabCount(); i++) {
        //    TabLayout.Tab tab = mTabLayout.getTabAt(i);
        //    tab.setIcon(icon[i]);//不能控制布局高度等
        //}

        // 设置图标  方式二
        for (int i = 0; i < mTabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = mTabLayout.getTabAt(i);
            tab.setCustomView(getTabLayoutChildView(i));
        }

        // 设置图标  方式三 不能加  mTabLayout.setupWithViewPager(mViewPager); 并且需要自己定义事件
        //for (int i = 0; i < fragments.size(); i++) {
        //    TabLayout.Tab tab = mTabLayout.newTab();
        //    mTabLayout.addTab(tab);
        //    tab.setCustomView(getTabLayoutChildView(i));
        //}
    }

    public View getTabLayoutChildView(int index) {
        LinearLayout inflate = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.item_tab, null);
        ImageView imageView = inflate.findViewById(R.id.iv_icon);
        TextView item = inflate.findViewById(R.id.tv_item);

        imageView.setImageResource(icon[index]);
        item.setText(titles.get(index));

        return inflate;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    //@Override
    //public void onBackPressed() {
    //    if (AppUtil.hitClick(2000, 2)) {
    //        super.onBackPressed();//正真退出
    //    } else {
    //        showToast("再按一次退出程序");
    //    }
    //}

    /* 启动activity时 进行权限请求 的开关 */
    @Override
    protected boolean isCheckPermissions() {
        return true;
    }

    /* 返回权限数组资源id */
    @Override
    protected int getPermissionArrId() {
        return R.array.basic_runtime_permissions;
    }
}
