@echo off
echo Compilazione...

if not exist out mkdir out

javac -d out -sourcepath src ^
  src\strutture_vector\Coda.java ^
  src\strutture_vector\Pila.java ^
  src\model\Ordine.java ^
  src\CLI\CodaOrdini.java ^
  src\CLI\Utility.java ^
  src\CLI\GestoreFile.java ^
  src\GUI\MainGUI.java ^
  src\GUI\MenuGui.java ^
  src\GUI\PanelHome.java ^
  src\GUI\PanelEstraiOrdine.java ^
  src\GUI\PanelFiltraTavolo.java ^
  src\GUI\PanelGuidaUtente.java ^
  src\GUI\PanelListinoPrezzi.java ^
  src\GUI\PanelOrdinazioni.java ^
  src\GUI\PanelOrdinazioniPerTavolo.java ^
  src\GUI\PanelSalvaOrdini.java ^
  src\GUI\PanelTuttiOrdini.java ^
  src\GUI\PanelCaricaOrdini.java

if errorlevel 1 (
  echo.
  echo Compilazione fallita.
  pause
  exit /b 1
)

echo.
echo Fatto. Avvia con:
echo java -cp out GUI.MainGUI
pause
