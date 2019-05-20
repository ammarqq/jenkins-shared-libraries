def call(image, sudo = false) {
    tagBeta = "${currentBuild.displayName}-${env.BRANCH_NAME}"
    prefix = ""
    if (sudo) {
        prefix = "sudo "
    }
    sh """${prefix}docker image build \
        -t ${image}:${tagBeta} ."""
    withCredentials([usernamePassword(
        credentialsId: "dockerhub",
        usernameVariable: "USER",
        passwordVariable: "PASS"
    )]) {
        sh """${prefix}docker login \
            -u $USER -p $PASS"""
    }
    sh """${prefix}docker image push \
        ${image}:${tagBeta}"""
}