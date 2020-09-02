# The runatlantis/atlantis-base is created by docker-base/Dockerfile.
FROM runatlantis/atlantis:v0.15.0

ENV ATLANTIS_VERSION=0.15.0
ENV TERRAGRUNT_VERSION=0.23.40

RUN apk add --update --no-cache python3 bash curl \
    && curl -O https://bootstrap.pypa.io/get-pip.py \
    && python3 get-pip.py \
    && pip install --upgrade awscli

RUN curl -LO https://storage.googleapis.com/kubernetes-release/release/`curl -s https://storage.googleapis.com/kubernetes-release/release/stable.txt`/bin/linux/amd64/kubectl \
    && chmod +x ./kubectl \
    && mv ./kubectl /usr/local/bin/kubectl

RUN curl -LO "https://github.com/gruntwork-io/terragrunt/releases/download/v$TERRAGRUNT_VERSION/terragrunt_linux_amd64" \
    && chmod +x ./terragrunt_linux_amd64 \
    && mv ./terragrunt_linux_amd64 /usr/local/bin/terragrunt

RUN chmod +x /usr/local/bin/terragrunt
