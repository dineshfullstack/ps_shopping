#!/bin/bash

# Variables
REGION="us-east-1" # Replace with your desired AWS region
ACCOUNT_ID="582345415283" # Replace with your AWS account ID
REPOSITORY_NAME="paymentservice"
IMAGE_NAME="paymentservice"
TAG="latest"


#aws ecr get-login-password --region us-east-1 | docker login --username AWS --password-stdin #//582345415283.dkr.ecr.us-east-1.amazonaws.com

# Authenticate Docker to your ECR registry
aws ecr get-login-password --region "$REGION" | docker login --username AWS --password-stdin "$ACCOUNT_ID".dkr.ecr."$REGION".amazonaws.com

#create repo if not exists

aws ecr describe-repositories --repository-names ${REPOSITORY_NAME} || aws ecr create-repository --repository-name ${REPOSITORY_NAME}

# Build your Docker image
docker build -t "$IMAGE_NAME" .

# Tag your Docker image
docker tag "$IMAGE_NAME":"$TAG" "$ACCOUNT_ID".dkr.ecr."$REGION".amazonaws.com/"$REPOSITORY_NAME":"$TAG"

# Push the Docker image to ECR
docker push "$ACCOUNT_ID".dkr.ecr."$REGION".amazonaws.com/"$REPOSITORY_NAME":"$TAG"

#chmod +x push-to-ecr.sh
#./push-to-ecr.sh


echo "All done! Success! "