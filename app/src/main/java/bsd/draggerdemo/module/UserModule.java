package bsd.draggerdemo.module;

import android.content.Context;
import android.util.Log;

import javax.inject.Singleton;

import bsd.draggerdemo.bean.User;
import dagger.Module;
import dagger.Provides;

/**
 * Created by ShiDa.Bian on 2017/2/9.
 * 提供依赖类
 * 这里的@Singleton不能用在类上，应该用在方法上
 */

//标识该类提供依赖
@Module
public class UserModule {
    private Context context;

    /**
     * 告诉Dagger我们想要构造对象并提供这些依赖
     * 这里是让User以单利形式出现
     */
    @Singleton
    @Provides
    public User provideUser() {
        return new User("XXXXXX", 11);
    }

    /**
     * 用于传递context进来，手动new出来就行
     *
     * @param context
     */
    public UserModule(Context context) {
        this.context = context;
    }

    /**
     * 提供给Component的Context
     */
    @Provides
    public Context provideUserContext() {
        Log.i("=============", "provideContext");
        return context;
    }
}