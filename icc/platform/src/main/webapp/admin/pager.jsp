<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${pageUtil != null && pageUtil.lastPage>1}">
<!-- page include start  -->
			<div class="pagenation_bar" id="pager_box" data-pages="${pageUtil.pageSize}" >
		      <div class="page tal">
		        <div class="left">共<span class="red">${pageUtil.lastPage}</span>页
		          &nbsp;&nbsp;&nbsp;&nbsp;
		          共 <span class="red"> ${pageUtil.totalCount} </span> 条记录
		          &nbsp;&nbsp; </div>

		        <div class="right">
					<c:choose>
						<c:when test="${pageUtil eq null || pageUtil.curPage <= 1}">
							<a class="disabled">&lt;&lt;</a>
						</c:when>
						<c:otherwise>
							<a href="javascript:toPage('1')">&lt;&lt;</a>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${pageUtil eq null || pageUtil.curPage <= 1}">
							<a class="disabled" >&lt;</a>
						</c:when>
						<c:otherwise>
							<a href="javascript:toPage('${pageUtil.curPage-1 }')">&lt;</a>
						</c:otherwise>
					</c:choose>
					<c:set var="liststep" value="8"></c:set>
					<c:set var="begin" value="${pageUtil.curPage - (liststep/2)}"></c:set>
					<c:if test="${begin<1}">
					<c:set var="begin" value="1"></c:set>
					</c:if>
					<c:set var="end" value="${pageUtil.curPage + (liststep/2)}"></c:set>
					<c:if test="${pageUtil eq null || end > pageUtil.lastPage}">
					<c:set var="end" value="${pageUtil.lastPage}"></c:set>
					</c:if>
					<c:forEach var="x" begin="${begin}" end="${end}">
					   <c:choose>
							<c:when test="${pageUtil.curPage eq x}">
								<a href="javascript:;" class="current">${x }</a>
							</c:when>
							<c:otherwise>
								<a href="javascript:toPage('${x }');">${x }</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:choose>
						<c:when test="${pageUtil.curPage >= pageUtil.lastPage}">
							<a class="disabled" >&gt;</a>
						</c:when>
						<c:otherwise>
							<a href="javascript:toPage('${pageUtil.curPage+1 }')">&gt;</a>
						</c:otherwise>
					</c:choose>
					<c:choose>
							<c:when test="${pageUtil.curPage >= pageUtil.lastPage}">
								<a class="disabled" >&gt;&gt;</a>
							</c:when>
							<c:otherwise>
								<a href="javascript:toPage('${pageUtil.lastPage }')">&gt;&gt;</a>
							</c:otherwise>
						</c:choose>

		        	<span class="page_input">第&nbsp;
			          <input class="tac" type="text" id="pager_pnum" value="${pageUtil.curPage}">
			          &nbsp;页&nbsp;
			          <input type="hidden" id="pager_count" value="${pageUtil.lastPage}">
			          <input type="button" value="确定" id="pager_submit_btn" class="btn sub_btn" onclick="goPage()"/>
		          	</span>
		         </div>
		      </div>

		      <script>
			     function goPage(){
				 	var count = $("#pager_count").val();
				 	if(count == ""){
						return;
				 	}
					var pnum = $("#pager_pnum").val();
				  	if(isNaN(pnum)){
					  	opcAlert("请输入正确的页数");
					  	return;
					}
					if(pnum<1){
						pnum = 1;
					}else if(pnum>count){
						pnum = count;
					}
					toPage(pnum);
				 }
		      </script>

		    </div>
</c:if>
		    <!-- page include end  -->