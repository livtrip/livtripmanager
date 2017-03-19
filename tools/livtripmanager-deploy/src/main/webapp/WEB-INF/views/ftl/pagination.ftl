[#escape x as x?html]
<input type="hidden" id="pageSize" name="pageSize" value="${page.pageSize}" />
<input type="hidden" id="pageNumber" name="pageNumber" value="${page.pageNum}" />
<nav>
    <ul class="pager">
        [#if  page.isFirstPage]
            <li class="previous disabled"> <a href="#">&larr;上一页</a></li>
        [#else]
            <li class="previous"> <a href="javascript: $.pageSkip(${page.prePage});">&larr;上一页</a></li>
        [/#if]
        [#if  page.isLastPage]
            <li class="next disabled"><a href="#">下一页 &rarr;</a></li>
        [#else]
            <li class="next"><a href="javascript: $.pageSkip(${page.nextPage});">下一页 &rarr;</a></li>
        [/#if]
    </ul>
</nav>
[/#escape]