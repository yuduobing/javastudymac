#FROM java:8 设置基础镜像
 FROM openjdk:8-jdk-alpine
 #指定镜像创建者信息
 MAINTAINER KsdPug
 #切换工作目录
  WORKDIR /
 #创建执行目录
 RUN mkdir -p /servers
 # 切换指定命令
 RUN cd /servers
 # 传递参数,微服务打包的jar包名字
  ARG JAR_FILE
   # 将指定的JAR_FILE拷贝到 /servers/app.jar 14
   COPY ${JAR_FILE} /servers/app.jar
    # 暴露指定的端口
    EXPOSE 8082
    # 执行发布命令
CMD ["nohup","java","-jar","/servers/app.jar","-- server.port=8082","&"]