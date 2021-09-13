package other.template.vp.activity

import com.android.tools.idea.wizard.template.*

fun HhzVPFragmentLayout() ="""<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/color_f5">

    <com.hzhu.m.widget.recyclerview.BetterRecyclerView
        android:id="@+id/rv"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:layout_behavior="@string/appbar_scrolling_view_behavior" />

    <com.hzhu.m.widget.HHZLoadingView
        android:id="@+id/loadingView"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />

</RelativeLayout>"""