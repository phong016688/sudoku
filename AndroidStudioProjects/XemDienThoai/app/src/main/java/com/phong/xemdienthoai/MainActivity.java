package com.phong.xemdienthoai;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        final ArrayList<DataShop> arrayList = new ArrayList<>();
        arrayList.add(new DataShop(R.drawable.iphone, "IPHONE"));
        arrayList.add(new DataShop(R.drawable.samsung, "SAMSUNG"));
        arrayList.add(new DataShop(R.drawable.htc, "HTC"));
        arrayList.add(new DataShop(R.drawable.wiko, "WIKO"));
        arrayList.add(new DataShop(R.drawable.oppo, "OPPO"));
        arrayList.add(new DataShop(R.drawable.huawei, "HUAWEI"));

        final ShopAdapter shopAdapter = new ShopAdapter(arrayList, getApplicationContext());
        recyclerView.setAdapter(shopAdapter);
    }

    class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ViewHolder> {
        ArrayList<DataShop> dataShops;
        Context context;

        public ShopAdapter(ArrayList<DataShop> dataShops, Context context) {
            this.dataShops = dataShops;
            this.context = context;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // dinh nghia view tong tra ve view.xml

            //LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            //View itemview = layoutInflater.inflate(R.layout.view_dienthoai,parent,false);

            // 2dong tren co the thay cho dong duoi
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_dienthoai, parent, false));
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            // dinh nghia phan nho trong view holder
            holder.txtname.setText(dataShops.get(position).getName());//hen thi chu
            holder.imgHinh.setImageResource(dataShops.get(position).getHinhanh());// hien thi hinh



        }

        @Override
        public int getItemCount() {
            return dataShops.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView txtname;
            ImageView imgHinh;

            public ViewHolder(View itemView) {
                super(itemView);
                txtname = itemView.findViewById(R.id.name);

                imgHinh = itemView.findViewById(R.id.hinh);
                itemView.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, dataShops.get(getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        }
    };


}
