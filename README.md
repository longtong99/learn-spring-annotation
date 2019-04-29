# learn-spring-annotation
想深入了解springboot就得先深入了解spring的注解，Go

`IOC`


    `bean初始化`

        向IOC容器中注册bean有4中方式：

        1、@ComponentScan+@Component的衍生注解（@Controller,@Service,@Repository,Configuration）
        这种扫描+注解方式一般都是注册的本地的类，@ComponentScan还可以通过@Filter制定扫描的方式
        这种方式前面提了

        2、在已经注册到IOC容器的类中中通过加了@Bean的注解的方法注册内容到IOC容器中，并且通过一些其他注解（@Conditional，@Lazy，@Scope）根据条件灵活判断是否注入，以及注入后是否懒加载、是否单例
        这种也讲了

        3、通过@Import注解注册bean，它有三种情况，一种直接写要注册的bean.class,一种是ImportSelector接口的实现类.class，一种是ImportBeanDefinitionRegistrar接口的实现类.class

        4、通过实现FactoryBean接口，然后把这个实现类通过@Bean注解注册到容器中，然后容器中就会得到实现类的泛型，即要注册到容器中的bean


     `bean的生命周期：`
     		bean创建---初始化----销毁的过程
     容器管理bean的生命周期；
     我们可以自定义初始化和销毁方法；容器在bean进行到当前生命周期的时候来调用我们自定义的初始化和销毁方法
     
     构造（对象创建）
     		单实例：在容器启动的时候创建对象
     		多实例：在每次获取的时候创建对象\
     
     BeanPostProcessor.postProcessBeforeInitialization
     初始化：
     		对象创建完成，并赋值好，调用初始化方法。。。
     BeanPostProcessor.postProcessAfterInitialization
     销毁：
     		单实例：容器关闭的时候
     		多实例：容器不会管理这个bean；容器不会调用销毁方法；
     
     
     遍历得到容器中所有的BeanPostProcessor；挨个执行beforeInitialization，
     一但返回null，跳出for循环，不会执行后面的BeanPostProcessor.postProcessorsBeforeInitialization
     
     BeanPostProcessor原理
     populateBean(beanName, mbd, instanceWrapper);给bean进行属性赋值
     initializeBean
     {
     applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
     invokeInitMethods(beanName, wrappedBean, mbd);执行自定义初始化
     applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
    }
     
     
     `自定义bean销毁方式`
     
     1）、指定初始化和销毁方法；
     		通过@Bean指定init-method和destroy-method；
     2）、通过让Bean实现InitializingBean（定义初始化逻辑），
     				DisposableBean（定义销毁逻辑）;
     3）、可以使用JSR250；
     		@PostConstruct：在bean创建完成并且属性赋值完成；来执行初始化方法
     		@PreDestroy：在容器销毁bean之前通知我们进行清理工作
     4）、BeanPostProcessor【interface】：bean的后置处理器；
     		在bean初始化前后进行一些处理工作；
     		postProcessBeforeInitialization:在初始化之前工作
     		postProcessAfterInitialization:在初始化之后工作
     
     Spring底层对 BeanPostProcessor 的使用；
     		bean赋值，注入其他组件，@Autowired，生命周期注解功能，@Async,xxx BeanPostProcessor;
    
    