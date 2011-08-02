<html xmlns:s="/struts-tags">
<body>
	<h3>Adicionar tarefas</h3>
	<form action="adicionaTarefa" method="post">
		Descrição: <br />
		<textarea name="tarefa.descricao" rows="5" cols="100"></textarea><br />
		<s:fielderror fieldName="tarefa.descricao"/>
		<input type="submit" value="Adicionar">
	</form>
</body>
</html>