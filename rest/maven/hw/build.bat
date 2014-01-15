set groupId=resources
set artifactid=hw
mvn archetype:generate -DgroupId=%groupId% -DartifactId=%artifactId% -DarchetypeArtifactId=jersey-quickstart-webapp -DarchetypeGroupId=org.glassfish.jersey.archetypes -DinteractiveMode=false -DarchetypeVersion=2.4.1
rem mvn archetype:generate -DgroupId=%groupId% -DartifactId=%artifactId% -DarchetypeArtifactId=jersey-quickstart-webapp -DarchetypeGroupId=org.glassfish.jersey.archetypes -DinteractiveMode=false -Dpackage=HelloWorld -DarchetypeVersion=2.4.1
