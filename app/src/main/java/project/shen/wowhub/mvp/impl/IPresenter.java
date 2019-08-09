package project.shen.wowhub.mvp.impl;

import org.jetbrains.annotations.NotNull;
import project.shen.wowhub.mvp.ILifycycle;

public interface IPresenter<V extends IMvpViews> extends ILifycycle {
    @NotNull
    V getView();
}

