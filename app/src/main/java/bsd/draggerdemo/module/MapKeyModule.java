package bsd.draggerdemo.module;

import dagger.MapKey;
import dagger.Module;
import dagger.Provides;

/**
 * Created by ShiDa.Bian on 2017/2/10.
 * 测试@MapKey的使用,@MapKey注解目前只提供两种类型 - String和Enum。
 * <p>
 * key1,key2 作为key
 */

@Module
public class MapKeyModule {
    @MapKey(unwrapValue = true)
    @interface TestKey {
        /**
         * 这里申明的是变量名为value
         */
        String value();
    }

    /**
     * 这里的key1对应的是申明的变量value的值，因为就一个变量，可以省略value="key1"
     */
    @Provides(type = Provides.Type.MAP)
    @TestKey("key1")
    String provideFooKey() {
        return "key1 value";
    }

    @Provides(type = Provides.Type.MAP)
    @TestKey("key2")
    String provideBarKey() {
        return "key2 value";
    }
}
