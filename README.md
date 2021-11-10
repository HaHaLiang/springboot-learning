# 项目结构
`
web(api) ---> service(实现具体业务逻辑 impl) ----> dao(repository[直接操作数据库]),也是 pom.xml 中需要配置的依赖关系
`
### springboot 和 springcloud简介
- springBoot 构建应用，springCloud 实现分布式，进行流式数据计算、批处理

SpringBoot | yaml | 自动装配 | 集成 web 开发 | 集成 druid | 分布式开发(dubbo+zookeeper) | swagger 接口文档 | 任务调度 | springSecurity：shiro
---|---|---|---|---|---|---|---|---
SpringCloud |微服务 | restful | Eureka | Ribbon | Feign | Hystrix | zuul 路由相关 | springcloud config：git


### springBoot 的 pom.xml
1. 项目元数据信息：创建的时候输入的 project metadata 部分，也就是 maven 项目的基本元素，包括 groupid、artifactid、version、name、description等
2. parent：集成 spring-boot-starter-parent 的依赖管理，控制版本与打包等内容
3. dependencies：项目具体依赖，包含 spring-boot-starter-web 用于实现 http 接口，使用 springmvc 构建 web(包括 restful)，默认使用 tomcat；spring-boot-starter-test 用于编写单测
4. build：构建配置部分。默认使用了 spring-boot-maven-plugin，配合 spring-boot-starter-parent 皆可以把 springboot 应用打 jar 包

### 自动装配原理
> pom.xml 中

1. 核心依赖：```spring-boot-dependencie```：
pom.xml 的 parent 标签中，依赖父 pom1：spring-boot-starter-parent，再依赖spring-boot-dependencies；spring-boot-dependencies中配置了所有 springboot 依赖的 version，所以在写依赖的时候不需要指定版本
2. 启动器：```spring-boot-starter-*``` ，写需要启动的场景
- 比如spring-boot-starter-web 是导入 web 环境所有的依赖，所有的启动器都在 spring 官网 starter 模块中
3. 注解 ```SpringBootApplication```：springboot 程序主入口,标注这是一个 springboot 应用，启动类下所有的资源被导入。在每个 maven 包的META-INF下的spring.factories
- 结论：springboot 所有自动配置都是在启动的时候扫描并加载，spring.factories所有的配置类都在这里，但不一定ConditionalOnClass(条件)生效，需要在 pom 中导入对应的 starter，才会有对应的启动器，才可以自动装配生效=配置成功

#### 运行
- IDEA 运行启动 tomcat 服务
- ```java -jar xxx.jar``` ```nohup java -jar xxx.jar &```命令行启动/后台启动
#### JavaEE结构
> JavaEE体系结构包括四层，从上到下分别是应用层、Web层、业务层、持久层。Struts和SpringMVC是Web层的框架，Spring是业务层的框架，Hibernate和MyBatis是持久层的框架。


### spring 操纵数据库
1. pom 配置 mysql的包和 mybatis 或者 jpa 的包,在父pom 或者 repository pom 中都可
2. 在主程序入口的 resources 目录下 application.yml 文件中配置链接数据库的配置信息:`username,password,url,driver-class-name`
3. repository 层中建立 entity 类,对应数据库表的字段,右键 Generate 增加 get/set 方法
    - 实体类和字段需要增加注解
    ```
    @Entity               
    @Table(name = "titles")
    public class TitlesEntity {
       @Id
       @GeneratedValue
       具体字段...
   ```
4. repository 模块中建立 dao 接口类,添加注解`@Repository`并继承 JpaRepository,泛型传入TitlesEntity:`public interface TitlesDao extends JpaRepository<TitlesEntity, Long>`
5. service 层 pom.xml 增加对repository的依赖
6. service 层增加接口类,定义要对数据库执行操作的方法; 
    - 再增加 impl 类实现接口,实现类增加`@Service`注解, dao 对象增加`@Resource`
    - 实现接口定义的方法,操纵 dao 去实现 JpaRepository提供的方法,return 的内容通过Optional类判断空
    ``` $java
    public TitlesEntity findById(Long id) {
        Optional<TitlesEntity> userDOOptional = titlesDao.findById(id);
        if (userDOOptional.isPresent()) {
            return userDOOptional.get();
        }
        return null;
    ```
7. controller 层 new TitlesServiceImpl对象调用方法
8. 在程序主入口增加几个注解
``` java
@EnableJpaRepositories("com.example.repository") // 用于Srping JPA的代码配置
@EntityScan(basePackages = {"com.example.entity"}) //用来扫描和发现指定包及其子包中的Entity定义
@PropertySource("classpath:application.yaml") //配置路径
```