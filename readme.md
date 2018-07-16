###本demo项目主要演示的功能包括：

1.freemarker 后台渲染html片段。
    典型的场景是：后台请求为ajax，返回json包含大量数据，js操作dom赋值非常繁琐。使用freemarker后台渲染好后返给前台，
避免大量dom操作，其实最主要时避免写大量繁琐的代码^_^。但缺点是后台和前端耦合度太高，无法做成通用接口,不过如果你一个人从前端写到后台，你想做的事恐怕只是加快工作效率，高耦合？只是浮云。。

2.springboot整合websocket

3.springboot,spring-session,redis整合
  使用了springboot自带的Lettuce操作redis
  
4.ip2region使用
  ip2region查找ip归属地,效率非常高


