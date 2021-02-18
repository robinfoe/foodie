.DEFAULT_GOAL := help


# image build vars
IMAGE_BUILDER ?= foodie-openjdk11/alpine
IMAGE_BUILDER_VERSION ?= 1.0

IMAGE_CONSUMER ?= foodie-consumer
IMAGE_CONSUMER_VERSION ?= 1.0

IMAGE_RESTAURANT ?= foodie-restaurant
IMAGE_RESTAURANT_VERSION ?= 1.0

IMAGE_ORDER ?= foodie-order
IMAGE_ORDER_VERSION ?= 1.0

IMAGE_KITCHEN ?= foodie-kitchen
IMAGE_KITCHEN_VERSION ?= 1.0


.PHONY: help
#help: @ List available tasks on this project
help:
	@echo "tasks:"
	@grep -E '[a-zA-Z\.\-]+:.*?@ .*$$' $(MAKEFILE_LIST)| tr -d '#' | awk 'BEGIN {FS = ":.*?@ "}; {printf "\t\033[32m%-30s\033[0m %s\n", $$1, $$2}'
	@echo
	


#build.builder: @ Create builder image with maven cache 
build.builder:
	docker build ./ -t $(IMAGE_BUILDER):$(IMAGE_BUILDER_VERSION) -f ./Dockerfile.builder

#build.consumer: @ Compile and create consumer image  
build.consumer:
	docker build ./ -t $(IMAGE_CONSUMER):$(IMAGE_CONSUMER_VERSION) -f ./consumer/Dockerfile

#build.restaurant: @ Compile and create restaurant image  
build.restaurant:
	docker build ./ -t $(IMAGE_RESTAURANT):$(IMAGE_RESTAURANT_VERSION) -f ./restaurant/Dockerfile

#build.order: @ Compile and create order image  
build.order:
	docker build ./ -t $(IMAGE_ORDER):$(IMAGE_ORDER_VERSION) -f ./order/Dockerfile

#build.kitchen: @ Compile and create kitchen image  
build.kitchen:
	docker build ./ -t $(IMAGE_KITCHEN):$(IMAGE_KITCHEN_VERSION) -f ./kitchen/Dockerfile



#build.all: @ Compile and create all images image  
build.all: build.consumer build.restaurant build.order build.kitchen
	
#delete.builder: @ Remove builder image
delete.builder:
	docker rmi --force $(IMAGE_BUILDER):$(IMAGE_BUILDER_VERSION)


#delete.consumer: @ Delete consumer image  
delete.consumer:
	docker rmi --force $(IMAGE_CONSUMER):$(IMAGE_CONSUMER_VERSION)

#delete.restaurant: @ Delete restaurant image  
delete.restaurant:
	docker rmi --force $(IMAGE_CONSUMER):$(IMAGE_CONSUMER_VERSION)

#delete.order: @ Delete order image  
delete.order:
	docker rmi --force $(IMAGE_ORDER):$(IMAGE_ORDER_VERSION)

#delete.kitchen: @ Delete kitchen image  
delete.kitchen:
	docker rmi --force $(IMAGE_KITCHEN):$(IMAGE_KITCHEN_VERSION)


#delete.all: @ Delete all images  
delete.all: delete.consumer delete.restaurant delete.order delete.kitchen
	

#compose.up: @ Start microservices
compose.up:
	docker-compose up -d 

#compose.down: @ Stop microservices
compose.down:
	docker-compose down 


