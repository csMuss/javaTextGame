@echo off
REM Yello Color for the console win
color E
REM Target the java file, if the file is renamed OR in a different directory than this launcher
REM It will fail
java -jar Kronk.jar %*
pause