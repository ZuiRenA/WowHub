package project.shen.wowhub.mvp.util

import android.app.Activity
import android.support.v4.app.Fragment
import project.shen.wowhub.mvp.IPresenter
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import java.util.*

object ReflectUtil {
     fun <P> createPresenter(any: Any): P{
        sequence<Type> {
            var thisClass: Class<*> = any::class.java
            while (true) {
                yield(thisClass.genericSuperclass)
                thisClass = thisClass.superclass ?: break
            }
        }.filter {
            it is ParameterizedType
        }.flatMap {
            (it as ParameterizedType).actualTypeArguments.asSequence()
        }.first {
            it is Class<*> && IPresenter::class.java.isAssignableFrom(it)
        }.let {
            return (it as Class<P>).newInstance()
        }
    }
}