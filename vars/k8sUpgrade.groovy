def call(project, addr) {
    sh """helm upgrade \
        ${project} \
        helm/${project} -i \
        --tiller-namespace ${project}-build \
        --namespace ${project} \
        --set image.tag=${currentBuild.displayName} \
        --set ingress.host=${addr} \
        --set image.image=${image} \
        --set image.dbTag=3.3 \
        --reuse-values"""
}