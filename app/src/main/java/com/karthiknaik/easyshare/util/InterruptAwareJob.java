package com.karthiknaik.easyshare.util;

import com.genonbeta.android.framework.util.Interrupter;

abstract public class InterruptAwareJob
{
    abstract protected void onRun();

    protected void run(Interrupter interrupter)
    {
        onRun();
        interrupter.removeClosers();
    }
}
