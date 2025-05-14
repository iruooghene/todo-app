# S3 Bucket for Terraform State (LocalStack)
resource "aws_s3_bucket" "tf_state" {
  bucket = "todoapp-tf-state-local"
}

# # VPC (simplified for LocalStack)
# resource "aws_vpc" "main" {
#   cidr_block = "10.0.0.0/16"
# }
#
# # Subnet
# resource "aws_subnet" "main" {
#   vpc_id     = aws_vpc.main.id
#   cidr_block = "10.0.1.0/24"
# }
#
# # Security Group
# resource "aws_security_group" "main_sg" {
#   name        = "main-security-group"
#   description = "Allow all traffic (for testing)"
#   vpc_id      = aws_vpc.main.id
#
#   ingress {
#     from_port   = 0
#     to_port     = 0
#     protocol    = "-1"
#     cidr_blocks = ["0.0.0.0/0"]
#   }
#
#   egress {
#     from_port   = 0
#     to_port     = 0
#     protocol    = "-1"
#     cidr_blocks = ["0.0.0.0/0"]
#   }
# }
#
# # Internet Gateway
# resource "aws_internet_gateway" "main_igw" {
#   vpc_id = aws_vpc.main.id
# }
#
# # Route Table
# resource "aws_route_table" "main_rt" {
#   vpc_id = aws_vpc.main.id
#
#   route {
#     cidr_block = "0.0.0.0/0"
#     gateway_id = aws_internet_gateway.main_igw.id
#   }
# }
#
# # Route Table Association
# resource "aws_route_table_association" "main_rta" {
#   subnet_id      = aws_subnet.main.id
#   route_table_id = aws_route_table.main_rt.id
# }
