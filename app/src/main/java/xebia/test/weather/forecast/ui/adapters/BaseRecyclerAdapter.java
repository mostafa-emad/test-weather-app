package xebia.test.weather.forecast.ui.adapters;

import android.app.Activity;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

public class BaseRecyclerAdapter extends RecyclerView.Adapter{
    protected Activity activity;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    public int pxFromDp(final float dp) {
        return (int) (dp * activity.getResources().getDisplayMetrics().density);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

}
