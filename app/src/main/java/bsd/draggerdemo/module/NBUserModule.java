package bsd.draggerdemo.module;

import bsd.draggerdemo.bean.NBUser;
import dagger.Module;
import dagger.Provides;

/**
 * Created by ShiDa.Bian on 2017/2/9.
 */
@Module
public class NBUserModule {
    @Provides
    public NBUser provideNBUser() {
        return new NBUser("TTTTTTTT", 2222222);
    }
}
