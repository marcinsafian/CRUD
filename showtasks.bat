call runcrud.bat
if "%ERRORLEVEL%" == "0" goto browser
echo.
echo There were problems with running script.
goto fail


:browser
explorer "http://localhost:8080/crud/v1/task/getTasks"
timeout 30
if "%ERRORLEVEL%" == "0" goto end
echo.
echo There were problems with running browser.
goto fail

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished