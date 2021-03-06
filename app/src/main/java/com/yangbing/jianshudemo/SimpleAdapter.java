package com.yangbing.jianshudemo;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
public class SimpleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    static final int TYPE_IMG = 1;
    static final int TYPE_TXT = 2;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_IMG){
            return new ImageViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_img,parent,false));
        }
        return new TextViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_jianshu_lable,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0){
            return TYPE_IMG;
        }else {
            return TYPE_TXT;
        }
    }

    @Override
    public int getItemCount() {
        return 13;
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder{

        public ImageViewHolder(View itemView) {
            super(itemView);
        }
    }


    public static class TextViewHolder extends RecyclerView.ViewHolder{

        public TextViewHolder(View itemView) {
            super(itemView);
        }
    }

}
