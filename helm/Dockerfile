FROM alpine:3.11

ARG CHAMBER_VERSION=2.8.2
ARG KUBECTL_VERSION=1.14.6
ARG HELM_VERSION=3.2.4
ARG HELM_DIFF_VERSION=3.1.1
ARG HELM_SECRETS_VERSION=2.0.2
ARG HELMFILE_VERSION=0.114.0
ARG ISTIO_VERSION=1.7.3

ENV HELM_FILE_NAME helm-v${HELM_VERSION}-linux-amd64.tar.gz

LABEL version="${HELMFILE_VERSION}-${HELM_VERSION}-${KUBECTL_VERSION}"

WORKDIR /

RUN apk --update --no-cache add bash ca-certificates git gnupg curl gettext python3 jq && pip3 install gitpython~=2.1.11 requests~=2.22.0 PyYAML~=5.1.1 awscli

RUN curl -L https://istio.io/downloadIstio | ISTIO_VERSION=$ISTIO_VERSION TARGET_ARCH=x86_64 sh - \
   && mv istio-$ISTIO_VERSION/bin/istioctl /bin/istioctl 

ADD https://storage.googleapis.com/kubernetes-release/release/v${KUBECTL_VERSION}/bin/linux/amd64/kubectl /usr/local/bin/kubectl
RUN chmod +x /usr/local/bin/kubectl

ADD https://amazon-eks.s3-us-west-2.amazonaws.com/1.14.6/2019-08-22/bin/linux/amd64/aws-iam-authenticator /usr/local/bin/aws-iam-authenticator
RUN chmod +x /usr/local/bin/aws-iam-authenticator

ADD https://get.helm.sh/${HELM_FILE_NAME} /tmp
RUN tar -zxvf /tmp/${HELM_FILE_NAME} -C /tmp \
  && mv /tmp/linux-amd64/helm /bin/helm \
  && rm -rf /tmp/*

RUN helm plugin install https://github.com/databus23/helm-diff --version $HELM_DIFF_VERSION
RUN helm plugin install https://github.com/aslafy-z/helm-git.git --version master
RUN helm plugin install https://github.com/zendesk/helm-secrets --version $HELM_SECRETS_VERSION

ADD https://github.com/roboll/helmfile/releases/download/v${HELMFILE_VERSION}/helmfile_linux_amd64 /bin/helmfile
RUN chmod 0755 /bin/helmfile

RUN wget https://github.com//segmentio/chamber/releases/download/v${CHAMBER_VERSION}/chamber-v${CHAMBER_VERSION}-linux-amd64 -O /bin/chamber && \
  chmod +x /bin/chamber

RUN apk -Uuv add groff less python py-pip
RUN pip install awscli
