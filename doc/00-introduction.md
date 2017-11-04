# 说明
## 平台说明

## 代码组织结构
### eppdev-utils

项目一些通用的工具类，包括：

* DateUtils: 日期相关工具，包括读取时间等
* JSONUtils: JSON相关的工具类，通过调用jackson接口，实现javabean与json的相关转换
* UUIDUtils: 用于生成UUID，主要是去除Java自动生成的UUID中的“-”
* TextFileUtils: 文本文件操作的工具类，包括文本读取、文本写入等

### eppdev-commons

项目的公共类，包括：
* BasicDao: DAO文件的基础方法，包含了以下基础方法：
  * insert
  * delete
  * update
  * get
  * listAll
  * listBy
  * listLike
  * listLeftLike
  * listRawLike
  * countAll
  * countBy
  * countLike
  * countLeftLike
  * countRawLike
> 注意：现在已经使用PagerHelper进行分页，故此所有的count方法已经设置为deprecated

* BasicService: Service的基础方法，具体包括：
  * get
  * delete
  * save
  * listAll
  * listBy
  * listLike
  * listLeftLike
  * listRawLike

