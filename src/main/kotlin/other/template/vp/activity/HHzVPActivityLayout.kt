package other.template.vp.activity

import com.android.tools.idea.wizard.template.*

fun HhzVPActivityLayout() ="""<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <com.hzhu.m.widget.BetterSwipeRefreshLayout
        android:id="@+id/swipe_refresh"
        android:layout_width="0dp"
        android:layout_height="0dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent">


        <androidx.coordinatorlayout.widget.CoordinatorLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent">

            <com.google.android.material.appbar.AppBarLayout
                android:id="@+id/appBar"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                app:elevation="0dp">

                <com.google.android.material.appbar.CollapsingToolbarLayout
                    android:id="@+id/collapsing_toolbar"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    app:contentScrim="@color/white"
                    app:layout_scrollFlags="scroll|exitUntilCollapsed"
                    app:statusBarScrim="@color/main_blue_color">

                    <androidx.constraintlayout.widget.ConstraintLayout
                        android:id="@+id/tt_frame_bar_pic"
                        android:layout_width="match_parent"
                        android:layout_height="wrap_content"
                        app:layout_collapseMode="parallax"
                        app:layout_collapseParallaxMultiplier="0">

                        <androidx.appcompat.widget.AppCompatImageView
                            android:layout_width="match_parent"
                            android:layout_height="0dp"
                            android:scaleType="centerCrop"
                            app:layout_constraintDimensionRatio="375:182"
                            app:layout_constraintTop_toTopOf="parent"
                            app:srcCompat="@mipmap/bg_wiki_explore_head" />

                    </androidx.constraintlayout.widget.ConstraintLayout>

                    <androidx.appcompat.widget.Toolbar
                        android:id="@+id/toolbar"
                        android:layout_width="match_parent"
                        android:layout_height="wrap_content"
                        app:contentInsetRight="0dp"
                        app:contentInsetStart="0dp"
                        app:layout_collapseMode="pin"
                        app:popupTheme="@style/AppTheme.PopupOverlay">

                        <LinearLayout
                            android:layout_width="match_parent"
                            android:layout_height="wrap_content"
                            android:orientation="vertical">

                            <View
                                android:id="@+id/trans_view"
                                android:layout_width="wrap_content"
                                android:layout_height="0dp" />

                         <com.hzhu.m.widget.titlebar.TitleBar
                             android:id="@+id/title_bar"
                             android:layout_width="match_parent"
                             android:layout_height="wrap_content"/>
                        </LinearLayout>
                    </androidx.appcompat.widget.Toolbar>

                </com.google.android.material.appbar.CollapsingToolbarLayout>


                <com.hzhu.m.widget.xtablayout.XTabLayout
                    android:id="@+id/tabLayout"
                    android:layout_width="wrap_content"
                    android:layout_height="@dimen/dp44"
                    android:layout_marginTop="@dimen/dp2"
                    app:x_tabIndicatorAnimation="false"
                    app:x_tabIndicatorColor="@color/black"
                    app:x_tabIndicatorHeight="@dimen/dp3"
                    app:x_tabIndicatorWidth="@dimen/dp20"
                    app:x_tabMode="scrollable"
                    app:x_tabPaddingEnd="12dp"
                    app:x_tabPaddingStart="@dimen/dp12"
                    app:x_tabSelectedTextColor="@color/color_33"
                    app:x_tabSelectedTextSize="@dimen/dp16"
                    app:x_tabTextColor="@color/hint_color"
                    app:x_tabTextSize="@dimen/dp16" />

            </com.google.android.material.appbar.AppBarLayout>

            <androidx.viewpager2.widget.ViewPager2
                android:id="@+id/vp2"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                app:layout_behavior="@string/appbar_scrolling_view_behavior" />

        </androidx.coordinatorlayout.widget.CoordinatorLayout>
    </com.hzhu.m.widget.BetterSwipeRefreshLayout>


    <com.hzhu.m.widget.HHZLoadingView
        android:id="@+id/loadingView"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:layout_marginTop="@dimen/dp48"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout>"""