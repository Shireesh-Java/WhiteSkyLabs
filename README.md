WhiteSkyLabs
============

Rest Application For Palindrome Play

How To Test Rest Application :

Normally, testing a web application involves compiling Java sources, creating a WAR and deploying it to a web container.

Jetty Plugin enables to quickly test web application by skipping the last two steps. By default the Jetty Plugin scans target/classes for any changes in  Java sources and src/main/webapp for changes to web sources. The Jetty Plugin will automatically reload the modified classes and web sources.

1. Download the project.

2.Eclipse :  Import the project as Maven Project

3. Build The Project
    Right Click On Project : Run As : Maven Clean
    Right Click On Porject : Run As : Maven Install

4.Right Click On Project :Run As : Run Configurations
   Add New Launch Configuration under Maven Build
       Right Click On Maven Build : New
       Under Base Directory : Use Browse Workspace to select the project.(ie.skylab.palindrome)
       Under Goals : jetty:run
       
   Apply
   Run


This will start jetty and expose the service on localhost:8080

5. Go to Browser and Play

    http://localhost:8080/palindrome/rest/game/palindrome?user=Shireesh&palindrome=Madam

    http://localhost:8080/palindrome/rest/game/palindrome?user=Shireesh&palindrome=gig

   http://localhost:8080/palindrome/rest/game/palindrome?user=Vinay&palindrome=gig
