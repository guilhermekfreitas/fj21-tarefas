<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Adicionando lib do JQuery -->
<script type="text/javascript" src="js/jquery.js"></script>
</head>
<body>

<script type="text/javascript">
	function finalizaAgora(id) {
		alert(id);
		$.post('bemvindo.jsp');
		//$.post('finalizaTarefa', {'id' : id}, function(dados) {
			// selecionando o elemento html através da ID e alterando o HTML dele
	//		$("#tarefa"+id).html("Tarefa finalizada");
		//});		
	}
	function removeTarefa(id) {
        $.post("removeTarefa", {'id' : id}, function(dados) {
                // selecionando o elemento html através da ID e alterando o HTML dele
                $(this).closest("tr").hide();
        });
	}
</script>



	<a href="formulario-tarefas.jsp">Adicionar nova tarefa</a>

	<br />
	<br />

	<table>
		<tr>
			<th>Id</th>
			<th>Descrição</th>
			<th>Finalizado?</th>
			<th>Data de Finalização</th>
			<th>Alterar?</th>
			<th>Remover?</th>
		</tr>
		<c:forEach items="${tarefas}" var="tarefa">
			<tr>
				<td>${tarefa.id}</td>
				<td>${tarefa.descricao}</td>
				<c:if test="${tarefa.finalizado eq false}">
					<td bgcolor="red" id="tarefa${tarefa.id}">
                        <a href="#" onClick="finalizaAgora(${tarefa.id})"> Finaliza agora!</a>
                    </td>
				</c:if>
				<c:if test="${tarefa.finalizado eq true}">
					<td>Finalizado</td>
				</c:if>
				<td><fmt:formatDate value="${tarefa.dataFinalizacao.time}"
						pattern="dd/MM/yyyy" /></td>
				<td><a href="mostraTarefa?tarefa.id=${tarefa.id}">Alterar</a></td>
				<td><a href="#" onClick="removeTarefa(${tarefa.id})">Remover</a></td>
				<!-- <td><a href="removeTarefa?tarefa.id=${tarefa.id}">Remover</a></td> -->
			</tr>
		</c:forEach>
	</table>
</body>
</html>