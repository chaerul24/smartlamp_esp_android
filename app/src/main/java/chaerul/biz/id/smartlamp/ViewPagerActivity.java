package chaerul.biz.id.smartlamp;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.nafis.bottomnavigation.NafisBottomNavigation;

import chaerul.biz.id.smartlamp.fragment.HomeFragment;
import chaerul.biz.id.smartlamp.fragment.MonitorFragment;
import chaerul.biz.id.smartlamp.fragment.ProfileFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class ViewPagerActivity extends AppCompatActivity {
    private NafisBottomNavigation bottomNavigation;
    private int ID_HOME = 1;
    private int ID_MONITOR = 2;
    private int ID_PROFILE = 3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);

        bottomNavigation = findViewById(R.id.bottomNavifs);
        bottomNavigation.add(new NafisBottomNavigation.Model(ID_HOME, R.drawable.ic_home));
        bottomNavigation.add(new NafisBottomNavigation.Model(ID_MONITOR, R.drawable.ic_monitor));
        bottomNavigation.add(new NafisBottomNavigation.Model(ID_PROFILE, R.drawable.ic_user));

        replaceFrame(ID_HOME);
        bottomNavigation.show(ID_HOME, true);
        bottomNavigation.setOnShowListener(new Function1<NafisBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(NafisBottomNavigation.Model model) {
                return null;
            }
        });

        bottomNavigation.setOnClickMenuListener(new Function1<NafisBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(NafisBottomNavigation.Model model) {
                if(model.getId() == ID_HOME) {
                    replaceFrame(ID_HOME);
                }else if(model.getId() == ID_MONITOR) {
                    replaceFrame(ID_MONITOR);
                }else if(model.getId() == ID_PROFILE) {
                    replaceFrame(ID_PROFILE);
                }
                return null;
            }
        });
    }

    private void replaceFrame(int id) {
        if(id == ID_HOME) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new HomeFragment()).commit();
        } else if(id == ID_MONITOR) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new MonitorFragment()).commit();
        }else if(id == ID_PROFILE) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new ProfileFragment()).commit();
        }else{
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new HomeFragment()).commit();
        }
    }
}
