# @Validated

### 什么是 `@Validated`?

`@Validated` 是 Spring 框架中的一个注解，用于启动 **方法参数** 或 **类** 的校验功能。它通常与 Java 的 Bean Validation（例如 Hibernate Validator）一起使用，用来验证传递给方法或对象的参数是否符合预期的规则。

### 示例场景

假设你有一个用户注册的功能，在用户提交注册信息时，你希望确保用户输入的数据是有效的，例如用户名不能为空，密码的长度必须在一定范围内。

### 1. 定义一个实体类

首先，你定义一个 `User` 类，包含用户名和密码，并使用一些校验注解（如 `@NotNull`, `@Size` 等）来定义字段的校验规则。

```java
java复制代码
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

    @NotNull(message = "Username cannot be null")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
    private String username;

    @NotNull(message = "Password cannot be null")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    // Getters and setters
}

```

### 2. 使用 `@Validated` 进行方法参数校验

在控制器（Controller）或服务（Service）中，你可以使用 `@Validated` 注解来启用校验功能。Spring 会自动验证传递给方法的 `User` 对象，如果对象中的数据不符合校验规则，就会抛出异常。

```java
java复制代码
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
public class UserController {

    @PostMapping("/register")
    public String registerUser(@Validated @RequestBody User user) {
        // 如果 User 对象中的字段不符合校验规则，将抛出异常
        return "User registered successfully";
    }
}

```

1. **类级别的校验**
当@Validated注解写在类上时，意味着这个类中的所有方法都将被自动检查传入参数的有效性。通常用于服务层的实现类或其他业务逻辑类。

```java
import org.springframework.validation.annotation.Validated;
import org.springframework.stereotype.Service;

@Service
@Validated
public class UserServiceImpl implements UserService {

    @Override
    public void registerUser(User user) {
        // 业务逻辑
    }
}

```

将 `@Validated` 写在实现类上可以使整个类中的所有方法自动进行参数校验，这样可以确保在服务层或业务逻辑层上，所有输入的参数都是合法的，避免因数据不合法导致的逻辑错误。如果你只想对某些具体的实现类启用校验，这样的用法是非常合理的。