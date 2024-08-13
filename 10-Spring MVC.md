# Spring MVC

![Untitled](https://raw.githubusercontent.com/wenjinglee1104/blog_file/master/Spring%20MVC.png)

1. Handler是用来做具体事情的，对应的是Controller里面的方法。所有有＠RequestMapping的方法都可以被看作一个Handler。
2. handler的重要性
- HandlerMapping是用来找到Handler的，是请求路径与Handler的映射关系。
- 根据请求找到Handler
- 根据Handler找到对应的HandlerAdapter，调用Controller进行后续业务逻辑处理。
- 用HandlerAdapter处理Handler，将ModelAndView返回给DispatcherServlet。
- 处理经过以上步骤的结果