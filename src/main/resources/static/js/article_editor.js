/**
 *@author :hly
 *@github :github.com/SiriusHly
 @blog :blog.csdn.net/Sirius_hly
 *@date :2018/10/13
 */

$(document).ready(function () {

    /*提交文章函数和方法*/

    $('#submit_article').click(function () {
        submit_article();
        //alert("提交文章");
    });

    //提交文章到后端
    function submit_article() {

        var categoryList = [];

        //获取所有复选
        $.each($('input:checkbox:checked'),function(){
            categoryList.push($(this).val());
        });

        //获取所有input
        $.each($("input[name='inputCategory']"),function () {
            categoryList.push($(this).val());
        });

        //alert(categoryList);

        var articleTitle = $("#article_title").val();
        var articleContent = $("#editor-md-doc").val();
        $.ajax({
            url: "/articleWritingSubmit",
            /*这里属性名字和后端一直就行，顺序无所谓*/
            data: JSON.stringify({
                article:{
                    articleTitle: articleTitle,
                    articleContent: articleContent
                },
                categoryList:categoryList
            }),
            type: "POST",
            contentType: 'application/json',
            success: function () {
                alert("发布成功" + articleContent);

            },
            error: function () {
                alert("发布失败");
            }
        });
    }

    //添加分类
        $('.add-type').click(function () {
            var tpye = '<div class="input-category">'+
                '<input type="text" placeholder="输入分类" name="inputCategory">'+
                '<i class="del fa fa-remove">'+'</i>'+
                '</div>';
            $('.add-category').prepend(tpye);
            $(".input-category input").focus();
            // 删除表单
            $('.del').click(function () {
                $(this).parent().remove();
            });
        });


});

