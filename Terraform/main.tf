module "vpc" {
  source   = "./vpc"
  vpc_name = "localstack-vpc"
}

module "s3" {
  source = "./s3"
  bucket_name = "s3-test-bucket-victoria"
}

module "ec2" {
  source        = "./ec2"
  instance_name = "minikube-test-instance"
  vpc_id        = module.vpc.vpc_id
}