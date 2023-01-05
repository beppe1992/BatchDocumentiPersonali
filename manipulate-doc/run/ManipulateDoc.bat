for /f "delims=" %%x in ('dir /od /b manipulate-doc-*-jar-with-dependencies.jar') do set latestjar=%%x
echo %latestjar% 
java -classpath config -jar %latestjar% REMOVE_FILIGRANA_TESTO_SPECIFICO
set exitcode=%ERRORLEVEL%
echo "Exit Code: %exitcode%"

pause

exit %exitcode%