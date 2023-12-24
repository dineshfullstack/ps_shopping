pipeline {
    agent any
    environment {
        AWS_ACCESS_KEY_ID = credentials('AWS_ACCESS_KEY_ID')
        AWS_SECRET_ACCESS_KEY = credentials('AWS_SECRET_ACCESS_KEY')
        AWS_DEFAULT_REGION = "us-east-1"
    }
    stages {
        stage("Deploy to EKS") {
            steps {
                script {
                    //dir('part2-cluster-from-terraform-and-jenkins/kubernetes') {
                        sh "aws eks update-kubeconfig --name myjenkins-server-eks-cluster --region us-east-1"
                        sh "kubectl delete -f k8s_ecr"
                        
                  //  }
                }
            }
        }
    }
}
