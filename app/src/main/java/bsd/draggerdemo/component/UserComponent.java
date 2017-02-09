package bsd.draggerdemo.component;

import android.content.Context;

import javax.inject.Singleton;

import bsd.draggerdemo.MainActivity;
import bsd.draggerdemo.module.NBUserModule;
import bsd.draggerdemo.module.UserModule;
import dagger.Component;

/**
 * Created by ShiDa.Bian on 2017/2/9.
 * Component 链接被注入的地方和提供依赖的地方
 * 这里提供一个桥梁的作用
 * 1.如果这里需要使用单利的话，就需要在module和component中同时设置@Singleton
 */
@Singleton
@Component(modules = {UserModule.class, NBUserModule.class})
public interface UserComponent {
    void inject(MainActivity activity);

    //这里获得的是UserModule提供的Context
    Context getContext();
}
