package com.karthiknaik.easyshare.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import com.karthiknaik.easyshare.util.NetworkDeviceSelectedListener;
import com.karthiknaik.easyshare.R;
import com.karthiknaik.easyshare.model.NetworkDevice;
import com.karthiknaik.easyshare.service.CommunicationService;

public class CustomNetworkDeviceListFragment extends NetworkDeviceListFragment
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(false);
        setFilteringSupported(false);
        setUseDefaultPaddingDecoration(false);
        setUseDefaultPaddingDecorationSpaceForEdges(false);

        if (isScreenLarge())
            setDefaultViewingGridSize(4, 5);
        else if (isScreenNormal())
            setDefaultViewingGridSize(3, 4);
        else
            setDefaultViewingGridSize(2, 3);

        setDeviceSelectedListener(new NetworkDeviceSelectedListener()
        {
            @Override
            public boolean onNetworkDeviceSelected(NetworkDevice networkDevice, NetworkDevice.Connection connection)
            {
                if (getContext() != null) {
                    getContext().sendBroadcast(new Intent(CommunicationService.ACTION_DEVICE_ACQUAINTANCE)
                            .putExtra(CommunicationService.EXTRA_DEVICE_ID, networkDevice.deviceId)
                            .putExtra(CommunicationService.EXTRA_CONNECTION_ADAPTER_NAME, connection.adapterName));

                    return true;
                }

                return false;
            }

            @Override
            public boolean isListenerEffective()
            {
                return true;
            }
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        getListView().setNestedScrollingEnabled(true);
        setDividerVisible(false);

        if (getContext() != null) {
            float padding = getContext().getResources().getDimension(R.dimen.short_content_width_padding);

            getListView().setClipToPadding(false);
            getListView().setPadding((int) padding, 0, (int) padding, 0);
        }
    }
}
