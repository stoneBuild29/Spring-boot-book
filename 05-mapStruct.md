# mapStruct

![Untitled](https://raw.githubusercontent.com/wenjinglee1104/blog_file/master/mapStruct.png)

### 1. `@Mapper(componentModel = "spring", uses = {NotificationConvertHelper.class})`

- **`@Mapper` 注解**：MapStruct 用来标记接口为映射器（Mapper），告诉 MapStruct 生成接口的实现类，负责对象之间的转换。
- **`componentModel = "spring"`**：这个属性告诉 MapStruct 生成的实现类应作为 Spring 的一个 Bean 来管理。这意味着你可以使用 Spring 的依赖注入（如 `@Autowired`）来获取这个 Mapper 的实现类。
- **`uses = {NotificationConvertHelper.class}`**：`uses` 属性指定了一个或多个辅助类，这些辅助类可以包含在映射过程中使用的自定义方法。在这个例子中，`NotificationConvertHelper` 被用作辅助类，可以提供一些辅助方法来简化映射逻辑。

2.

**`p2v(NotificationDO bean)`**：

- 使用 `@Mapping` 注解定义了字段的映射逻辑。
- `expression` 属性允许你使用 Java 表达式来进行复杂的映射。比如：这行代码指定将 `bean.getNotificationType()` 的值通过 `NotificationType.getValueByKey` 方法转换为目标对象的 `notificationTypeDisplay` 字段。
    
    ```java
    java复制代码
    @Mapping(target = "notificationTypeDisplay", expression = "java(com.ajjtcx.jtwallet.module.mall.enums.NotificationConstants.NotificationType.getValueByKey(bean.getNotificationType()))")
    
    ```
    

**`p2v(List<NotificationDO> pageResult)` 和 `p2v(PageResult<NotificationDO> pageResult)`**：

- 这些方法用于将集合类型或分页结果的集合转换为目标类型。这些方法可以重用单个对象的映射逻辑，从而简化批量转换。

3.

### `NotificationConvertHelper`

- **`@Component` 和 `@Named("NotificationConvertHelper")`**：
    - `@Component` 将 `NotificationConvertHelper` 注册为一个 Spring Bean，使其能够被注入到其他 Spring 管理的 Bean 中。
    - `@Named("NotificationConvertHelper")` 这是 Java CDI（Contexts and Dependency Injection）中的注解，类似于 `@Component`，可以提供一个名称来标识 Bean。这个在 Spring 中通常不常用，更多是用于其他依赖注入框架，不过在某些场景下也可能用于区分不同的 Bean 实例。
- **`extends BaseConvertHelperForMall`**：
    - `NotificationConvertHelper` 继承自 `BaseConvertHelperForMall`，意味着它可能继承了一些通用的转换辅助方法，特定于项目的业务逻辑。

(常常一起出现的两个注解 name component

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    // Bean 实现
}

public class MyConsumer {

    @Autowired
    @Qualifier("myService")
    private MyService myService;

    // 使用 myService
}

```

)