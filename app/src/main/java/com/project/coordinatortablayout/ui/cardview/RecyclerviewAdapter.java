package com.project.coordinatortablayout.ui.cardview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.coordinatortablayout.R;

import java.util.List;

/**
 * Created by meijing on 2017/2/19.
 */

public class RecyclerviewAdapter   extends RecyclerView.Adapter<CardViewRecylcerviewHolder> {

    private Context  mContext;
    private List<ImageInfor>  list;

    public RecyclerviewAdapter(Context mContext, List<ImageInfor> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public CardViewRecylcerviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View  view= LayoutInflater.from(mContext).inflate(R.layout.item_cardview_layout,null);
        return new CardViewRecylcerviewHolder(view);
    }

    @Override
    public void onBindViewHolder(CardViewRecylcerviewHolder holder, int position) {
        ImageInfor bean = list.get(position);
        holder.getTvName().setText(bean.getName());
        holder.getIviocn().setBackgroundResource(bean.getImageId());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class CardViewRecylcerviewHolder extends RecyclerView.ViewHolder{

    private TextView  tvName;
    private ImageView iviocn;

    public CardViewRecylcerviewHolder(View itemView) {
        super(itemView);
        iviocn = (ImageView) itemView.findViewById(R.id.picture);
        tvName = (TextView) itemView.findViewById(R.id.name);
    }

    public TextView getTvName() {
        return tvName;
    }

    public ImageView getIviocn() {
        return iviocn;
    }
}