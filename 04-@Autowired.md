# @Autowired

### **`@Resource` 和 `@Autowired` 区别**

- **`@Resource`**：是 Java EE 和 Spring 中的注解，支持按名称或按类型进行依赖注入，主要用于注入外部资源（如数据库连接、JMS 连接等）。
- **`@Autowired`**：是 Spring 框架中的注解，支持按类型进行依赖注入。它也可以与 `@Qualifier` 注解结合使用来指定注入的 Bean。