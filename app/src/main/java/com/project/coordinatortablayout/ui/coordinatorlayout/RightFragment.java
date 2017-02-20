package com.project.coordinatortablayout.ui.coordinatorlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lnyp.recyclerview.EndlessRecyclerOnScrollListener;
import com.lnyp.recyclerview.HeaderAndFooterRecyclerViewAdapter;
import com.lnyp.recyclerview.RecyclerViewLoadingFooter;
import com.lnyp.recyclerview.RecyclerViewStateUtils;
import com.project.coordinatortablayout.R;
import com.project.coordinatortablayout.ui.coordinatorlayout.adapter.RecyclerViewAdapter;
import com.project.coordinatortablayout.ui.coordinatorlayout.model.WeChatModel;

import java.util.ArrayList;
import java.util.List;


public class RightFragment extends Fragment {

    private RecyclerView  mRecyclerView;
    private View view;
    private List<WeChatModel> mData=new ArrayList<>();
    private static final int PAGE_SIXE = 10;
    private RecyclerViewAdapter<RecyclerView.ViewHolder> weChatListAdapter;
    private HeaderAndFooterRecyclerViewAdapter recyclerViewAdapter;

    public static RightFragment newInstance() {
        RightFragment fragment=new RightFragment();
        return  fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_right, container, false);
        return   view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();

    }

    private void initView() {
        mRecyclerView= (RecyclerView) view.findViewById(R.id.rv_right);
        for (int i = 0; i <20 ; i++) {
            WeChatModel model=new  WeChatModel();
            model.setId(""+i);
            model.setFirstImg("http://zxpic.gtimg.com/infonew/0/wechat_pics_-214279.jpg");
            model.setMark("2222");
            model.setTitle("标题 集宁到乌兰花的班车出事了");
            model.setUrl("url : http://v.juhe.cn/weixin/redirect?wid=wechat_20150401071581");
            model.setSource("内蒙那点事儿");
            mData.add(model);
        }
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
        weChatListAdapter = new RecyclerViewAdapter<RecyclerView.ViewHolder>(getActivity(), mData, onClickListener);
        recyclerViewAdapter = new HeaderAndFooterRecyclerViewAdapter(weChatListAdapter);
        mRecyclerView.setAdapter(recyclerViewAdapter);
        mRecyclerView.addOnScrollListener(mOnScrollListener);

//        // 如果你要添加HeaderView，则必须使用HeaderAndFooterRecyclerViewAdapter
//        RecyclerViewUtils.setHeaderView(mRecyclerView, new SampleHeader(getActivity()));

    }
    private void updateData() {
        recyclerViewAdapter.notifyDataSetChanged();
        RecyclerViewStateUtils.setFooterViewState(mRecyclerView, RecyclerViewLoadingFooter.State.Normal);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                int pos = (int) v.getTag();
                Toast.makeText(getActivity(), "pos : " + pos, Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    private boolean hasMore=true;
    private EndlessRecyclerOnScrollListener mOnScrollListener = new EndlessRecyclerOnScrollListener() {
        @Override
        public void onLoadNextPage(View view) {
            super.onLoadNextPage(view);
            RecyclerViewLoadingFooter.State state = RecyclerViewStateUtils.getFooterViewState(mRecyclerView);

//            if (state == RecyclerViewLoadingFooter.State.Loading) {
//                Log.e("mmmm","the state is Loading, just wait..");
//                return;
//            }

            if (hasMore) {
                RecyclerViewStateUtils.setFooterViewState(getActivity(), mRecyclerView, PAGE_SIXE, RecyclerViewLoadingFooter.State.Loading, null);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                for (int i = 0; i < 20; i++) {
                                    WeChatModel model=new  WeChatModel();
                                    model.setId(""+i);
                                    model.setFirstImg("http://zxpic.gtimg.com/infonew/0/wechat_pics_-214279.jpg");
                                    model.setMark("2222");
                                    model.setTitle("标题 集宁到乌兰花的班车出事了");
                                    model.setUrl("url : http://v.juhe.cn/weixin/redirect?wid=wechat_20150401071581");
                                    model.setSource("内蒙那点事儿");
                                    mData.add(model);
                                }
                                updateData();
                            }
                        });

                    }
                }).start();

            } else {
                RecyclerViewStateUtils.setFooterViewState(getActivity(), mRecyclerView, PAGE_SIXE, RecyclerViewLoadingFooter.State.TheEnd, null);
            }
        }
    };
}




 
