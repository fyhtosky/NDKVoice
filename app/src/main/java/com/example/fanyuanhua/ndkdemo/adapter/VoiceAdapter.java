package com.example.fanyuanhua.ndkdemo.adapter;

import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.fanyuanhua.ndkdemo.R;
import com.example.fanyuanhua.ndkdemo.bean.VoiceBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VoiceAdapter extends RecyclerView.Adapter<VoiceAdapter.ViewHolder> {
    private Context mContext;
    private List<VoiceBean> mList ;
    private OnItemOnClick onItemOnClick;
    private SparseBooleanArray mSelectArray;

    public VoiceAdapter(Context mContext, List<VoiceBean> mList) {
        this.mContext = mContext;
        this.mList = mList;
        mSelectArray = new SparseBooleanArray();
        mSelectArray.put(0,true);
    }


    public void setmList(List<VoiceBean> mList) {
        if(mList.size()>0){
            mList.clear();
        }
        mList.addAll(mList);
        notifyDataSetChanged();
    }

    public void setOnItemOnClick(OnItemOnClick onItemOnClick) {
        this.onItemOnClick = onItemOnClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_grid_icon, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        VoiceBean beanList = mList.get(position);
        //设置显示图片
        holder.titleImage.setImageResource(beanList.getiId());
        if(mSelectArray.get(position)){
            holder.selectedImage.setVisibility(View.VISIBLE);
        }else {
            holder.selectedImage.setVisibility(View.GONE);
        }
        //设置标题
        holder.tv.setText(beanList.getiName());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public interface OnItemOnClick{

        void onClick(int position);
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView selectedImage;
        TextView tv;
        ImageView titleImage;
        RelativeLayout item;
        public ViewHolder(View convertView) {
            super(convertView);
            selectedImage =  convertView.findViewById(R.id.img_selected);
            tv =  convertView.findViewById(R.id.txt_icon);
            titleImage =  convertView.findViewById(R.id.img_icon);
            item=convertView.findViewById(R.id.item);
            item.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(null!=onItemOnClick){
                onItemOnClick.onClick(getAdapterPosition());
                mSelectArray.clear();
                mSelectArray.put(getAdapterPosition(),true);
                notifyDataSetChanged();

            }

        }

    }
}
