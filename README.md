

To run only build : mvn clean install

To build and push to docker : mvn clean install jlib:build

## Applying kubernates

Go to k8s 
- Apply config maps kubectl apply -f config-map.yaml
- Setting up mysql pod : kubectl apply -f mysql.yaml
- Set up zipkin : kubectl apply -f zipkin.yaml
- Access zipkin dashboard  http://localhost:9411 which was exposed using loadbalancer
- Set up service registry pod : kubectl apply -f service-registry-deployment.yaml
- Set up config server pod : kubectl apply -f config-service-deployment.yaml
- Set up cloud gateway pod : kubectl apply -f cloud-gateway-deployment.yaml
- Set up other microservices pod : kubectl apply -f payment-service-deployment.yaml/order-service-deployment.yaml/product-service-deployment.yaml

##  OKTA Configuration

First create new application in okta . Application type should be open id application.
Authroization server has configuration related to access token and refresh token validity.
Go to security -> API -> default audience to modify access policies and timing.
To get refresh token , we need to ensure we have grant type refresh token for application and also scope is 
offline_access provided when retriving tokens. Refer application yaml of cloud gateway.



TO GET RERESH TOKEN
{
"userId": "dineshnith22@gmail.com",
"accessToken": "eyJraWQiOiJkSTY4SHp6RUt6R1d1bWduQ2dnRHdQZkk2b2kwS1E3amlKTGdmdDN6aS1vIiwiYWxnIjoiUlMyNTYifQ.eyJ2ZXIiOjEsImp0aSI6IkFULmRtNDRTNUJ3a0p3Z2hFYncwNjRZZDAteXdQQ3I0VXNYY0N2VVZZOWpEdkUub2FyMWphNHhmeWdxOWVwdzI1ZDciLCJpc3MiOiJodHRwczovL2Rldi0wNzY1MTgxMy5va3RhLmNvbS9vYXV0aDIvZGVmYXVsdCIsImF1ZCI6ImFwaTovL2RlZmF1bHQiLCJpYXQiOjE3MDI5MDEyMzIsImV4cCI6MTcwMjkwNDgzMiwiY2lkIjoiMG9hZHl3bWluNW9MdWc1ZlU1ZDciLCJ1aWQiOiIwMHVkeXhmYTZncDRNWXAzZjVkNyIsInNjcCI6WyJvcGVuaWQiLCJlbWFpbCIsIm9mZmxpbmVfYWNjZXNzIiwicHJvZmlsZSJdLCJhdXRoX3RpbWUiOjE3MDI5MDEyMDAsInN1YiI6ImRpbmVzaG5pdGgyMkBnbWFpbC5jb20iLCJncm91cHMiOlsiRXZlcnlvbmUiLCJDdXN0b21lciIsIkFkbWluIl19.d1vcm4VEyxH6B0G8vAqc2_w6QNHKgF1setx57f_ncV14uotnft15mIMi9E-bz7gcXcqFmyyB07nJHsXZGMxCum6J6sVxDRKMdKg27YIVQA1GleKIXquykM7puZGtO-rJ_0vey0gOMJHF4IFBwo3Oa3VLwOw0DIIJPT98f0-2QtDv2hNaDIU9JdQtgh-TRE_Ugcp_n4SS8hP0n4Nqe4nhGTvLgUQp_wxMpn5EJqnX6bGGFO1fjCZ5tLhO3bPaCIJ0JoAZpnsGLx7cQ6Vt2RGWRJxyregxDSTOApgsHWQtziDcycxJSd7dOnvmbaqxatVkYR_Iz3bIBrjSJHD8gBigrw",
"refreshToken": "JYAKe5P0r1dhCMkcDeXrXnswXoar7rtTbYQC89SQj9g",
"expiresAt": 1702904828,
"authorityList": [
"ROLE_USER",
"SCOPE_email",
"SCOPE_offline_access",
"SCOPE_openid",
"SCOPE_profile"
]
}


curl --location 'https://dev-07651813.okta.com/oauth2/default/v1/token' \
--header 'Content-type: application/x-www-form-urlencoded' \
--header 'User-Agent: Mozilla/5.0 ($systemInformation) $platform ($platformDetails) $extensions' \
--header 'Cookie: JSESSIONID=4829EBE4DD1ACD6DC40C7F75376660DA' \
--data-urlencode 'client_id=0oadywmin5oLug5fU5d7' \
--data-urlencode 'client_secret=a3l7d_iJoZItGCHtnnXTyCbcdh1DcOnB-gOTA8th4G97Tl9tZPNaT81gYet4lgcG' \
--data-urlencode 'grant_type=client_credentials' \
--data-urlencode 'scope=internal'






PS C:\Users\dinkumar15> docker run -d -p 9411:9411 openzipkin/zipkin
23c7572a1fd8263f0172a8686743c9193d0b6ead8f06e1204fa8022982f4746b
PS C:\Users\dinkumar15> docker run --name latestredis -d -p6379:6379 redis


docker ps

docker stop <container id>

