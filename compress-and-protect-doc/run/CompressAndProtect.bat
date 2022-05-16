for /f "delims=" %%x in ('dir /od /b compress-and-protect-doc-*-jar-with-dependencies.jar') do set latestjar=%%x
echo %latestjar% 
java -classpath config -jar %latestjar% ONLY_PROTECT
set exitcode=%ERRORLEVEL%
echo "Exit Code: %exitcode%"

pause

exit %exitcode%