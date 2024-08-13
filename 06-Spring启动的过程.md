# Spring启动的过程

在 Spring 容器启动时，Spring 会：

1. 扫描并注册 `UserService` 和 `UserRepository` Bean。
    - **组件扫描**：根据包路径扫描类，识别带有 `@Component`、`@Service`、`@Repository`、`@Controller` 等注解的类，并将它们注册为 Spring Bean。
    - **配置类**：扫描 `@Configuration` 注解的类，这些类通常包含 `@Bean` 注解的方法，用于定义 Bean。
    - *当你运行 `Application` 类的 `main` 方法时，Spring Boot 启动应用程序。Spring 容器会自动扫描 `UserService` 和 `UserRepository` 类，因为它们分别带有 `@Service` 和 `@Repository` 注解。这两个注解标记了这些类作为 Spring 管理的 Bean*。
2. 实例化 `UserService` 和 `UserRepository`。
- *Spring 容器会创建 `UserRepository` 和 `UserService` 的实例。在默认情况下，`@Service` 和 `@Repository` 注解的 Bean 会被创建为单例，这意味着每个 Bean 类只会创建一个实例。*
1. 将 `UserRepository` 实例**注入**到 `UserService` 的构造函数中。
- ***构造函数注入**：Spring 会识别 `UserService` 的构造函数，并看到它需要一个 `UserRepository` 实例。Spring 容器会注入 `UserRepository` 的实例到 `UserService` 的构造函数中。*
1. 处理 Bean 的**生命周期回调**（如 `@PostConstruct`、`@PreDestroy`）。
2. 调用 `BeanPostProcessor` 进行额外的处理。
3. 完成容器启动，应用程序可以开始处理请求。

这个流程确保了 Spring 容器能够正确管理 Bean 的生命周期和依赖关系，使得应用程序能够高效地运行。