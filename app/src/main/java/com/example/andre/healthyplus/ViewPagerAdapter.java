package com.example.andre.healthyplus;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {


    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
      /*  InicioFragment demoFragment = new InicioFragment();
        position = position+1;
        Bundle bundle = new Bundle();
        bundle.putString("message", "Fragment: "+position);
        demoFragment.setArguments(bundle);
        return demoFragment;*/
        switch (position){
            case 0:
                InicioFragment inicioFragment = new InicioFragment();
                return inicioFragment;
            case 1:
                ForoFragment foroFragment = new ForoFragment();
                return foroFragment;
            case 2:
                PerfilFragment perfilFragment = new PerfilFragment();
                return perfilFragment;

        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Inicio";
            case 1:
                return "Foro";
            case 2:
                return "Perfil";
        }
        return null;
    }
}
