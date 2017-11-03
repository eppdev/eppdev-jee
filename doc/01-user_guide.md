# 使用说明
## 初始化
### git clone eppdev-jee
~~~ bash
git clone https://gitee.com/eppdev/eppdev-jee.git
~~~

### 修改eppdev-jee的后端数据库配置:
修改eppdev-jee/eppdev-code-generator/src/main/resource/application.properties中数据库配置：
~~~
#########################################
# DataBase Configurations
#########################################
spring.datasource.url=jdbc:mysql://localhost:3306/test
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.type=com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.datasource.continue-on-error=true
~~~

### 启动代码生成程序
~~~ bash
cd eppdev-jee
mvn install
cd eppdev-code-generator
mvn springboot:run
~~~

### 修改前端生成配置
访问[http://localhost:8080]，进入本地管理页面，配置工程所在目录、工程名称、基础包名、……，便于进行初始化



## 
