/*
package adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import lims.aeml.bws.helthcare_ver_10.R;

*/
/**
 * Created by BWS on 10/07/2018.
 *//*


public class WearableAdapter extends RecyclerView.Adapter<WearableAdapter.ViewHolder> {
    private List<We> list;

    public WearableAdapter(List<CalenderModel> list) {
        this.list = list;
    }

    @Override
    public WearableAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_wearable, parent, false);
        return new WearableAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(WearableAdapter.ViewHolder holder, int position) {
        if (position % 2 == 1) {
            holder.itemView.setBackgroundColor(Color.parseColor("#999999"));
        } else {
            holder.itemView.setBackgroundColor(Color.parseColor("#004f92"));
        }
        CalenderModel myList = list.get(position);
        holder.textStartDate.setText(myList.getStartDate());
        holder.textCompanyName.setText(myList.getCompanyName());
        holder.textServiceName.setText(myList.getServiceName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textStartDate;
        public TextView textCompanyName;
        public TextView textServiceName;

        public ViewHolder(View itemView) {
            super(itemView);
            textStartDate = (TextView) itemView.findViewById(R.id.textStartDate);
            textCompanyName = (TextView) itemView.findViewById(R.id.textCompanyName);
            textServiceName = (TextView) itemView.findViewById(R.id.textServiceName);

        }
    }
}*/
