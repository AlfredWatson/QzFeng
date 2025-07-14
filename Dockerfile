# 基础镜像
FROM openjdk:17.0.2-slim
# 设定时区
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
# 创建应用目录
RUN mkdir -p /app
# 拷贝jar包
#COPY QzFeng-0.0.1-SNAPSHOT.jar /app/app.jar
# 创建应用目录和上传目录
RUN mkdir -p /app \
    && mkdir -p /data/uploads
# 入口
ENTRYPOINT ["java", "-jar", "/app/app.jar"]