package project.shen.wowhub.mvp.impl;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import project.shen.wowhub.mvp.util.ReflectUtil;

public abstract class BaseActivityJava<P extends BasePresenterJava> extends Activity implements IMvpViews<P> {
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
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        presenter.onCreate(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(@NotNull Bundle outState) {
        super.onSaveInstanceState(outState);
        presenter.onSaveInstanceState(outState);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        presenter.onConfigurationChanged(newConfig);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
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
    public void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter.onCreate(savedInstanceState);
    }
}
