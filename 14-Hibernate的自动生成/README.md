# Spring Boot Hibernate Demo

## 项目概述

本项目是一个简单的示例，展示了如何使用 **Spring Boot** 和 **Hibernate** 框架来管理数据库操作。我们通过 Java 实体类定义数据模型，Hibernate 会根据这些模型自动生成和更新数据库表。

## 主要功能

- **用户管理**: 通过 `User` 实体类进行用户信息的创建、读取、更新和删除（CRUD）操作。
- **Hibernate 自动 DDL**: 利用 Hibernate 的功能自动创建和更新数据库表结构。
- **数据验证**: 通过注解确保数据的完整性和有效性。

## Hibernate的自动生成

当运行Spring Boot应用程序时，Hibernate会根据实体类的注解自动生成SQL语句，以创建或更新数据库表结构。

## 项目结构
```plaintext
src
├── main
│   ├── java
│   │   └── com
│   │       └── stone
│   │           └── boot
│   │               └── stream
│   │                   └── User.java
│   └── resources
│       └── application.properties
└── test
```

## Project Structure

The following shows the folder structure of this project:

## 配置说明

在 `application.properties` 中设置以下属性以启用自动 DDL 生成：

```properties
spring.jpa.hibernate.ddl-auto=update

--常规配置
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.show-sql=true
```

## 参考文献

- [Spring Boot Official Documentation](https://spring.io/projects/spring-boot)
- [Hibernate ORM Documentation](https://hibernate.org/orm/documentation/)
- [Lombok Documentation](https://projectlombok.org/)

## 结果

本项目在运行时，hibernate工具会自动生成sql语句，在数据库中根据实体创建相关的字段。

![CleanShot 2024-10-29 at 21.02.11@2x](https://cdn.jsdelivr.net/gh/stoneBuild29/MyPictures@main/upload/CleanShot%202024-10-29%20at%2021.02.11%402x.png)

![CleanShot 2024-10-29 at 21.02.54@2x](https://cdn.jsdelivr.net/gh/stoneBuild29/MyPictures@main/upload/CleanShot%202024-10-29%20at%2021.02.54%402x.png)

## 许可证

本项目采用 MIT 许可证，详细信息请参阅 [LICENSE](LICENSE) 文件。
