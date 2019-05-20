def call(String project, String serviceName, String docsServiceName) {
    sh "docker service update --image ammarqqqq/${project}:${currentBuild.displayName} ${serviceName}"
    script {
        if (docsServiceName != "") {
            sh "docker service update --image ammarqqqq/${project}-docs:${currentBuild.displayName} ${docsServiceName}"
        }
    }
}