def call(project, domain, extraValues = "") {
    chartName = "${project}-${env.BUILD_NUMBER}-${env.BRANCH_NAME}"
    tagBeta = "${currentBuild.displayName}-${env.BRANCH_NAME}"
    addr = "${project}-${env.BUILD_NUMBER}-${env.BRANCH_NAME}.${domain}"
    sh """helm upgrade \
        ${chartName.toLowerCase()} \
        helm/${project} -i \
        --tiller-namespace ${project}-build \
        --set image.tag=${tagBeta} \
        --set image.image=${image} \
        --set image.dbTag=3.3 \
        --set ingress.host=${addr.toLowerCase()} \
        ${extraValues}"""
}