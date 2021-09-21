# The runatlantis/atlantis-base is created by docker-base/Dockerfile.
FROM runatlantis/atlantis:v0.17.3

ENV ATLANTIS_VERSION=0.17.3
ENV TERRAGRUNT_VERSION=0.27.4
ENV KUBECTL_VERSION=v1.21.0

RUN curl -LO https://storage.googleapis.com/kubernetes-release/release/$KUBECTL_VERSION/bin/linux/amd64/kubectl \
    && chmod +x ./kubectl \
    && mv ./kubectl /usr/local/bin/kubectl

RUN curl -LO "https://github.com/gruntwork-io/terragrunt/releases/download/v$TERRAGRUNT_VERSION/terragrunt_linux_amd64" \
    && chmod +x ./terragrunt_linux_amd64 \
    && mv ./terragrunt_linux_amd64 /usr/local/bin/terragrunt

# https://github.com/aws/aws-cli/issues/4685
ENV GLIBC_VER=2.33-r0

RUN curl -sL https://alpine-pkgs.sgerrand.com/sgerrand.rsa.pub -o /etc/apk/keys/sgerrand.rsa.pub \
    && curl -sLO https://github.com/sgerrand/alpine-pkg-glibc/releases/download/${GLIBC_VER}/glibc-${GLIBC_VER}.apk \
    && curl -sLO https://github.com/sgerrand/alpine-pkg-glibc/releases/download/${GLIBC_VER}/glibc-bin-${GLIBC_VER}.apk \
    && curl -sL https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip -o awscliv2.zip \
    && apk add --update --no-cache util-linux openssl python3 glibc-${GLIBC_VER}.apk glibc-bin-${GLIBC_VER}.apk \
    && unzip awscliv2.zip && aws/install \
    && rm -rf awscliv2.zip aws glibc-${GLIBC_VER}.apk glibc-bin-${GLIBC_VER}.apk \
    /usr/local/aws-cli/v2/*/dist/aws_completer \
    /usr/local/aws-cli/v2/*/dist/awscli/data/ac.index \
    /usr/local/aws-cli/v2/*/dist/awscli/examples \
    /var/cache/apk/*

RUN chmod +x /usr/local/bin/terragrunt
