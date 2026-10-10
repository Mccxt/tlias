# 应用服务 WEB 访问端口
server.port=8080


#下面这些内容是为了让MyBatis映射
#指定Mybatis的Mapper文件
#mybatis.mapper-locations=classpath:mappers/*xml

#指定Mybatis的实体目录
#mybatis.type-aliases-package=com.itheima.tliaswebmanagement.mybatis.entity

#数据库连接
#spring.datasource.url=jdbc:mysql://localhost:3306/tlias
#spring.datasource.username=root
#spring.datasource.password=miao123456

# 单个文件最大上传大小
#spring.servlet.multipart.max-file-size=10MB
# 整个请求最大上传大小（一次请求可传多个文件）
#spring.servlet.multipart.max-request-size=100MB

#开启mybatis的日志输出
#mybatis.configuration.log-impl=org.apache.ibatis.logging.stdout.StdOutImpl
#开启数据库表字段 到 实体类属性的驼峰映射
#mybatis.configuration.map-underscore-to-camel-case=true

# 阿里云 OSS配置
#aliyun.oss.endpoint=https://oss-cn-beijing.aliyuncs.com
#aliyun.oss.bucket-name=mcc-web-tlias
#aliyun.oss.access-key-id=${OSS_ACCESS_KEY_ID}
#aliyun.oss.access-key-secret=${OSS_ACCESS_KEY_SECRET}
