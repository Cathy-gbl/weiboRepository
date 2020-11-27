var ice = "http://localhost:8080/";
$(function(){
    getHotContent();
});

// function login() {
//     let username = $("#username").val();
//     let password = $("#password").val();
//     $.ajax({
//         url: ice+"user/login",
//         async: true,
//         type:"post",
//         dataType:"json",
//         data:{
//             username:username,
//             password:password
//         },
//         success: function(result){
//             if(result.code == 200){
//                 window.location.href="user/success";
//             }else {
//                 alert(result.msg);
//             }
//
//
//         }});
//
// }

/**
 * 查询全部的热点信息
 */
function getHotContent() {
    $.ajax({
        url: ice+"common/getHotContent",
        async: true,
        type:"post",
        dataType:"json",
        success: function(result){
            if(result.code == 200){
                let resultdata = result.data;
                let spanHtml = "";
                let resultHtml = "";
                let rankTitleHtml = "";
                let rankTitleIdHtml = "";
                resultdata.length = resultdata.length < 5 ? resultdata.length : 4;
                for (let i = 0; i < resultdata.length; i++) {
                    resultHtml += "<a href="+resultdata[i].number+">"+resultdata[i].tital+"</a>";
                    spanHtml += "<div><h2><a href='/common/hotContentXq?params="+resultdata[i].number+"'>"+resultdata[i].tital+"</a></h2></div>";
                    rankTitleHtml += "<div><div class='rank_pic'></div>"+
                        "<a href='/common/hotContentXq?params="+resultdata[i].number+"'>#"+resultdata[i].tital.substring(0,4)+"#</a>"+
                        "<div class='rank_txt'>"+resultdata[i].tital+"</div>"+
                        "</div>";
                    rankTitleIdHtml += "<div>"+
                        "<div class='rank_hot_pic'></div>"+
                        "<a href='/common/hotContentXq?params="+resultdata[i].number+"'>#"+resultdata[i].tital.substring(0,6)+"#</a>"+
                        "<div class='rank_txt'>"+resultdata[i].tital+"</div>"+
                        "</div>";
                }
                // rankTitleHtml+="<div class='rank_more'>查看更多></div>";
                // rankTitleIdHtml+="<div class='rank_more'>查看更多></div>";
                $(".search_more").html(resultHtml);
                $("#hotContentXq").html(spanHtml);
                $(".rank_title").html(rankTitleHtml);
                $("#rank_title").html(rankTitleIdHtml);
            }
        }});
}

/**
 * 模糊搜素热点信息
 */
function getHotContentByLike() {
    let hotContent = $(".search_input").val();
    $.ajax({
        url: ice+"common/getHotContentByLike",
        async: true,
        contentType: "application/x-www-form-urlencoded;charset=UTF-8",
        type:"post",
        dataType:"json",
        data: {
            hotContent : hotContent
        },
        success: function(result){
            console.log(result)
            if(result.code == 200){
                let resultdata = result.data;
                let spanHtml = "";
                let resultHtml = "";
                for (let i = 0; i < resultdata.length; i++) {
                    resultHtml += "<a href="+resultdata[i].number+">"+resultdata[i].tital+"</a>";
                    console.log(resultHtml)
                    spanHtml += "<div><a href='/common/hotContentXq?params="+resultdata[i].number+"'>"+resultdata[i].tital+"</a></div>";
                }
                $(".search_more").html(resultHtml);
                $("#hotContentXq").html(spanHtml);
            }
        }});
}
