1. Se calibreaza fisierul build.xml cu locatia aplicatiei GAE

    
    <copy todir="${war.dir}">
      <fileset dir="src">
        <include name="*.jsp"/>
      </fileset>
    </copy>  
    
3. Se executa myant
4. Se lanseaza gae.bat
5. http://localhost:8080/agendae.jsp sau http://localhost:8080
