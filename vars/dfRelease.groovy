def call(String project, gox = false) {
    dockerLogin()
    sh "docker image push ammarqqqq/${project}:latest"
    sh "docker image push ammarqqqq/${project}:${currentBuild.displayName}"
    sh "docker image push ammarqqqq/${project}-docs:latest"
    sh "docker image push ammarqqqq/${project}-docs:${currentBuild.displayName}"
    dockerLogout()
}
