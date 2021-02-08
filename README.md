# foodie
microservice attempt


start PG admin

docker run -d \
	-e POSTGRES_USER=foodie \
	-e POSTGRES_PASSWORD=foodie \
	-e POSTGRES_DB=foodie \
	-p 5432:5432 \
	postgres:13