docker ps -a
all availavle

docker start <container>

Remove
docker rm <c.id>

pull specific version
docker pull redis:6.2.7
docker run --name old-redis -d -p6378:6379 redis

docker inspect <c.id>

go inside container and run command
docker exec -it <c.id> /bin/sh

ls
exit

docker images

remove images
docker rmi

remove all
docker system prune -a


docker build -t dineshnithdocker/serviceregistry:0.0.1 .

docker run -d -p8761:8761 --name serviceregistry ab5deeaa0de3806b810af4075532eea54be385c03f2de3b7dbdd97e9f13952e2

docker build -t dineshnithdocker/cloudgateway:0.0.1 .
docker build -t dineshnithdocker/configserver:0.0.1 .


kubectl apply -f .\k8s\
kubectl delete -f .\k8s\

Build Docker Images:
Clear images
docker system prune -a

Build Images:
docker build -t dineshnithdocker/serviceregistry:0.0.1 .
docker build -t dineshnithdocker/cloudgateway:0.0.1 .
docker build -t dineshnithdocker/configserver:0.0.1 .

docker build -t dineshnithdocker/orderservice:0.0.1 .
docker build -t dineshnithdocker/paymentservice:0.0.1 .
docker build -t dineshnithdocker/productservice:0.0.1 .


docker build -t dineshnithdocker/serviceregistry:latest .
docker build -t dineshnithdocker/cloudgateway:latest .
docker build -t dineshnithdocker/configserver:latest .

docker build -t dineshnithdocker/orderservice:latest .
docker build -t dineshnithdocker/paymentservice:latest .
docker build -t dineshnithdocker/productservice:latest .


git push dineshnithdocker/orderservice:0.0.1

Create Docker compose to run these images

Run docker compose file

docker compose -f docker-compose.yml up

Delete everything
docker compose -f docker-compose.yml down


jib build

mvn clean install jib:build



Remove Images
docker rm <image id>



curl --location 'https://dev-07651813-admin.okta.com/oauth2/default/v1/token' \
--header 'Content-type: application/x-www-form-urlencoded' \
--header 'User-Agent: Mozilla/5.0 ($systemInformation) $platform ($platformDetails) $extensions' \
--header 'Cookie: DT=DI1sZ5ac3ArTISnQBQI_M7BhA; JSESSIONID=2639D281FBC1D791CD36365E1CCAE1EF; t=default' \
--data-urlencode 'client_id=0oadywmin5oLug5fU5d7' \
--data-urlencode 'client_secret=a3l7d_iJoZItGCHtnnXTyCbcdh1DcOnB-gOTA8th4G97Tl9tZPNaT81gYet4lgcG' \
--data-urlencode 'grant_type=password'.


Redirect

https://localhost:9090/login/oauth2/code/okta


Redis:

docker run --name latestredis -d -p6379:6379 redis




Kubernetes


minikube start
minikube status
kubectl get all

kubectl get namespaces
kubectl get pods
kubectl get deployment
kubectl get services

kubectl delete all --all
#get all resources
kubectl get services

Create Deployment
kubectl create deployment nginx --image=ngnix
creae pods as well as deployment and replica set
#get more info
kubectl get all -o wide
kubectl describe deployment nginx

Check logs
kubectl get pods
kubectl logs <pod name>
#Go inside pod
kubectl exec -it <pod name> --/bin/bash
# Edit deployment
kubectl edit deployment
#delete nginx
kubectl delete deployment nginx

#
kubectl apply -f .\deploy.yaml
kubectl apply -f .\deploy.yaml -n my-namespace
kubectl delete -f .\deploy.yaml
kubectl get all

Kubernetes namespaces:
virtual cluster inside kubernetes cluster

kubectl create namespace my-namespace
kubectl get namespace
kubectl get all -n my-namespace


minikube addons list


minikube service eureka-lb



Installing Jenkins and Other apps
1. Install Java 11
   sudo apt-get install openjdk-11-jdk

2. Install Jenkins using the below steps.
   curl -fsSL https://pkg.jenkins.io/debian-stable/jenkins.io.key |
   sudo tee \
   /usr/share/keyrings/jenkins-keyring.asc > /dev/null
   echo deb [signed-by=/usr/share/keyrings/jenkins-keyring.asc] \
   https://pkg.jenkins.io/debian-stable binary/ | sudo tee \
   /etc/apt/sources.list.d/jenkins.list > /dev/null

sudo apt-get update
sudo apt-get install jenkins

3. Install git which is required :
   sudo apt-get install git
4. Install kubectl
   sudo apt-get install kubectl

sudo cat <>
to get  jenkins password

manage jenkins -> global-> git-> path-> /usr/bin/git (by terminal command-> which git)
maven 3.8.6 install

manage credentials:
git dev setting- personal acess token- repo,admin repo hook permission

Jenkins should have access to kubernetes
create iam acccount and configure with gcp

ARTIFACT_REGISTRY
CLUSTOERNAME
PROJECT_ID
REGISTRY_URL
ZONE us-west-4



,


