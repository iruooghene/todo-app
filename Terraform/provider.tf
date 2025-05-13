terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 5.0"
    }
  }
}

provider "kubernetes" {
  config_path = "/home/victoria/.kube/config"
}


provider "aws" {
  region                      = "us-east-1"
  skip_credentials_validation = true
  skip_metadata_api_check     = true
  skip_requesting_account_id  = true

  endpoints {
    s3   = "http://localhost:4566"
    eks  = "http://localhost:4566"
    iam  = "http://localhost:4566"
    ec2  = "http://localhost:4566"
  }
}