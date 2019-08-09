package project.shen.wowhub.mvp.impl;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import project.shen.wowhub.mvp.IMvpView;

public class BasePresenterJava<V extends IMvpViews> implements IPresenter<V> {

    public V view;

    @NotNull
    @Override
    public V getView() {
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {}

    @Override
    public void onSaveInstanceState(@NotNull Bundle outState) {}

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {}

    @Override
    public void onConfigurationChanged(@Nullable Configuration newConfig) {}

    @Override
    public void onDestroy() {}

    @Override
    public void onStart() {}

    @Override
    public void onStop() {}

    @Override
    public void onResume() {}

    @Override
    public void onPause() {}

}
