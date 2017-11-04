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

### 环境初始化

* 访问[项目首页](http://localhost:8080)，进入基础配置页面（环境初始化->初始化配置），修改各个配置项：
  * WORK_SPACE_DIR：工程所在目录
  * PROJECT_NAME：工程名称
  * BASIC_PACKAGE_NAME：基础包名
  * AUTHOR_NAME：作者名称
  * AUTHOR_EMAIL：作者邮箱
* 初始化工程，点击工程初始化菜单（环境初始化->工程初始化），生成初始化文件（pom.xml, application.properties, Application.java）

### 库表结构管理
#### 手工配置
待补充
#### 读取数据库配置
通过管理页面，加载最新物理表（代码生成->加载最新物理表），将最新库表结果加载到数据库中。

### 代码生成
#### 生成Java工程中的代码
通过管理页面，生成最新的Java相关代码（代码生成->生成最新代码）

#### 生成SQL文件[仅限于正向生成]
待补充



