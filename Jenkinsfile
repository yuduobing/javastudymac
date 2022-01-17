//git凭证ID
 def git_auth = "65d16515-7646-4f50-a159-be61b7537d2e"
 //git的url地址
 def git_url = "https://github.com/yuduobing/javastudymac"
 //镜像的版本号
 def tag = "0.0.1-SNAPSHOT"
 node {
 stage('拉取代码') {
 echo 'Building....'

  }
 stage('编译 安装公共实体bean')
 { sh "mvn clean install -Dmaven.test.skip=true" }
 stage('工程编译') {
 //定义项目名称+镜像的版本号,对镜像名称进行拼接
 def imageName = "${project_name}:${tag}"
 // 编译打包开始
  sh "mvn clean package -Dmaven.test.skip=true dockerfile:build "
  //对镜像打上标签
  sh "docker tag ${imageName} ${imageName}" }stage('docker部署') {
//镜像名称
def imageName = "${project_name}:${tag}"
//删除原有容器
sh "docker rm -f ${project_name}"
// 创建一个容器映射的目标
sh "mkdir -p /opt/docker/${project_name}"
//容器加一层挂载目录
sh "docker run -di -v /opt/docker/${project_name}/opt:/opt --name ${project_name} -p ${host_port}:${container_port} ${imageName}" }stage('启动并监控日志') { sh "docker logs -f ${project_name}" } }