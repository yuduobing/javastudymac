//git凭证ID
 def git_auth = "3a6c6b3e-c152-4d4a-914a-da783ea64228"
 //git的url地址
 def git_url = "https://github.com/yuduobing/javastudymac.git"
 //镜像的版本号
 def tag = "0.0.1-SNAPSHOT"
 node {
 stage('拉取代码') {
 echo 'Building....'
checkout([$class: 'GitSCM', branches: [[name: "*/${branch}"]], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: "${git_auth}", url: "${git_url}"]]])
  }
 stage('编译 安装公共实体bean')
 { sh "mvn clean install -Dmaven.test.skip=true" }
 stage('工程编译') {
 //定义项目名称+镜像的版本号,对镜像名称进行拼接
 def imageName = "${project_name}:${tag}"
  echo '镜像名'
  echo '${imageName}'
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
