package bsd.draggerdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Map;

import javax.inject.Inject;

import bsd.draggerdemo.bean.User;
import bsd.draggerdemo.component.DaggerUserComponent;
import bsd.draggerdemo.component.UserComponent;
import bsd.draggerdemo.module.UserModule;
import dagger.Lazy;

/**
 * @Inject : 通常在需要依赖的地方使用这个注解。换句话说，你用它告诉Dagger这个类或者字段需要依赖注入。
 * 这样，Dagger就会构造一个这个类的实例并满足他们的依赖。
 * @Module: Modules类里面的方法专门提供依赖，所以我们定义一个类，用@Module注解，这样Dagger在构造
 * 类的实例的时候，就知道从哪里去找到需要的 依赖。modules的一个重要特征是它们设计为分区并组合在一起
 * （比如说，在我们的app中可以有多个组成在一起的modules）。
 * @Provide: 在modules中，我们定义的方法是用这个注解，以此来告诉Dagger我们想要构造对象并提供这些依赖。
 * @Component: Components从根本上来说就是一个注入器，也可以说是@Inject和@Module的桥梁，它的
 * 主要作用就是连接这两个部分。
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Lazy模式注入使用
     */
    @Inject
    Lazy<User> lazyUser;
    private User user;

    /**
     * 需要注入User对象
     */
    @Inject
    User user1;

    /**
     * 测试MapKey
     */
    @Inject
    Map<String, String> map;

    private UserComponent userComponent;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.tv_dragger);

        /**
         * 完成对User对象的注入
         */
        userComponent = DaggerUserComponent.builder()
                .userModule(new UserModule(this))
                .build();
        userComponent.inject(this);

        /**
         * 根据注入的User对象设置TextView
         */
        //使用懒模式
        user = lazyUser.get();
        textView.setText(user.getName() + ":" + user.getAge());

        /* //测试module提供参数
        Log.i("============", "=========" + userComponent.getContext());*/

        /*//测试User单利
        Log.i("============", "=========" + user);
        Log.i("============", "=========" + user1);*/

        /*//测试MapKey
        Log.i("============", "=================" + map.toString());*/
    }
}
