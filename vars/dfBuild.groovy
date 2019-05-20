def call(String project) {
    sh "docker image build -t ammarqqqq/${project} ."
    sh "docker image build -t ammarqqqq/${project}-test -f Dockerfile.test ."
    sh "docker image build -t ammarqqqq/${project}-docs -f Dockerfile.docs ."
    sh "docker tag ammarqqqq/${project} ammarqqqq/${project}:${currentBuild.displayName}"
    sh "docker tag ammarqqqq/${project}-docs ammarqqqq/${project}-docs:${currentBuild.displayName}"
    sh "docker tag ammarqqqq/${project} ammarqqqq/${project}:beta"
    dockerLogin()
    sh "docker image push ammarqqqq/${project}:beta"
    sh "docker image push ammarqqqq/${project}-test"
    dockerLogout()
}