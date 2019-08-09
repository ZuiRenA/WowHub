package project.shen.wowhub.mvp.impl;

import org.jetbrains.annotations.NotNull;
import project.shen.wowhub.mvp.ILifycycle;

public interface IMvpViews<P extends IPresenter> extends ILifycycle {
    @NotNull
    P getPresenter();
}
