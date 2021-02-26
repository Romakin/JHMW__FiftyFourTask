docker pull mysql/mysql-server

docker run -p 3306:3306 --env MYSQL_ROOT_HOST=% --name mysqlTest -e MYSQL_ROOT_HOST=% mysql/mysql-server:latest

echo 'Here is your once password to connect:'
docker logs mysqlTest 2>&1 | grep GENERATED

echo 'Next Steps:'
echo "1. Run command \"docker exec -it mysqlTest mysql -u root -p\" and put password there"
echo "2. When opens mysql cmd put \"ALTER USER 'root'@'localhost' IDENTIFIED BY 'Passw0rd';\""
echo "3. Then \"ALTER USER 'root'@'%' IDENTIFIED WITH mysql_native_password BY 'Passw0rd';\""
echo "3. Create DB \"CREATE DATABASE myDB;\" "
echo "4. GRANT priveleges \"GRANT ALL PRIVILEGES ON *.* TO 'root'@'%';\" "