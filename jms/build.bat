D:
cd D:\Java\workspaces\JEE_2019-09\jms\
call mvn clean package
echo on
docker-compose build
docker-compose down -v
docker image prune -f
docker-compose up