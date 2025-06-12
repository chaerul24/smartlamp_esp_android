package chaerul.biz.id.smartlamp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import chaerul.biz.id.smartlamp.R;
import chaerul.biz.id.smartlamp.adapter.MenuAdapter;
import chaerul.biz.id.smartlamp.model.ModelMenu;

public class HomeFragment extends Fragment {
    private View view;
    private ArrayList<ModelMenu> arrayList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_home, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        recyclerView.setLayoutManager(gridLayoutManager);
        arrayList = new ArrayList<ModelMenu>();
        arrayList.add(new ModelMenu("Manual", R.drawable.ic_lamp));
        arrayList.add(new ModelMenu("Atur Waktu", R.drawable.ic_clock));
        arrayList.add(new ModelMenu("Upgrade Vip", R.drawable.ic_vip));
        arrayList.add(new ModelMenu("Dokumentasi", R.drawable.ic_document));
        arrayList.add(new ModelMenu("Layanan CS", R.drawable.ic_cs));
        arrayList.add(new ModelMenu("Tentang", R.drawable.ic_about));

        MenuAdapter adapter = new MenuAdapter(getContext(), arrayList);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
