package project.shen.mvp


interface IPresenter<out View: IMvpView<IPresenter<View>>>:
    ILifycycle {
    val view: View
}

interface IMvpView<out Presenter: IPresenter<IMvpView<Presenter>>>:
    ILifycycle {
    val presenter: Presenter
}