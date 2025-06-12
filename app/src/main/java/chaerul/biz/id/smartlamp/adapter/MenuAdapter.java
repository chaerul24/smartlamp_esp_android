package chaerul.biz.id.smartlamp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import chaerul.biz.id.smartlamp.R;
import chaerul.biz.id.smartlamp.model.ModelMenu;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    Context context;
    ArrayList<ModelMenu> arrayList;
    OnclickListener listener;

    public MenuAdapter(Context context, ArrayList<ModelMenu> arrayList) {
        this.arrayList = arrayList;
        this.context=context;
    }

    public void setOnClicListener(OnclickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_gridhome, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ModelMenu data = arrayList.get(position);
        holder.icon.setImageResource(data.icon);
        holder.title.setText(data.title);
        holder.itemView.setOnClickListener(view -> {
            if (listener != null) {
                listener.OnClick(position, data);
            }
        });
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public interface OnclickListener  {
        void OnClick(int position, ModelMenu modelMenu);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView icon;
        TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.imgIcon);
            title = itemView.findViewById(R.id.textTitle);
        }
    }
}
