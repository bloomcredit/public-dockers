# The runatlantis/atlantis-base is created by docker-base/Dockerfile.
FROM runatlantis/atlantis:v0.17.3


ENV ATLANTIS_VERSION=0.17.3
ENV TERRAGRUNT_VERSION=0.34.1

ENV KUBECTL_VERSION=v1.21.0

RUN curl -LO https://storage.googleapis.com/kubernetes-release/release/$KUBECTL_VERSION/bin/linux/amd64/kubectl \
    && chmod +x ./kubectl \
    && mv ./kubectl /usr/local/bin/kubectl

RUN curl -LO "https://github.com/gruntwork-io/terragrunt/releases/download/v$TERRAGRUNT_VERSION/terragrunt_linux_amd64" \
    && chmod +x ./terragrunt_linux_amd64 \
    && mv ./terragrunt_linux_amd64 /usr/local/bin/terragrunt

RUN apk --no-cache add aws-cli

RUN chmod +x /usr/local/bin/terragrunt
