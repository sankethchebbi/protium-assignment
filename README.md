# protium-assignment
> i have to deploy a java web service to aws using docker and local kubernetes and i have to make it highly available so 2-3 pods in k8s. i have to use a crud api service for the same and i have to deploy a website and add auth to it. this is how i think i'll go about this:

- Initialize a java web project. This project has a simple Spring Boot application with one endpoint that returns a greeting message - "Hello World!" - Spring initializr - https://start.spring.io/

- Containerize the Java application using Docker and create a Dockerfile to contain the necessary dependencies and configuration of the application.
- Push the image to a container registry like ECR or DHub.
- Create a k8s deployment that specifies the number of replicas I want to run, in this case, 2-3 pods, since this needs to be HA.
- After that, I'll create a k8s service that exposes the deployment to the internet and using a service like LoadBalancer, I'll distribute the traffic across the pods. Also, configure the k8s for a health check ensuring the pods are responding as expected.
- Deploy a CRUD api service that connects to my java application and exposes the necessary endpoints for CRUD operations.
- Securing the website using an Oauth service like that of google's or GitHub.
- Deploy your website to the Kubernetes cluster and configure it to use the Out provider for authentication. Deploy my site to the cluster and set it up to use and work well with the oath provider.
- I'II use AWS' RDS or DynamoDB as a DB to store and manage data for my CRUD api.

> PS: **Protium** is the folder for implementation only upto CRUD. the v2 has CRUD and the rest.