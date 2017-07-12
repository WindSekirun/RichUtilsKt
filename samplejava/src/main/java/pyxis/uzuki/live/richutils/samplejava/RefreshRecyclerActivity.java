package pyxis.uzuki.live.richutils.samplejava;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import pyxis.uzuki.live.richutilskt.utils.Utils;
import pyxis.uzuki.live.richutilskt.widget.RefreshRecyclerView;

/**
 * Created by winds on 2017-07-03.
 */

public class RefreshRecyclerActivity extends BaseActivity {
    @BindView(R.id.recyclerView) RefreshRecyclerView recyclerView;
    private ArrayList<String> itemSet = new ArrayList<>();
    private int finalLoaded = 0;
    private ListAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh_recycler);

        recyclerView.setOnRefreshListener(() -> {
            for (int i = finalLoaded; i < finalLoaded + 9; i++) {
                itemSet.add(String.valueOf(i));
            }

            finalLoaded += 9;
            adapter.notifyDataSetChanged();
            return Unit.INSTANCE;
        });

        adapter = new ListAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        for (int i = 0; i < 20; i++) {
            itemSet.add(String.valueOf(i));
        }

        adapter.notifyDataSetChanged();
    }

    private class ListAdapter extends RecyclerView.Adapter<ListHolder> {

        @Override
        public ListHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ListHolder(Utils.inflate(viewGroup.getContext(), R.layout.activity_refresh_recycler_item, viewGroup));
        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onBindViewHolder(ListHolder listHolder, int i) {
            listHolder.txtItem.setText("This is great code! -> " + i);
        }

        @Override
        public int getItemCount() {
            return itemSet.size();
        }
    }

    private class ListHolder extends RecyclerView.ViewHolder {
        private TextView txtItem;

        ListHolder(View itemView) {
            super(itemView);
            txtItem = (TextView) itemView.findViewById(R.id.txtItem);
        }
    }
}
