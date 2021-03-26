<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="resources/css/bootstrap.min.css">
        <link rel="stylesheet" href="//cdn.datatables.net/1.10.23/css/jquery.dataTables.min.css">
        <title>Consulta de Clientes</title>
    </head>
    <body>
        <c:if test="${not empty msg_ok}">
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                <strong>Sucesso!</strong> ${msg_ok}
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>

        <c:if test="${not empty msg_erro}">
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <strong>Erro!</strong> ${msg_erro}
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>
        <div class="container mt-4">
            <h1>Consulta de Clientes</h1>
            <a href="/ProjetoWeb01/">Página inicial</a>
            <hr/>

            <table id="myTable" class="table table-hover table-striped table-secondary">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Email</th>
                        <th>Operações</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="cliente" items="${clientes}">
                    <tr>
                        <td>${cliente.nome}</td>
                        <td>${cliente.email}</td>
                        <td>
                            <a href="/ProjetoWeb01/edicao-cliente?id=${cliente.idCliente}" class="btn btn-primary btn-sm">
                                Atualizar
                            </a>
                            <a href="/ProjetoWeb01/excluir-cliente?id=${cliente.idCliente}" class="btn btn-danger btn-sm"
                            onclick="return window.confirm('Deseja realmente excluir esse cliente?')">
                                Excluir
                            </a>
                        </td>
                    </tr>
                 </c:forEach>
                </tbody>
                <tfooter>
                    <tr>
                        <td colspan="3">
                            Quantidade de clientes obtidos: ${clientes.size()}
                        </td>
                    </tr>
                </tfooter>
            </table>
        </div>
        <script src="resources/js/jquery-3.5.1.min.js"></script>
        <script src="resources/js/bootstrap.min.js"></script>
        <script src="//cdn.datatables.net/1.10.23/js/jquery.dataTables.min.js"></script>
        <script src="//cdn.datatables.net/plug-ins/1.10.22/i18n/Portuguese-Brasil.json"></script>
        <script>
                    $(document).ready( function () {
                        $('#myTable').DataTable({
                            lengthMenu: [ 5, 10, 25, 50 ],
                            language: {
                                url : '//cdn.datatables.net/plug-ins/1.10.22/i18n/Portuguese-Brasil.json'
                            }
                        });
                    });
                </script>
    </body>
</html>