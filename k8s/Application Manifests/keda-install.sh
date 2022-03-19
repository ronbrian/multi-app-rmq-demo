#!/bin/bash

#MAKE SURE YOU HAVE HELM INSTALLED
helm repo add kedacore https://kedacore.github.io/charts
helm repo update
kubectl create namespace keda
helm install keda kedacore/keda --namespace keda