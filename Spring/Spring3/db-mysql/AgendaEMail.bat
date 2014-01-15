set MYSQL_HOME=d:\mysql-5.5.8-winx64\bin
set path=%MYSQL_HOME%;%PATH%
mysql -u root < CreateAgendaE.sql
mysql -u root < ValuesAgendaE.sql