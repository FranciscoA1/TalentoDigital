@echo off
set K6_WEB_DASHBOARD=true
set K6_WEB_DASHBOARD_EXPORT=resultados/reporte.html
k6 run src/load.js
pause
