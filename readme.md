本教程基于JDBC操纵数据库的一个简单Maven项目。
未涉及到Hibernate、SpringBoot、SpringMVC、SpringJPA等内容。

使用环境如下：
PostgreSQL：12
JetBrains IDEA：2020.1
Java：1.8
PostgreSQL驱动版本：42.2.14

#执行顺序：
##连接数据库：
com\db\tutorial\pg\PgJdbcConn.java
##创建表：
com\db\tutorial\pg\PgJdbcCreateTable.java
##添加数据：
com\db\tutorial\pg\PgJdbcAddData.java
##查询数据
com\db\tutorial\pg\PgJdbcSelectData.java
##更新数据
com\db\tutorial\pg\PgJdbcUpdateData.java
##删除数据
com\db\tutorial\pg\PgJdbcDeleteData.java

以上仅仅涉及到了PG基本的CRUD功能，未涉及到存储过程等的调用。

Good Luck！！！

ICEPLUMBLOSSOM AT 2020/07/14