# RBC 3 App example
This is a siple Spring Boot application that exposes a REST api with few endoints used to demonstrate the repository structure and needed resources in order to be able to deploy to AWS ECS.
This App also shows how to establish a connection with DocumentDB database.

## Configuration
As the target platform is Elastic Container Service (ECS) on AWS, we have a configuration file in JSON format that represents a Task Definition. When we deploy new version, we essentially update the task config with new image version and deploy that config with aws cli.  
In the Task definition file there is a placeholder for the docker image which should not be changed manually as the Deploy stage of the CICD pipeline will overwrite it on the next run.  

# CICD
This repo contains a GH Actions pipeline that does the following:
- Builds app
- Builds docker image
- Tags the image with a commit SHA as well as `latest`
- Pushes the image to the registry
- Deploys the new image to ECS

## Secrets
Required secrets for the pipeline are:
- `DOCUMENTDB_PASSWORD`
- `AWS_ACCOUNT_ID`

There are certain env variables for the app defined in the pipeline file, like DOCUMENTDB_DATABASE, make sure to update these accordingly.  

In order to deploy this app as a separate ECS service you need to open a PR on [rbc3-infra-aws](https://github.com/ProductDock/rbc3-infra-aws) repository, similar to [this one](https://github.com/ProductDock/rbc3-infra-aws/blob/main/terraform/resources/nonprod/ecs.tf#L46).
For the Task Definition config file consult [the docs](https://docs.aws.amazon.com/AmazonECS/latest/developerguide/task_definition_parameters.html)
