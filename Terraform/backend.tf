terraform {
  backend "s3" {
    bucket         = "s3-test-bucket-victoria"
    key            = "minikube-setup/terraform.tfstate"
    region         = "us-east-1"
    access_key     = "test"
    secret_key     = "test"
    skip_credentials_validation = true
    skip_metadata_api_check     = true
  }
}
