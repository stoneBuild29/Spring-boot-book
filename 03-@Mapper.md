# @Mapper

`@Mapper` 是 MyBatis 框架中的一个注解，用于标记一个接口为 MyBatis 的映射器（Mapper）。MyBatis 是一个持久层框架，它通过映射配置文件或注解，将 Java 对象与数据库中的记录进行映射。

### `@Mapper` 注解的作用

1. **标识 Mapper 接口**：
当你在一个接口上使用 `@Mapper` 注解时，MyBatis 会自动识别这个接口为 Mapper，并将其注册到 Spring 容器中。这样，Spring 就可以将 Mapper 作为一个 Spring Bean 来管理，并在需要的地方自动注入（通过 `@Autowired` 或构造函数注入）。
2. **简化配置**：
使用 `@Mapper` 注解可以减少配置文件的编写。在传统的 XML 配置方式中，你需要在 MyBatis 配置文件中手动注册每一个 Mapper 接口，而有了 `@Mapper` 注解后，这个过程变得自动化了。

### 示例

假设你有一个 `UserMapper` 接口，用来操作数据库中的用户数据。你可以这样定义它：

```java
java复制代码
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM users WHERE id = #{id}")
    User findUserById(Long id);
}

```

@Mapper 使用场景

- MyBatis 中的 Mapper 接口：你可以在所有的 MyBatis Mapper 接口上使用 @Mapper 注解，这些接口通常定义了与数据库表对应的增删改查方法。这个意思是基础的增删改查不用写了吗？
- `@Mapper` 注解的主要作用是告诉 MyBatis 这是一个 Mapper 接口，MyBatis 会为这个接口自动生成实现类，并将其作为一个 Spring Bean 来管理

3.

在某些项目中，开发者会使用 `@Mapper` 注解来标记自定义的转换器（`Converter`）接口。这些转换器通常用于将不同类型的对象相互转换，特别是在 DTO（数据传输对象）和实体对象之间的转换中。

虽然 `@Mapper` 注解主要是 MyBatis 提供的，用于数据库操作中的映射器接口，但在其他上下文中，它也可能被自定义的库或工具用来标记对象之间的转换接口。这种用法通常是在一些利用了 MapStruct 框架的项目中，`@Mapper` 注解被广泛用于标记对象转换接口。

### 在 `Convert` 接口中的用法

如果 `@Mapper` 注解用于 `Convert` 接口中，那么这个接口通常是专门用来处理对象转换逻辑的。`Convert` 接口可能用于：

1. **DTO 和实体类的转换**：当需要在服务层或控制器层传输数据时，通常需要在 DTO 和数据库实体类之间进行转换。
2. **不同对象模型之间的转换**：比如在多个外部系统之间进行数据交换时，不同系统可能有各自的数据模型，这时需要在这些模型之间进行转换。

### MapStruct 框架中的 `@Mapper`

如果你的项目使用了 MapStruct，那么 `@Mapper` 注解有以下作用：

- **自动生成实现类**：MapStruct 通过 `@Mapper` 注解自动生成实现类，这个实现类包含了定义在接口中的转换逻辑。你无需手动编写转换逻辑，MapStruct 会根据方法签名和字段名称自动生成代码。
- **配置自定义映射规则**：你可以在 `@Mapper` 注解上配置一些选项，如组件模型、映射的源和目标类型等。

### 示例

假设你有一个 `User` 实体和一个 `UserDTO` 数据传输对象，你可以定义一个 `UserConverter` 接口，用于在这两者之间进行转换。

```java
java复制代码
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserConverter {

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "name", target = "username")
    UserDTO toDTO(User user);

    @Mapping(source = "userId", target = "id")
    @Mapping(source = "username", target = "name")
    User toEntity(UserDTO userDTO);
}

```

当编译时，MapStruct 会自动生成 `UserConverterImpl` 类，其中包含了从 `User` 到 `UserDTO` 和从 `UserDTO` 到 `User` 的转换逻辑。

### 总结

- **`@Mapper` 注解**：在 MyBatis 中用于标记数据库操作的映射器接口，在 MapStruct 中用于标记对象转换接口。
- **`Convert` 接口**：通常用于在项目中定义对象之间的转换逻辑，特别是 DTO 和实体类之间的转换。
- **MapStruct**：使用 `@Mapper` 注解自动生成对象转换代码，减少手动编写转换逻辑的工作量。

如果你在项目中看到 `@Mapper` 用于 `Convert` 接口，很可能是为了利用 MapStruct 自动生成代码来简化对象之间的转换。