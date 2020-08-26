package com.karthiknaik.easyshare.view;

import com.karthiknaik.easyshare.fragment.EditableListFragment;
import com.karthiknaik.easyshare.widget.EditableListAdapter;

public interface EditableListFragmentModelImpl<V extends EditableListAdapter.EditableViewHolder>
{
    void setLayoutClickListener(EditableListFragment.LayoutClickListener<V> clickListener);
}
