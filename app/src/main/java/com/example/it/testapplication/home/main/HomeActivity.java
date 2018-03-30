package com.example.it.testapplication.home.main;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.it.testapplication.R;
import com.example.it.testapplication.home.goods.GoodsFragment;
import com.example.it.testapplication.home.inventory.InventoryFragment;
import com.example.it.testapplication.home.order.OrderFragment;
import com.example.it.testapplication.home.setting.SettingFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.fl_fragment_container)
    FrameLayout flFragmentContainer;
    @BindView(R.id.rb_order)
    RadioButton rbOrder;
    @BindView(R.id.rb_goods)
    RadioButton rbGoods;
    @BindView(R.id.rb_inventory)
    RadioButton rbInventory;
    @BindView(R.id.rb_setting)
    RadioButton rbSetting;
    @BindView(R.id.rg_button_nav)
    RadioGroup rgButtonNav;

    /**
     * 订单Fragment
     */
    private final int FRAGMENT_ORDER = 0;
    /**
     * 盘点Fragment
     */
    private final int FRAGMENT_INVENTORY = 1;
    /**
     * 商品Fragment
     */
    private final int FRAGMENT_GOODS = 2;
    /**
     * 设置Fragment
     */
    public final int FRAGMENT_SETTING = 3;

    private FragmentManager fragmentManager = getSupportFragmentManager();  //fragment 管理器

    private Fragment mPreFragment; //之前的Fragment
    private SparseArray<Fragment> fragmentSparseArray = new SparseArray<>(); //fragment 列表

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        OrderFragment orderFragment = new OrderFragment();
        fragmentManager.beginTransaction().add(R.id.fl_fragment_container, orderFragment).commit();
        mPreFragment = orderFragment;
        fragmentSparseArray.put(FRAGMENT_ORDER, orderFragment);
        mButtonNavSetOnCheckedChangeListener();

    }

    /**
     * 单选按钮的点击事件
     */
    private void mButtonNavSetOnCheckedChangeListener() {
        rgButtonNav.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                changeButtonColor(checkedId);
                switch (checkedId) {
                    case R.id.rb_order:
                        changeFragment(createFragment(FRAGMENT_ORDER));
                        break;
                    case R.id.rb_goods:
                        changeFragment(createFragment(FRAGMENT_GOODS));
                        break;
                    case R.id.rb_inventory:
                        changeFragment(createFragment(FRAGMENT_INVENTORY));
                        break;
                    case R.id.rb_setting:
                        changeFragment(createFragment(FRAGMENT_SETTING));
                        break;
                }
            }
        });
    }

    /**
     * 切换Fragment方法
     *
     * @param fragment 被选中的Fragment
     */
    private void changeFragment(Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();    //开启事务
        transaction.hide(mPreFragment);          //隐藏上一个fragment
        if (fragment.isAdded()) {
            transaction.show(fragment);   //如果fragment已经被添加，则直接显示
        } else {
            transaction.add(R.id.fl_fragment_container, fragment);  //如果fragment未被添加，则添加
        }
        transaction.commit();      //提交事务
        mPreFragment = fragment;  //保存现在的fragment为上一个fragment
    }

    /**
     * 从集合中得到Fragment对象
     *
     * @param fragmentType fragment 类型
     * @return
     */
    public Fragment createFragment(int fragmentType) {
        Fragment fragment = fragmentSparseArray.get(fragmentType);       //从集合中取出需要的fragment
        if (fragment == null) {       //如果集合中还没有需要的fragment，则新建一个，并存入集合
            switch (fragmentType) {
                case FRAGMENT_ORDER:     //存入订单fragment
                    fragment = new OrderFragment();
                    fragmentSparseArray.put(FRAGMENT_ORDER, fragment);
                    break;
                case FRAGMENT_GOODS:    //存入商品fragment
                    fragment = new GoodsFragment();
                    fragmentSparseArray.put(FRAGMENT_GOODS, fragment);
                    break;
                case FRAGMENT_INVENTORY:  //存入盘点fragment
                    fragment = new InventoryFragment();
                    fragmentSparseArray.put(FRAGMENT_INVENTORY, fragment);
                    break;
                case FRAGMENT_SETTING:    //存入设置fragment
                    fragment = new SettingFragment();
                    fragmentSparseArray.put(FRAGMENT_SETTING, fragment);
                    break;
            }
        }
        return fragment;
    }

    /**
     * 更改按钮的原色
     *
     * @param id
     */

    private void changeButtonColor(int id) {
        RadioButton[] buttonArray = new RadioButton[]{rbOrder, rbGoods, rbInventory, rbSetting};
        for (RadioButton button : buttonArray) {
            if (button.getId() == id) {
                button.setTextColor(getResources().getColor(R.color.light_blue));
            } else {
                button.setTextColor(Color.BLACK);
            }
        }
    }
}
