package project.shen.wowhub.mvp.impl;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import org.jetbrains.annotations.NotNull;
import project.shen.wowhub.mvp.util.ReflectUtil;

public abstract class BaseFragmentJava<P extends BasePresenterJava> extends Fragment implements IMvpViews<P> {
    public P presenter;

    {
        presenter = ReflectUtil.INSTANCE.createPresenter(this);
        presenter.view = this;
    }

    @NotNull
    @Override
    public P getPresenter() {
        return presenter;
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.onStop();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter.onCreate(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        presenter.onSaveInstanceState(outState);
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        presenter.onConfigurationChanged(newConfig);
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        presenter.onViewStateRestored(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}


