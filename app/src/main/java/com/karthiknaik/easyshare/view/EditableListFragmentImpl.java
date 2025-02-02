package com.karthiknaik.easyshare.view;

import android.net.Uri;

import androidx.recyclerview.widget.RecyclerView;

import com.karthiknaik.easyshare.fragment.EditableListFragment;
import com.karthiknaik.easyshare.model.Editable;
import com.karthiknaik.easyshare.widget.EditableListAdapterImpl;
import com.genonbeta.android.framework.app.ListFragmentImpl;
import com.genonbeta.android.framework.widget.PowerfulActionMode;

public interface EditableListFragmentImpl<T extends Editable> extends ListFragmentImpl<T>
{
    boolean applyViewingChanges(int gridSize);

    void changeGridViewSize(int gridSize);

    void changeOrderingCriteria(int id);

    void changeSortingCriteria(int id);

    EditableListAdapterImpl<T> getAdapterImpl();

    EditableListFragment.FilteringDelegate<T> getFilteringDelegate();

    void setFilteringDelegate(EditableListFragment.FilteringDelegate<T> delegate);

    RecyclerView getListView();

    int getOrderingCriteria();

    PowerfulActionMode.SelectorConnection<T> getSelectionConnection();

    EditableListFragment.SelectionCallback<T> getSelectionCallback();

    void setSelectionCallback(EditableListFragment.SelectionCallback<T> selectionCallback);

    int getSortingCriteria();

    String getUniqueSettingKey(String setting);

    boolean isRefreshLocked();

    boolean isRefreshRequested();

    boolean isSortingSupported();

    boolean loadIfRequested();

    boolean openUri(Uri uri);

    void setSelectorConnection(PowerfulActionMode.SelectorConnection<T> selectionConnection);
}
