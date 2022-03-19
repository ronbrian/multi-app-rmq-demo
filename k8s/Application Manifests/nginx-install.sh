#!/bin/bash

#MAKE SURE YOU HAVE HELM INSTALLED
helm repo add nginx-stable https://helm.nginx.com/stable
helm repo update
helm install nginx-stable/nginx-ingress --name my-release