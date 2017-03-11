package com.channeloffdemo;


import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter{

	List<Fragment> fragmentList;
	public ViewPagerAdapter(FragmentManager fm) {
		super(fm);
	}
	public ViewPagerAdapter(FragmentManager fm,List<Fragment> listFragment) {
		super(fm);
		this.fragmentList=listFragment;
		
	}
	
	@Override
	public Fragment getItem(int arg0) {
		return fragmentList.get(arg0);
	}

	@Override
	public int getCount() {
		return fragmentList.size();
	}

}
