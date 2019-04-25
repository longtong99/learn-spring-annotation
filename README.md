# learn-spring-annotation
想深入了解springboot就得先深入了解spring的注解，Go

`IOC`

向IOC容器中注册bean有4中方式：
1、@ComponentScan+@Component的衍生注解（@Controller,@Service,@Repository,Configuration）
这种扫描+注解方式一般都是注册的本地的类，@ComponentScan还可以通过@Filter制定扫描的方式
这种方式前面提了
2、在已经注册到IOC容器的类中中通过加了@Bean的注解的方法注册内容到IOC容器中，并且通过一些其他注解（@Conditional，@Lazy，@Scope）根据条件灵活判断是否注入，以及注入后是否懒加载、是否单例
这种也讲了
3、通过@Import注解注册bean，它有三种情况，一种直接写要注册的bean.class,一种是ImportSelector接口的实现类.class，一种是ImportBeanDefinitionRegistrar接口的实现类.class
4、通过实现FactoryBean接口，然后把这个实现类通过@Bean注解注册到容器中，然后容器中就会得到实现类的泛型，即要注册到容器中的bean
