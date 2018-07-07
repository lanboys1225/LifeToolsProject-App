package com.bing.lan.user.ui.group;

import android.view.View;
import android.widget.TextView;

import com.bing.lan.comm.adapter.BaseRecyclerAdapter;
import com.bing.lan.comm.adapter.BaseViewHolder;
import com.bing.lan.mainLib.comm.bean.Groups;
import com.bing.lan.user.R;

/**
 * @author 蓝兵
 */
public class ShopListAdapter extends BaseRecyclerAdapter<Groups> {

    @Override
    public int getItemLayoutResId(int viewType) {
        return R.layout.item_shop_list;
    }

    @Override
    public BaseViewHolder createViewHolder(View itemView, int type) {
        return new Holder(itemView);
    }

    class Holder extends BaseViewHolder<Groups> {

        //@BindView(R.id.tv_name)
        TextView mTvName;

        public Holder(View itemView) {
            super(itemView);
            mTvName = itemView.findViewById(R.id.tv_name);
        }

        @Override
        public void fillData(Groups data, int position) {
            mTvName.setText(data.getGroupName());
        }
    }
}
