def call(tag, sudo = false, extratags = []) {

    prefix = ""
    if (sudo) {
        prefix = "sudo "
    }

    withCredentials([usernamePassword(
            credentialsId: "dockerhub",
            usernameVariable: "USER",
            passwordVariable: "PASS"
    )]) {
        sh """${prefix}docker login \
            -u $USER -p $PASS"""
    }

    extratags.each { t ->
        sh """${prefix} docker tag ${image}:${tag} ${image}:${t}"""
        sh """${prefix} docker push ${image}:${t}"""
    }

}