<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body>
<form action ="inserisciTransazione" method = "POST">
<h1>Inserisci transazione</h1>
<h4>Inserisci la tua transazione comilando i seguenti campi</h4>
<p>Data(gg/mm/aaaa):</p>
 <input type="text" name="data">
<p>Categoria:</p>
 <input type="text" name="categoria">
<p>Importo:</p>
<input type="text" name="importo"><h1>$$$</h1>
<p>Descrizione:</p>
 <input type="text" name="descrizione">
   <br>
   <br>
 <input type="submit" value ="inserisciTransazione">
</form>
</body>
</html>