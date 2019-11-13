<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="../jsp/common/head.jsp"%>

<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>订单商管理页面</span>
    </div>
    <div class="search">
        <form method="get" action="${pageContext.request.contextPath }/provider/providersave.html">
            <input name="method" value="query" type="hidden">
            <span>账单编码：</span>
            <input name="billCode" type="text" value="${billCode }">

            <span>商品名称：</span>
            <input name="productName" type="text" value="${productName }">

            <input value="查 询" type="submit" id="searchbutton">
        </form>
    </div>
    <!--供应商操作表格-->
    <table class="providerTable" cellpadding="0" cellspacing="0">
        <tr class="firstTr">
            <th width="10%">账单编码</th>
            <th width="20%">商品名称</th>
            <th width="10%">商品描述</th>
            <th width="10%">商品单位</th>
            <th width="10%">商品数量</th>
            <th width="10%">商品总额</th>
            <th width="10%">支付状态</th>
            <th width="10%">创建者</th>
            <th width="10%">创建时间</th>
            <th width="30%">操作</th>
        </tr>
        <c:forEach var="provider" items="${billList }" varStatus="status">
            <tr>
                <td>
                    <span>${provider.billCode }</span>
                </td>
                <td>
                    <span>${provider.productName }</span>
                </td>
                <td>
                    <span>${provider.productDesc}</span>
                </td>
                <td>
                    <span>${provider.productUnit}</span>
                </td>
                <td>
                    <span>${provider.productCount}</span>
                </td>
                <td>
                    <span>${provider.totalPrice}</span>
                </td>
                <td>
                    <span>${provider.isPayment}</span>
                </td>
                <td>
					<span>
					<fmt:formatDate value="${provider.creationDate}" pattern="yyyy-MM-dd"/>
					</span>
                </td>
                <td>
                    <span><a class="viewProvider" href="javascript:;" proid=${provider.id } proname=${provider.proName }><img src="${pageContext.request.contextPath }/statics/images/read.png" alt="查看" title="查看"/></a></span>
                    <span><a class="modifyProvider" href="javascript:;" proid=${provider.id } proname=${provider.proName }><img src="${pageContext.request.contextPath }/statics/images/xiugai.png" alt="修改" title="修改"/></a></span>
                    <span><a class="deleteProvider" href="javascript:;" proid=${provider.id } proname=${provider.proName }><img src="${pageContext.request.contextPath }/statics/images/schu.png" alt="删除" title="删除"/></a></span>
                </td>
            </tr>
        </c:forEach>
    </table>
    <input type="hidden" id="totalPageCount" value="${totalPageCount}"/>
    <c:import url="rollpage.jsp">
        <c:param name="totalCount" value="${totalCount}"/>
        <c:param name="currentPageNo" value="${currentPageNo}"/>
        <c:param name="totalPageCount" value="${totalPageCount}"/>
    </c:import>
</div>
</section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeProv">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain" >
            <p>你确定要删除该供应商吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>

<%@include file="../jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/providerlist.js"></script>
