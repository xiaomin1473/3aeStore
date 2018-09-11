$(function(){
    //marked插件的基本配置
    marked.setOptions({
        renderer: new marked.Renderer(),
        gfm: true,
        tables: true,
        breaks: false,
        pedantic: false,
        sanitize: false,
        smartLists: true,
        smartypants: false,
        highlight: function (code,lang) {
            //使用 highlight 插件解析文档中代码部分
            return hljs.highlightAuto(code,[lang]).value;
        },
        mermaid = function (code, language) {
            if(code.match(/^sequenceDiagram/)||code.match(/^graph/)){
               return '<div class="mermaid">'+code+'</div>';
            }
        }
    });

    $.ajax({
		type:"get",
		url : "./README.md",
		async : true,
		dataType:"text",
		success : function(response,status,request) {
            
			$("#container").html(marked(response));

			//渲染文档中代码部分
			hljs.initHighlighting();

			//给生成的文档中统一添加样式
			$("table").addClass("table");
		}
	});
});