
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="menu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Pedido</title>
    </head>

    <script>
        function submitForm(opcaoValue) {
            document.getElementById("opcao").value = opcaoValue;
            document.getElementById("cadastroForm").submit();
        }
    </script>

    <body>
        <h1>Cadastro Pedido</h1>
        <table>
            <form id="cadastroForm" name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/PedidoControlador" method="get">
                <input type="hidden" name="opcao" value="${opcao}" />
                <input type="hidden" name="codigoPedido" value="${codigoPedido}" />
                <p><label>Cliente:</label> 
                    <select name="codigoCliente">
                        <c:forEach var="cliente" items="${clientes}">
                            <option value="${cliente.codigoCliente}" ${cliente.codigoCliente == codigoCliente ? 'selected' : ''}>${cliente.nomeCliente}</option>
                        </c:forEach>
                    </select>
                </p>
                <p><label>Data do Pedido:</label> <input type="date" name="dataPedido" value="${dataPedido}" /> </p>
                <p><label>Produtos:</label> 
                    <select name="codigoProduto">
                        <c:forEach var="produto" items="${produtos}">
                            <option value="${produto.codigoProduto}" ${produto.codigoProduto == codigoProduto ? 'selected' : ''}>${produto.nomeProduto}</option>
                        </c:forEach>
                    </select>
                </p>
                <p><label>Quantidade:</label> <input type="number" name="quantidade" value="${quantidade}" size="5" /> </p>
                <p><label>Total:</label> <input type="number" name="totalPedido" value="${totalPedido}" size="10" step="0.01" /> </p>
                <td> 
                    <input type="submit" value="Salvar" name="Salvar" /> 
                </td>
            </form>

            <form name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/PedidoControlador" method="get">
                <td>
                    <input type="submit" value="Cancelar" name="Cancelar" />
                </td>
                <input type="hidden" name="opcao" value="cancelar" />
            </form>
        </table>
        ${mensagem}

        <table border="1">
            <c:if test="${not empty pedidos}">
                <tr>
                    <th>Código</th>
                    <th>Cliente</th>
                    <th>Data</th>
                    <th>Produto</th>
                    <th>Quantidade</th>
                    <th>Total</th>
                    <th>Alterar</th>
                    <th>Excluir</th>
                </tr> 
            </c:if>

            <c:forEach var="pedido" items="${pedidos}">
                <tr>
                    <td>${pedido.codigoPedido}</td>
                    <td>${pedido.nomeCliente}</td>
                    <td>${pedido.dataPedido}</td>
                    <td>${pedido.nomeProduto}</td>
                    <td>${pedido.quantidade}</td>
                    <td>${pedido.totalPedido}</td>
                    <td>
                        <form name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/PedidoControlador" method="get">
                            <input type="hidden" name="codigoPedido" value="${pedido.codigoPedido}" >
                            <input type="hidden" name="codigoCliente" value="${pedido.codigoCliente}" >
                            <input type="hidden" name="dataPedido" value="${pedido.dataPedido}" >
                            <input type="hidden" name="codigoProduto" value="${pedido.codigoProduto}" >
                            <input type="hidden" name="quantidade" value="${pedido.quantidade}" >
                            <input type="hidden" name="totalPedido" value="${pedido.totalPedido}" >
                            <input type="hidden" name="opcao" value="editar" >
                            <button type="submit">Editar</button>
                        </form>    
                    </td>
                    <td>
                        <form name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/PedidoControlador" method="get">
                            <input type="hidden" name="codigoPedido" value="${pedido.codigoPedido}" >
                            <input type="hidden" name="opcao" value="excluir" >
                            <button type="submit">Excluir</button>
                        </form>    
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
